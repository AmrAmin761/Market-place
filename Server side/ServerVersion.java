
package serverversion;


import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;
import serverversion.Functions;
import static serverversion.Functions.DatabaseManipulation.retrieve;
import static serverversion.Functions.Logic.purchase;
import static serverversion.Functions.Logic.retriveClothes;
import static serverversion.Functions.Logic.retriveConsumables;

/**
 *
 * @author user
 */
public class ServerVersion {


    public static void main(String[] args) throws SQLException {
//        Vector<clothes> records=retriveClothes();
//        
//        for(int i=0;i<records.size();i++)
//        {
//            System.out.print( i+ " ID: "+records.get(i).getID()+"\n");
//            System.out.print( i+ " price: "+records.get(i).getPrice()+"\n");
//            System.out.print( i+ " type: "+records.get(i).getTYPE()+"\n");
//            System.out.print( i+ " COLOR: "+records.get(i).getCOLOR()+"\n");
//            
//        }

//         Vector<consumables> records=retriveConsumables();
//         
//                 for(int i=0;i<records.size();i++)
//        {
//            System.out.print( i+ " ID: "+records.get(i).getID()+"\n");
//            System.out.print( i+ " price: "+records.get(i).getPrice()+"\n");
//            System.out.print( i+ " date: "+records.get(i).getProduction_date()+"\n");
//            System.out.print( i+ " brand: "+records.get(i).getBrand()+"\n");
//            
//        }


        Vector<item> records = new Vector<item>();
        
          
            
            String Query="Select * from item" ;
            ResultSet rs=retrieve(Query);
            records.removeAllElements();
             ResultSetMetaData RSMD = rs.getMetaData();
             int starter=-3;
                    while(rs.next()&&starter!=0)
                    {       
                        item items=new item();
                        items.setID( Integer.valueOf(rs.getString(1)));
                        items.setPrice( Integer.valueOf(rs.getString(2)));
                        items.setAmount( Integer.valueOf(rs.getString(3))+starter);
                        items.setBrand(rs.getString(4));
                        

                        
                        records.add(items);
                        starter++;
                        
                    }    
                    System.err.println(purchase(records));

                    
            
        

}


    
    
}

