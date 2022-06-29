/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverversion;

import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;





public class Functions {
    
    static class validations{
    static boolean EnoughtAmount=true;
    static Vector<Integer> products = new Vector<>();
    public static boolean Login(String email,String password) throws SQLException
    {
        boolean valid=true;
        
        String Query="Select * from person where  Email='"+email+"' and password= '"+password+"'";
        ResultSet rs=DatabaseManipulation.retrieve(Query);
        if(rs.next())
        {
            valid=true;
        }
        else
            valid=false;
        return valid;
                
                
    }
    public static boolean ValidCard(String name_on_Card,String card_number,String CVV,String amount,String date) throws SQLException
    {
            
          boolean valid =  true;
          String Query="Select * from credit_card where  card_number='"+card_number+"' and Name_On_Card= '"+name_on_Card+"'";
          ResultSet rs=DatabaseManipulation.retrieve(Query);
          if(rs.next())
          {
            valid=true;
          }
          else
          {
            valid=false;
          }
          return valid;
    }
        
        
        public static boolean isExist(String email) throws SQLException
    {
        boolean valid=true;
        String Query="Select * from  person where Email='"+email+"'" ;
        ResultSet rs=DatabaseManipulation.retrieve(Query);
        if(rs.next())
        {
            
        }
        else
            valid=false;
        return valid;
    }
    
    //public static boolean SignUp(String name , String email , String phone , String password)
    public static Vector CheckAndSetAmount(Vector<item> items) throws SQLException
    {       
             
            int itemId;
            int amountRequested;
            int amountAv=0;
            EnoughtAmount=true;
            
            for(int i=0;i<items.size();i++)
            {   
                
                itemId=items.get(i).getID();
                amountRequested=items.get(i).getAmount();
                String Query="select amount ,brand from item where id='"+itemId+"'";
                ResultSet rs=DatabaseManipulation.retrieve(Query);
                if(rs.next())
                {
                    amountAv=Integer.valueOf(rs.getString(1));
                    
                    
                }
                if(amountAv>=amountRequested)
                {
                    
                }
                else
                {
                    items.get(i).setAmount(amountAv);  //max available
                    products.add(itemId);
                    EnoughtAmount=false;
                    
                }
                 
            }
            return items;
            
            
    }
    
    
    }
    static class Logic{
        public static synchronized boolean SignUp(String name , String email , String phone , String password) throws SQLException
        {
            
            if(validations.isExist(email))
            {
                return false;
            }
            else
            {
                int id=getMaxId()+1;
                String Query="insert into person values('"+id+"', '"+name+"','"+password+"','"+email+"','"+phone+"')";
                DatabaseManipulation.update(Query);
                return true;
            }
        }
        
        public static int getMaxId() throws SQLException
        {
            String Query="Select MAX(ID) from person" ;
            ResultSet rs=DatabaseManipulation.retrieve(Query);
            rs.next();
            int max=rs.getInt(1);
            return max;
        }
        
        public static Vector retriveClothes() throws SQLException
        {   
            Vector<clothes> records = new Vector<clothes>();
            String Query="Select * from item , clothes where ClotheID=ID" ;
            ResultSet rs=DatabaseManipulation.retrieve(Query);
            records.removeAllElements();
             ResultSetMetaData RSMD = rs.getMetaData();
                    while(rs.next())
                    {       
                        clothes clothe= new clothes();
                        clothe.setID( Integer.valueOf(rs.getString(1)));
                        clothe.setPrice( Integer.valueOf(rs.getString(2)));
                        clothe.setAmount( Integer.valueOf(rs.getString(3)));
                        clothe.setBrand(rs.getString(4));
                        
                        clothe.setSize(rs.getString(6));
                        clothe.setGender(rs.getString(7));
                        clothe.setCOLOR(rs.getString(8));
                        clothe.setTYPE(rs.getString(9));
                        System.out.println("row returned");
                        records.add(clothe);
                        
                    }             
                    
        return records;
        }
        
        public static Vector retriveConsumables() throws SQLException
        {
            Vector<consumables> records = new Vector<consumables>();
            String Query="Select * from item , consumable where consumableID=ID" ;
            ResultSet rs=DatabaseManipulation.retrieve(Query);
            records.removeAllElements();
             ResultSetMetaData RSMD = rs.getMetaData();
                    while(rs.next())
                    {       
                        consumables consumable= new consumables();
                        consumable.setID( Integer.valueOf(rs.getString(1)));
                        consumable.setPrice( Integer.valueOf(rs.getString(2)));
                        consumable.setAmount( Integer.valueOf(rs.getString(3)));
                        consumable.setBrand(rs.getString(4));
                        
                        consumable.setProduction_date(rs.getString(6));
                        System.out.println("row returned");
                        records.add(consumable);    
                    } 
            return records;
        
        
    }
        
        public static synchronized boolean purchase(Vector<item> items) throws SQLException
        {

            validations.CheckAndSetAmount(items);
            if((validations.EnoughtAmount))
            {   
                String Query;
                for(int i=0;i<items.size();i++)
                {
                    Query="update item set Amount=Amount-"+items.get(i).getAmount()+" where ID= "+items.get(i).getID();
                    DatabaseManipulation.update(Query);
                }
                return true;
            }
            else
            {
                return false;
            }

        }
        public static synchronized void UpdatePassword(String email,String password) throws SQLException
        {
            String Query="Select UserID from user where Email='"+email+"'";
            ResultSet rs=DatabaseManipulation.retrieve(Query);
            rs.next();
            int id=rs.getInt(1);
            Query="update person set Password='"+password+"' where ID='"+id+"'";
            DatabaseManipulation.update(Query);
            
        }
        
        public static Vector GetInfo(String email) throws SQLException
        {   
            
            Vector info=new Vector();
            
            String Query="Select * from person where Email='"+email+"'";
            
            ResultSet rs=DatabaseManipulation.retrieve(Query);
            
             ResultSetMetaData RSMD = rs.getMetaData();
             
             rs.next();
             int i=1;
             
                    while(i<7)
                    {       
                        
                        info.add(rs.getString(i));
                        
                        System.out.println(rs.getString(i));
                        
                        i++;
                        
                    }        
                    
           return info;
        }
    }
    static class DatabaseManipulation
    {
            public static ResultSet retrieve(String Query) throws SQLException
    {
        int CC;   
        String name;
        Statement stmt=null;
        ResultSet rs = null;

        Connection con = null;

        String str = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace_database?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","lolbiglol");
        stmt = con.createStatement();
        rs = stmt.executeQuery(Query);
        ResultSetMetaData RSMD = rs.getMetaData();
        CC = RSMD.getColumnCount();
        name=RSMD.getColumnName(1);
        
        return rs;
    
    }
    public static boolean update(String Query) throws SQLException
    {
        Statement stmt=null;
        ResultSet rs = null;


        Connection con = null;

        String str = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace_database?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","lolbiglol");
                
        PreparedStatement add = con.prepareStatement(Query);
        add.executeUpdate();
        return true;
    }
    }
}
    
    

