/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.version;

import classes.clothes;
import classes.consumables;
import classes.item;
import classes.orders;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Database {
    
    private Vector<classes.clothes>clothe=new Vector<classes.clothes>();
    private Vector<classes.consumables>cons=new Vector<classes.consumables>();
    private Vector<classes.item>items=new Vector<classes.item>();
    private Vector<classes.orders>order=new Vector<classes.orders>();
    private String email;
    private int wallet;
    

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public Vector<clothes> getClothe() {
        return clothe;
    }

    public void setClothe(Vector<clothes> clothe) {
                for(int i=0;i<clothe.size();i++)
        {
            this.clothe.add(clothe.get(i));
        }
        
        
        
        
        this.clothe = clothe;
    }

    public Vector<consumables> getCons() {
        return cons;
    }

    public void setCons(Vector<consumables> cons) {
        
                for(int i=0;i<cons.size();i++)
        {
            this.cons.add(cons.get(i));
        }
        
        
        
        
        
        
        this.cons = cons;
    }

    public Vector<item> getItems() {
        return items;
    }
    public void addItem(classes.item item)
    {
        items.add(item);
    }

    public void setItems(Vector<item> items) {
        this.items = items;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    
    
    public void PrintClothe()
    {
        for(int i=0;i<clothe.size();i++)
        {
            System.out.println(i);
            System.out.println(clothe.get(i).getAmount());
            System.out.println(clothe.get(i).getBrand());
            System.out.println(clothe.get(i).getCOLOR());
            System.out.println(clothe.get(i).getGender());
            System.out.println(clothe.get(i).getID());
            System.out.println(clothe.get(i).getPrice());
            System.out.println(clothe.get(i).getSize());
            System.out.println(clothe.get(i).getTYPE());
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
        }
        
    }
   
        public void Printcons()
    {
        for(int i=0;i<cons.size();i++)
        {
            System.out.println(i);
            System.out.println(cons.get(i).getAmount());
            System.out.println(cons.get(i).getBrand());
            System.out.println(cons.get(i).getProduction_date());
            System.out.println(cons.get(i).getID());
            System.out.println(cons.get(i).getPrice());
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
        }
        
    }
        public void printitems()
        {
            for(int i=0;i<items.size();i++)
        {
            System.out.println("PRINTING FROM DB");
            System.out.println(i);
            System.out.println(items.get(i).getAmount());
            System.out.println(items.get(i).getBrand());
            
            System.out.println(items.get(i).getID());
            System.out.println(items.get(i).getPrice());
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
            System.out.println("       ");
        }
        }
        public int SearchItemID(int id)
        {
            for(int i=0;i<items.size();i++)
            {
                if (items.get(i).getID()==id)
                {
                    return i;
                }
            }
            return -1;
        }
            public int SearchClothesID(int id)
        {
            for(int i=0;i<clothe.size();i++)
            {
                if (clothe.get(i).getID()==id)
                {
                    return i;
                }
            }
            return -1;
        }
             public int SearchConsID(int id)
        {
            for(int i=0;i<cons.size();i++)
            {
                if (cons.get(i).getID()==id)
                {
                    return i;
                }
            }
            return -1;
        }
             public void TestAndSetItems()
             {
                 for(int i=0;i<items.size();i++)
                 {
                     if(items.get(i).getAmount()>items.get(i).getMaxAmount())
                     {
                         items.get(i).setAmount(items.get(i).getMaxAmount());
                     }
                 }
             }
             public void ClearItems()
             {
                 items.clear();
             }

    public Vector<orders> getOrder() {
        return order;
    }

    public void setOrder(Vector<orders> order) {
        this.order = order;
    }
             
}
