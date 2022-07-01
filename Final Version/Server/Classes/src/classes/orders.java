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
public class orders implements Serializable {
    
    
    private int OrderId;
    private String Date;
    private int TotalPrice;

    public orders() {
    }

    
    
    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }
    
    
}
