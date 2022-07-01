/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.version;

import classes.clothes;
import classes.consumables;
import classes.item;
import java.awt.Component;
import java.awt.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author user
 */
public class Logic {

    static class functions {

        Logic objects = new Logic();

        public static boolean Login(String Email, String Password) throws SQLException, IOException {
            Client c = new Client();

            c.RequestFunction("login");
            Vector parameter = new Vector();
            parameter.add(Email);
            parameter.add(Password);
            c.SendParameters(parameter);
            if (c.RecieveValid() != 0) {
                c.CloseSocket();
                return true;

            } else {
                c.CloseSocket();
                return false;
            }

        }

        public static boolean SignUp(JTextField name, JTextField email, JTextField mobile, JPasswordField password1, JPasswordField password2) throws SQLException, IOException {
            Client c = new Client();
            String Email = email.getText();
            String Name = name.getText();
            String Mobile = mobile.getText();
            String Password1 = new String(password1.getPassword());
            String Password2 = new String(password2.getPassword());
            if (password1.equals(password2)) {
                c.RequestFunction("sign up");
                Vector parameters = new Vector();
                parameters.add(Name);
                parameters.add(Email);
                parameters.add(Mobile);
                parameters.add(Password1);
                System.out.println("here 1");
                c.SendParameters(parameters);
                System.out.println("here 2");
                if (c.RecieveValid() != 0) {
                    c.CloseSocket();
                    return true;
                } else {
                    c.CloseSocket();
                    return false;
                }
            } else {
                
                c.CloseSocket();
                return false;
            }
        }

        public static boolean ForgotPassword(String Email, String code) throws SQLException, IOException {
            Client c = new Client();

            Vector parameter = new Vector();
            parameter.add(Email);
            c.RequestFunction("forgot password");
            c.SendParameters(parameter);
            if (c.RecieveValid() != 0) {
                parameter.set(0, code);
                c.SendParameters(parameter);
                c.CloseSocket();
                return true;
            } else {
                c.CloseSocket();
                return false;
            }

        }

        public static String GenCode() {
            double code = 0;
            for (int i = 1; i < 9; i++) {
                code += Math.random() * Math.pow(10, i);
            }
            System.out.println((int) code);
            return String.valueOf((int) code);
        }

        public static Vector getInfo(String Email) throws SQLException, IOException, ClassNotFoundException {
            Client c = new Client();
            Vector parameter = new Vector();
            parameter.add(Email);
            c.RequestFunction("account info");
            c.SendParameters(parameter);
            Vector info = c.RecieveVector();
            c.CloseSocket();
            return info;
        }

        public static Vector RetrieveClothes() throws SQLException, IOException, ClassNotFoundException {
            Client c = new Client();

            c.RequestFunction("clothes");

            Vector clothes = (c.RecieveVector());
            ClientVersion.b.setClothe(clothes);
            ClientVersion.b.PrintClothe();
            c.CloseSocket();
            return clothes;
        }

        public static void fill_clothes_table(JTable table, Vector records) {
            System.out.println("1");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            System.out.println("2");
            for (int i = 0; i < records.size(); i++) {
                System.out.println("3");
                clothes cloth = (clothes) records.elementAt(i);
                System.out.println("4");
                String ClotheID = String.valueOf(cloth.getID());
                String Size = cloth.getSize();
                String Gender = cloth.getGender();
                String COLOR = cloth.getCOLOR();
                String TYPE = cloth.getTYPE();
                String NAME = cloth.getBrand();
                ImageIcon icon=cloth.getImage();
                String price = String.valueOf(cloth.getPrice());
                Object[] data = {ClotheID, NAME, TYPE, Gender, COLOR, Size, price,icon};
                model.addRow(data);
            }
        }

        public static Vector RetrieveConsumbales() throws SQLException, IOException, ClassNotFoundException {
            Client c = new Client();

            c.RequestFunction("consumables");
            Vector cons = c.RecieveVector();

            ClientVersion.b.setCons(cons);
            System.out.println("printing from database class");
            ClientVersion.b.Printcons();
            c.CloseSocket();
            return cons;
        }

        public static void fill_Consumbales_table(JTable table, Vector records) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            for (int i = 0; i < records.size(); i++) {

                consumables cons = (consumables) records.elementAt(i);

                String ID = String.valueOf(cons.getID());
                String NAME = cons.getBrand();
                String price = String.valueOf(cons.getPrice());
                String production_data = cons.getProduction_date();
                ImageIcon icon=cons.getImage();
                Object[] data = {ID, NAME, production_data, price,icon};
                model.addRow(data);
            }
        }

        public static void Search_in_Clothes(JTable table, Vector records, String search) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowcount = model.getRowCount();
            for (int i = rowcount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < records.size(); i++) {
                clothes cloth = (clothes) records.elementAt(i);
                String NAME = cloth.getBrand();
                if ((NAME.toLowerCase()).contains(search.toLowerCase())) {
                    String ClotheID = String.valueOf(cloth.getID());
                    String Size = cloth.getSize();
                    String Gender = cloth.getGender();
                    String COLOR = cloth.getCOLOR();
                    String TYPE = cloth.getTYPE();
                    ImageIcon icon=ClientVersion.b.getClothe().get(i).getImage();
                    String price = String.valueOf(cloth.getPrice());
                    Object[] data = {ClotheID, NAME, TYPE, Gender, COLOR, Size, price};
                    System.out.println(icon);
                    model.addRow(data);
                    int rowcount1 = model.getRowCount();
                    table.setValueAt(icon, rowcount1-1, 7);

                } else {
                    continue;
                }

            }

        }

        public static void Search_In_Consumbales(JTable table, Vector records, String search) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowcount = model.getRowCount();
            for (int i = rowcount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < records.size(); i++) {
                consumables cons = (consumables) records.elementAt(i);
                String NAME = cons.getBrand();
                if ((NAME.toLowerCase()).contains(search.toLowerCase())) {
                    String ID = String.valueOf(cons.getID());
                    String price = String.valueOf(cons.getPrice());
                    String production_data = cons.getProduction_date();
                    ImageIcon icon= cons.getImage();
                    Object[] data = {ID, NAME, production_data, price,icon};
                    model.addRow(data);

                } else {
                    continue;
                }

            }

        }

        public static void ChangePassword(String email, String password) throws SQLException, IOException {
            Client c = new Client();

            c.RequestFunction("Change password");

            Vector parameters = new Vector();
            parameters.add(email);
            parameters.add(password);
            c.SendParameters(parameters);
            c.CloseSocket();

        }

        public static void added_items_clth(JTable table, JTextField QTY) {
            int row = table.getSelectedRow();
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            String name = table.getModel().getValueAt(row, 1).toString();
            int price = Integer.valueOf(table.getModel().getValueAt(row, 6).toString());
            int qty = Integer.valueOf(QTY.getText().replaceAll(" ", ""));
            int index1 = ClientVersion.b.SearchClothesID(ItemID);
            int maxamount = ClientVersion.b.getClothe().get(index1).getAmount();
            classes.item item = new item(ItemID, name, price, qty, maxamount);
            int index = ClientVersion.b.SearchItemID(ItemID);
            if (index != -1) {
                classes.item item1 = ClientVersion.b.getItems().get(index);
                ClientVersion.b.getItems().remove(index);
                item.setAmount(item.getAmount() + item1.getAmount());
            }
            ClientVersion.b.addItem(item);
            ClientVersion.b.printitems();
        }

        public static void added_items_cons(JTable table, JTextField QTY) {
            int row = table.getSelectedRow();
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            String name = table.getModel().getValueAt(row, 1).toString();
            int price = Integer.valueOf(table.getModel().getValueAt(row, 3).toString());
            int qty = Integer.valueOf(QTY.getText());
            int index1 = ClientVersion.b.SearchConsID(ItemID);
            int maxamount = ClientVersion.b.getCons().get(index1).getAmount();
            classes.item item = new item(ItemID, name, price, qty, maxamount);
            int index = ClientVersion.b.SearchItemID(ItemID);

            if (index != -1) {

                classes.item item1 = ClientVersion.b.getItems().get(index);
                ClientVersion.b.getItems().remove(index);
                item.setAmount(item.getAmount() + item1.getAmount());
            }
            ClientVersion.b.addItem(item);
            ClientVersion.b.printitems();
        }

        public static void fill_Cart_table(JTable table, Vector records, JLabel TOTAL) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowcount = model.getRowCount();
            for (int i = rowcount - 1; i >= 0; i--) {
                model.removeRow(i);
            }

            for (int i = 0; i < records.size(); i++) {

                item items = (item) records.elementAt(i);

                String ID = String.valueOf(items.getID());
                String NAME = items.getBrand();
                String price = String.valueOf(items.getPrice());
                String QTY = String.valueOf(items.getAmount());

                Object[] data = {ID, NAME, QTY, price};
                model.addRow(data);
                TOTAL.setText(String.valueOf((Integer.valueOf(TOTAL.getText()) + Integer.valueOf(QTY) * Integer.valueOf(price))));

            }
        }

        public static void Manipulate_Cart(JTable table, JTextField QTY, JLabel amount) {
            int row = table.getSelectedRow();
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            String name = table.getModel().getValueAt(row, 1).toString();
            int price = Integer.valueOf(table.getModel().getValueAt(row, 3).toString());
            int qty = Integer.valueOf(QTY.getText());
            int index1 = ClientVersion.b.SearchItemID(ItemID);
            int maxamount = ClientVersion.b.getItems().get(index1).getMaxAmount();
            classes.item item = new item(ItemID, name, price, qty, maxamount);

            int index = ClientVersion.b.SearchItemID(ItemID);

            if (index != -1) {

                classes.item item1 = ClientVersion.b.getItems().get(index);
                int price1 = item1.getPrice();
                int qty1 = item1.getAmount();
                amount.setText(String.valueOf((Integer.valueOf(amount.getText()) - Integer.valueOf(qty1) * Integer.valueOf(price1) + Integer.valueOf(qty) * Integer.valueOf(price))));
                ClientVersion.b.getItems().remove(index);
                item.setAmount(item.getAmount());
            }

            ClientVersion.b.addItem(item);
            ClientVersion.b.printitems();

        }

        public static void Remove_from_cart(JTable table) {

            int row = table.getSelectedRow();

            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());

            int index = ClientVersion.b.SearchItemID(ItemID);

            if (index != -1) {

                ClientVersion.b.getItems().remove(index);

            }

        }

        public static void Refresh_Cart(JTable table, Vector records, JLabel TOTAL) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowcount = model.getRowCount();
            for (int i = rowcount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            TOTAL.setText("0");

            System.out.println("here");
            fill_Cart_table(table, records, TOTAL);
        }

        public static int getMaxAmountCons(JTable table, Vector records) {
            int row = table.getSelectedRow();
            System.out.println("Selected row: " + row);
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            System.out.println("Item ID: " + ItemID);
            int index = ClientVersion.b.SearchConsID(ItemID);
            System.out.println("Index : " + index);
            System.out.println(ClientVersion.b.getCons().get(index).getAmount());
            return ClientVersion.b.getCons().get(index).getAmount();
        }

        public static int getMaxAmountCloth(JTable table, Vector records) {
            int row = table.getSelectedRow();
            System.out.println("Selected row: " + row);
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            System.out.println("Item ID: " + ItemID);
            int index = ClientVersion.b.SearchClothesID(ItemID);
            System.out.println("Index : " + index);
            System.out.println(ClientVersion.b.getClothe().get(index).getAmount());
            return ClientVersion.b.getClothe().get(index).getAmount();
        }

        public static int getMaxAmountItem(JTable table, Vector records) {
            System.out.println("getMaxAmountItem: ");
            int row = table.getSelectedRow();
            System.out.println("Selected row: " + row);
            int ItemID = Integer.valueOf(table.getModel().getValueAt(row, 0).toString());
            System.out.println("Item ID: " + ItemID);
            int index = ClientVersion.b.SearchItemID(ItemID);
            System.out.println("Index : " + index);
            System.out.println(ClientVersion.b.getItems().get(index).getMaxAmount());
            return ClientVersion.b.getItems().get(index).getMaxAmount();
        }

        public static int Purchase(Vector records, String price) throws SQLException, IOException, ClassNotFoundException {
                if(ClientVersion.b.getWallet()<Integer.valueOf(price))
                {
                    return -1;
                }
            Client c = new Client();
            c.RequestFunction("purchase");
            c.SendParameters(records);
            int validty = c.RecieveValid();
            if (validty == 0) {
                ClientVersion.b.setItems(c.RecieveVector());

            } else {
                Vector parameter = new Vector();
                parameter.add(ClientVersion.b.getEmail());
                parameter.add(price);
                c.SendParameters(parameter);
            }
            c.CloseSocket();
            return validty;
        }

        public static String Reciept() {
            Vector<classes.item> records = ClientVersion.b.getItems();
            String details = ("==================SWCSS=========================\n" + "NUM     PRODUCT     PRICE     QUANTITY     TOTAL\n");
            int total = 0;
            for (int i = 0; i < records.size(); i++) {
                String row = "";
                row = row + String.valueOf((records.get(i).getID()));
                while (row.length() < 8) {
                    row += " ";
                }

                row += (records.get(i).getBrand());
                while (row.length() < 20) {
                    row += " ";
                }

                row += String.valueOf((records.get(i).getPrice()));
                while (row.length() < 30) {
                    row += " ";
                }

                row += String.valueOf((records.get(i).getAmount()));;
                while (row.length() < 43) {
                    row += " ";
                }
                row += String.valueOf((records.get(i).getPrice()) * (records.get(i).getAmount()));
                total += (records.get(i).getPrice() * records.get(i).getAmount());
                row += "\n";
                details = details + row;
            }
            details = details + "\n" + "Total: " + total;
            System.out.println(details);
            return details;
        }

        public static Vector<classes.orders> GetOrders() throws SQLException, IOException, ClassNotFoundException {
            System.out.println("started get orders function");
            Client c = new Client();
            System.out.println("socket created");
            c.RequestFunction("orders");
            System.out.println("Request is sent");
            Vector parameter = new Vector();
            parameter.add(ClientVersion.b.getEmail());
            c.SendParameters(parameter);
            System.out.println("parameters are sent");

            return c.RecieveVector();
        }

        public static void fillOrdersTable(JTable table, Vector records) {
            System.out.println("1");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            System.out.println("2");
            System.out.println("vector size: " + records.size());
            for (int i = 0; i < records.size(); i++) {
                System.out.println("3");
                classes.orders order = (classes.orders) records.elementAt(i);
                System.out.println("4");
                int OrderId = order.getOrderId();
                String OrderDate = order.getDate();
                int TotalPrice = order.getTotalPrice();

                Object[] data = {OrderId, OrderDate, TotalPrice};
                model.addRow(data);
            }
        }

        public static Vector<classes.item> GetOrders_details(JTable table) throws SQLException, IOException, ClassNotFoundException {
            Client c = new Client();
            c.RequestFunction("order details");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int rowcount = model.getRowCount();
            String OID = table.getModel().getValueAt(rowcount - 1, 0).toString();
            System.out.println("started get orders function1");

            System.out.println("socket created1");

            System.out.println("Request is sent1");
            Vector parameter = new Vector();
            parameter.add(ClientVersion.b.getEmail());
            parameter.add(String.valueOf(OID));
            c.SendParameters(parameter);
            System.out.println("parameters are sent1");

            return c.RecieveVector();
        }

        public static void fillOrdersDetailsTable(JTable table, Vector records) {
            System.out.println("11");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            System.out.println("21");
            System.out.println("vector size1: " + records.size());
            for (int i = 0; i < records.size(); i++) {
                System.out.println("31");
                classes.item order = (classes.item) records.elementAt(i);
                System.out.println("41");
                int ItemID = order.getID();
                String ItemName = order.getBrand();
                int ItemAmount = order.getAmount();
                int ItemPrice = order.getPrice();

                Object[] data = {ItemID, ItemName, ItemAmount, ItemPrice};
                model.addRow(data);
            }
        }

        public static void test(JTable table) throws SQLException, IOException, ClassNotFoundException {
            Client c = new Client();
            c.RequestFunction("images");
            ImageIcon icon = new ImageIcon();

            icon = c.ReciveImage();
            
            
            table.setValueAt(icon, 1, 7);
            

        }

        public static void RetrieveClothesIcon() throws SQLException, IOException, InterruptedException
        {   
            System.out.println("from retriveclothesicon:");
            ClientVersion.b.PrintClothe();
            Vector parameters=new Vector();
            System.out.println("ARRAY SIZE:"+ClientVersion.b.getClothe().size());
            for(int i=0;i<ClientVersion.b.getClothe().size();i++)
            {   Client c = new Client();
                System.out.println(i);
                parameters.removeAllElements();
                System.out.println("parameters cleared");
                parameters.add(String.valueOf(ClientVersion.b.getClothe().get(i).getID()));
                System.out.println("parameters added:"+String.valueOf(ClientVersion.b.getClothe().get(i).getID()));
                parameters.add(ClientVersion.b.getClothe().get(i).getBrand());
                System.out.println("parameters added:"+String.valueOf(ClientVersion.b.getClothe().get(i).getBrand()));
                c.RequestFunction("images");
                System.out.println("Requested images");
                c.SendParameters(parameters);
                System.out.println("parameters are sent");
                ImageIcon icon = new ImageIcon();
                System.out.println("new image object created");
                icon = c.ReciveImage();
                System.out.println("image recieved");
                
                ClientVersion.b.getClothe().get(i).setImage(icon);
                System.out.println("walaaaaaaaaaaaaaaa");
                System.out.println("image:"+ClientVersion.b.getClothe().get(i).getImage());                
                System.out.println("image:"+i+"is in table");
                c.CloseSocket();
                
            }
            
        }
        public static void RetrieveConsIcon() throws SQLException, IOException, InterruptedException
        {   
            System.out.println("from retriveclothesicon:");
            
            Vector parameters=new Vector();
            System.out.println("ARRAY SIZE:"+ClientVersion.b.getCons().size());
            for(int i=0;i<ClientVersion.b.getCons().size();i++)
            {   Client c = new Client();
                System.out.println(i);
                parameters.removeAllElements();
                System.out.println("parameters cleared");
                parameters.add(String.valueOf(ClientVersion.b.getCons().get(i).getID()));
                System.out.println("parameters added:"+String.valueOf(ClientVersion.b.getCons().get(i).getID()));
                parameters.add(ClientVersion.b.getCons().get(i).getBrand());
                System.out.println("parameters added:"+String.valueOf(ClientVersion.b.getCons().get(i).getBrand()));
                c.RequestFunction("images");
                System.out.println("Requested images");
                c.SendParameters(parameters);
                System.out.println("parameters are sent");
                ImageIcon icon = new ImageIcon();
                System.out.println("new image object created");
                icon = c.ReciveImage();
                System.out.println("image recieved");
                
                ClientVersion.b.getCons().get(i).setImage(icon);
                System.out.println("walaaaaaaaaaaaaaaa");
                System.out.println("image:"+ClientVersion.b.getCons().get(i).getImage());
                System.out.println("image:"+i+"is in table");
                c.CloseSocket();
                
            }
            
        } 
        public static int WalletValidation(String Cardno,String Cardname, String year , String month , String day , String cvv,String deposite) throws SQLException, IOException
        {
            try
            {
                Integer.parseInt(Cardno);
                Integer.parseInt(year);
                Integer.parseInt(month);
                Integer.parseInt(day);
                Integer.parseInt(cvv);
                Integer.parseInt(deposite);
                Client c = new Client();
                c.RequestFunction("card");
                Vector parameters=new Vector();
                parameters.add(Cardno);
                parameters.add(Cardname);
                parameters.add(year);
                parameters.add(month);
                parameters.add(day);
                parameters.add(cvv);
                parameters.add(deposite);
                parameters.add(ClientVersion.b.getEmail());
                System.out.println("sending parameters to server");
                c.SendParameters(parameters);
                System.out.println("parameters are sent!");
                return c.RecieveValid();
                
            }
            catch(NumberFormatException e)
            {
                System.out.println("something not in format");
                return -1;
            }

        }
        
        
        public static Vector facts() throws SQLException, IOException, ClassNotFoundException
        {
            Client c = new Client();
            c.RequestFunction("report");
            Vector facts=c.RecieveVector();
            c.CloseSocket();
            return facts;
            
        }
        
        

    }
}


//details+String.valueOf((records.get(i).getID()))+"        "+(records.get(i).getBrand())+"        "+String.valueOf((records.get(i).getPrice()))+"         "+String.valueOf((records.get(i).getAmount()))+"        "+String.valueOf((records.get(i).getAmount())*(records.get(i).getPrice()))+"\n"
