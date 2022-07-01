/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class consumables extends item implements Serializable{
//    private int ConsumableID;
    private String  Production_date;          

   
//    public int getConsumableID() {
//        return ConsumableID;
//    }
//
//    public void setConsumableID(int ConsumableID) {
//        this.ConsumableID = ConsumableID;
//    }



    public String getProduction_date() {
        return Production_date;
    }

    public void setProduction_date(String Production_date) {
        this.Production_date = Production_date;
    }
    
}