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
import static serverversion.ServerVersion.retrieve;
import static serverversion.ServerVersion.update;




public class Functions {
    static class validations{
    
    public static boolean Login(String email,String password) throws SQLException
    {
        boolean valid=true;
        
        String Query="Select * from person , user where UserID=ID and Email='"+email+"' and password= '"+password+"'";
        ResultSet rs=retrieve(Query);
        if(rs.next())
        {
            valid=true;
        }
        else
            valid=false;
        return valid;
                
                
    }
        public static boolean isExist(String email) throws SQLException
    {
        boolean valid=true;
        String Query="Select * from  user where Email='"+email+"'" ;
        ResultSet rs=retrieve(Query);
        if(rs.next())
        {
            
        }
        else
            valid=false;
        return valid;
    }
    
    //public static boolean SignUp(String name , String email , String phone , String password)
    
    
    
    }
    static class Logic{
        public static boolean SignUp(String name , String email , String phone , String password) throws SQLException
        {
            
            if(validations.isExist(email))
            {
                return false;
            }
            else
            {
                String command="insert into person values";
                String ID= String.valueOf(getMaxId()+1);
                String Query=command+"('"+ID+"','"+name+"','"+password+"')";
                update(Query);
                Query="insert into user values('"+ID+"','"+phone+"','"+email+"')";
                update(Query);
                return true;
            }
        }
        
        public static int getMaxId() throws SQLException
        {
            String Query="Select MAX(ID) from person" ;
            ResultSet rs=retrieve(Query);
            rs.next();
            int max=rs.getInt(1);
            return max;
        }
        
        
        
    }
    
    
}
