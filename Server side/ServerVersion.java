/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverversion;


import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;
import serverversion.Functions;

/**
 *
 * @author user
 */
public class ServerVersion {

    
    public static ResultSet retrieve(String Query) throws SQLException
    {
        int CC;   
        String name;
        Statement stmt=null;
        ResultSet rs = null;
        ServerSocket server = null;
        Socket client = null;
        Connection con = null;
        ObjectOutputStream out =null;
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
        ServerSocket server = null;
        Socket client = null;
        Connection con = null;
        ObjectOutputStream out =null;
        String str = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace_database?zeroDateTimeBehavior=CONVERT_TO_NULL", "root","lolbiglol");
                
        PreparedStatement add = con.prepareStatement(Query);
        add.executeUpdate();
        return true;
    }


    

              
                
    


    

    
    
    
    public static void main(String[] args) throws SQLException {
        boolean key=Functions.validations.isExist("alyafif@gmail.com");
        if(key)
        {
            System.out.println("exists");
        }
        else
        {
            System.out.println("not exist");
        }
        System.out.println(Functions.Logic.getMaxId());
        if(Functions.Logic.SignUp("tester2", "tester2@gmail.com", "07775000", "1234"))
        {
            System.out.println("correct");
        }
        else
        {
            System.out.println("shit");
        }

}


    
    
}
