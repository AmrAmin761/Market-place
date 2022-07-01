/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class item implements Serializable {
    private int ID;
    private int Price;
    private int Amount;
    private String Brand;
    private int MaxAmount;
    private ImageIcon image;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public int getMaxAmount() {
        return MaxAmount;
    }

    public void setMaxAmount(int MaxAmount) {
        this.MaxAmount = MaxAmount;
    }
    
    
    public item()
    {
        
    }
    
    public item(int ItemID,String name, int price, int qty,int maxamount)
    {
        Amount=qty;
        ID=ItemID;
        this.Price=price;
        Brand=name;
        MaxAmount=maxamount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }



    
    
}