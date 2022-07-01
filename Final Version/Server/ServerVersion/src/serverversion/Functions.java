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
import classes.*;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class Functions {

    static class validations {

        static boolean EnoughtAmount = true;
        static Vector<Integer> products = new Vector<>();
        
        
        public static boolean Login(String email, String password) throws SQLException {
            boolean valid = true;

            String Query = "Select * from person where  Email='" + email + "' and password= '" + password + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            if (rs.next()) {
                valid = true;
            } else {
                valid = false;
            }
            return valid;

        }

        public static boolean isExist(String email) throws SQLException {
            boolean valid = true;
            String Query = "Select * from  person where Email='" + email + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            if (rs.next()) {

            } else {
                valid = false;
            }
            return valid;
        }

        //public static boolean SignUp(String name , String email , String phone , String password)
        public static Vector CheckAndSetAmount(Vector<item> items) throws SQLException {

            int itemId;
            int amountRequested;
            int amountAv = 0;
            EnoughtAmount = true;

            for (int i = 0; i < items.size(); i++) {

                itemId = items.get(i).getID();
                amountRequested = items.get(i).getAmount();
                String Query = "select amount ,brand from item where id='" + itemId + "'";
                ResultSet rs = DatabaseManipulation.retrieve(Query);
                if (rs.next()) {
                    amountAv = Integer.valueOf(rs.getString(1));

                }
                if (amountAv >= amountRequested) {

                } else {
                    items.get(i).setAmount(amountAv);  //max available
                    products.add(itemId);
                    EnoughtAmount = false;

                }

            }
            return items;

        }
        public static  boolean Card(String Cardno,String Cardname, String year , String month , String day , String cvv,String deposite,String email) throws SQLException
        {
            String date=year+'-'+month+'-'+day;
            String Query="select * from credit_cards where card_number='"+Cardno+"' and CVV='"+cvv+"'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            if(rs.next())
            {
                System.out.println("Credit Card found");
                System.out.println("Deposite: "+Integer.valueOf(deposite));
                System.out.println("Amount of card: "+rs.getInt(1));
                if (Integer.valueOf(deposite)<=rs.getInt(1))
                {   
                    System.out.println("Deposite is smaller");
                     Query="update credit_cards set amount=amount-'"+deposite+"' where card_number='"+Cardno+"'";
                     DatabaseManipulation.update(Query);
                     Query="select ID from person where Email='"+email+"'";
                     rs=DatabaseManipulation.retrieve(Query);
                     String ID="";
                     if(rs.next())
                     {
                         ID=rs.getString(1);
                     }
                     Query="update person set Wallet_amount=Wallet_amount+'"+deposite+"' where ID='"+ID+"'";
                     DatabaseManipulation.update(Query);
                     return true;
                }
                else
                {
                    System.out.println("not enough");
                    return false;
                }
                
            }
            
            else
            {   
                System.out.println("Not found");
                System.out.println("Cardno:"+Cardno);
                System.out.println("Cardname:"+Cardname);
                System.out.println("year: "+year);
                System.out.println("month:"+month);
                System.out.println("day: "+day);
                System.out.println("cvv:"+cvv);
                System.out.println("Requested:"+deposite);
                System.out.println("Email:"+email);
                return false;
            }
        }

    }

    static class Logic {

        public static synchronized boolean SignUp(String name, String email, String phone, String password) throws SQLException {

            if (validations.isExist(email)) {
                return false;
            } else {
                int id = getMaxId() + 1;
                System.out.println("ID: " + id);
                String Query = "insert into person values('" + id + "', '" + name + "','" + password + "','" + phone + "','0','" + email + "')";
                DatabaseManipulation.update(Query);
                return true;
            }
        }

        public static int getMaxId() throws SQLException {
            System.out.println("here1");
            String Query = "Select MAX(ID) from person";
            System.out.println("here2");
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            System.out.println("here3");
            rs.next();
            System.out.println("here4");
            int max = rs.getInt(1);
            System.out.println("here5");
            return max;
        }

        public static Vector retriveClothes() throws SQLException {
            Vector<clothes> records = new Vector<clothes>();
            String Query = "Select * from item , clothes where ClotheID=ID";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            records.removeAllElements();
            ResultSetMetaData RSMD = rs.getMetaData();
            while (rs.next()) {
                clothes clothe = new clothes();
                clothe.setID(Integer.valueOf(rs.getString(1)));
                clothe.setPrice(Integer.valueOf(rs.getString(2)));
                clothe.setAmount(Integer.valueOf(rs.getString(3)));
                clothe.setBrand(rs.getString(4));
                
                clothe.setSize(rs.getString(7));
                clothe.setGender(rs.getString(8));
                clothe.setCOLOR(rs.getString(9));
                clothe.setTYPE(rs.getString(10));
                System.out.println("row returned");
                records.add(clothe);

            }

            return records;
        }

        public static Vector retriveConsumables() throws SQLException {
            Vector<consumables> records = new Vector<consumables>();
            String Query = "Select * from item , consumable where consumableID=ID";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            records.removeAllElements();
            ResultSetMetaData RSMD = rs.getMetaData();
            while (rs.next()) {
                consumables consumable = new consumables();
                consumable.setID(Integer.valueOf(rs.getString(1)));
                consumable.setPrice(Integer.valueOf(rs.getString(2)));
                consumable.setAmount(Integer.valueOf(rs.getString(3)));
                consumable.setBrand(rs.getString(4));

                consumable.setProduction_date(rs.getString(7));
                System.out.println("row returned");
                records.add(consumable);
            }
            return records;

        }

        public static synchronized boolean purchase(Vector<item> items) throws SQLException {

            validations.CheckAndSetAmount(items);
            if ((validations.EnoughtAmount)) {
                String Query;
                for (int i = 0; i < items.size(); i++) {
                    Query = "update item set Amount=Amount-" + items.get(i).getAmount() + " where ID= " + items.get(i).getID();
                    DatabaseManipulation.update(Query);
                }
                return true;
            } else {
                return false;
            }

        }

        public static synchronized void UpdatePassword(String email, String password) throws SQLException {
            String Query = "update person set Password='" + password + "' where Email='" + email + "'";
            DatabaseManipulation.update(Query);

        }

        public static Vector GetInfo(String email) throws SQLException {

            Vector info = new Vector();

            String Query = "Select * from person where Email='" + email + "'";

            ResultSet rs = DatabaseManipulation.retrieve(Query);

            ResultSetMetaData RSMD = rs.getMetaData();

            rs.next();
            int i = 1;

            while (i < 7) {

                info.add(rs.getString(i));
                System.out.println("FETCHING INFO");
                System.out.println(rs.getString(i));

                i++;

            }

            return info;
        }

        public static synchronized void Submit_order(String email, Vector<item> items, int price) throws SQLException {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String date = now.toString().substring(0, 10);
            System.out.println("LLLLLLLOOOOOOOOOOOOOOOOOOOOOKKKKKKKKKKKKKKK" + date);
            String Query = "select id from person where Email='" + email + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            ResultSetMetaData RSMD = rs.getMetaData();
            rs.next();
            int ID = Integer.valueOf(rs.getString(1));
            System.out.println("ID: " + ID);
            int OID = getMaxOID() + 1;
            System.out.println("OID: " + OID);
            Query = "insert into online_order values('" + OID + "','" + price + "','" + date + "','nasr city')";
            DatabaseManipulation.update(Query);
            Query = "insert into makes values('" + ID + "','" + OID + "')";
            DatabaseManipulation.update(Query);
            for (int i = 0; i < items.size(); i++) {
                int ItemID = items.get(i).getID();
                int Amount = items.get(i).getAmount();
                Query = "insert into contains values('" + OID + "','" + ItemID + "','" + Amount + "')";
                DatabaseManipulation.update(Query);
            }
            Query="update person set Wallet_amount=Wallet_amount-'"+price+"'";
            DatabaseManipulation.update(Query);

        }

        public static int getMaxOID() throws SQLException {
            System.out.println("here1");
            String Query = "Select MAX(ID) from online_order";
            System.out.println("here2");
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            System.out.println("here3");
            int max;
            if (rs.next()) {
                System.out.println("here4");
                max = rs.getInt(1);
            } else {
                max = 0;
            }
            System.out.println("here5");
            return max;
        }

        public static Vector<classes.orders> GetOrders(String email) throws SQLException {
            String Query = "select id from person where Email='" + email + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            ResultSetMetaData RSMD = rs.getMetaData();
            rs.next();
            int ID = Integer.valueOf(rs.getString(1));
            System.out.println("ID IN DATBASE: " + ID);
            Query = "Select ID , checkout_price , Date_issued from online_order o , makes m where m.UID='" + ID + "' and m.OID=o.ID ";
            rs = DatabaseManipulation.retrieve(Query);
            RSMD = rs.getMetaData();
            Vector<classes.orders> order1 = new Vector<classes.orders>();
            while (rs.next()) {
                System.out.println("MANIPULATING FROM DATABASE ENTERED WHILE LOOP RS.NEXT()");
                classes.orders order2 = new classes.orders();
                order2.setOrderId(rs.getInt(1));
                order2.setTotalPrice(rs.getInt(2));
                order2.setDate(String.valueOf(rs.getString(3)));
                order1.add(order2);

            }
            return order1;

        }

        public static Vector<classes.item> GetOrderDetails(String email, String OrderID) throws SQLException {
            String Query = "select id from person where Email='" + email + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            ResultSetMetaData RSMD = rs.getMetaData();
            rs.next();
            int ID = Integer.valueOf(rs.getString(1));

            Query = "select IID,c.Amount,Brand , Price from contains c , item i where c.OID='" + OrderID + "'and c.IID=i.ID ";
            rs = DatabaseManipulation.retrieve(Query);
            RSMD = rs.getMetaData();
            Vector<classes.item> order1 = new Vector<classes.item>();
            while (rs.next()) {
                System.out.println("MANIPULATING FROM DATABASE ENTERED WHILE LOOP RS.NEXT()");
                classes.item order2 = new classes.item();
                order2.setID(rs.getInt(1));
                order2.setAmount(rs.getInt(2));
                order2.setBrand(String.valueOf(rs.getString(3)));
                order2.setPrice(rs.getInt(4));
                order1.add(order2);

            }
            return order1;
        }

        public static BufferedImage fetchImage(String ID, String Brand) throws SQLException, IOException {
            String Query = "Select Image from Item where  ID='" + ID + "' and Brand= '" + Brand + "'";
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            Blob blob = rs.getBlob("Image");
            InputStream in = blob.getBinaryStream();
            BufferedImage image = ImageIO.read(in);
            return image;

        }
        public static Vector facts() throws SQLException
        {
            Vector facts=new Vector();
            String Query="select count(*) from person";                 //number of users
            ResultSet rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));
            Query="select count(UID) , UID from makes group by `UID`  order BY (count(UID)) DESC";  //most valuable person
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));            
            Query="select count(*) from online_order";                  //number or orders
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));               
            Query="select sum(checkout_price) from online_order";       //income
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));       
            
            Query="select Price , ID from item group by Price order by Price DESC"; //most valuable price
            rs = DatabaseManipulation.retrieve(Query);
            rs.next();
            facts.add(rs.getString(1));               
            return facts;
        }



    }

    static class DatabaseManipulation {

        public static ResultSet retrieve(String Query) throws SQLException {
            int CC;
            String name;
            Statement stmt = null;
            ResultSet rs = null;

            Connection con = null;

            String str = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace_database?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "lolbiglol");
            stmt = con.createStatement();
            rs = stmt.executeQuery(Query);
            ResultSetMetaData RSMD = rs.getMetaData();
            CC = RSMD.getColumnCount();
            name = RSMD.getColumnName(1);

            return rs;

        }

        public static boolean update(String Query) throws SQLException {
            Statement stmt = null;
            ResultSet rs = null;

            Connection con = null;

            String str = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace_database?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "lolbiglol");

            PreparedStatement add = con.prepareStatement(Query);
            add.executeUpdate();
            return true;
        }
    }
}
