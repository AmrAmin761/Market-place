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
public class clothes extends item implements Serializable{
//    private int ClotheID;
    private String Size;
    private String Gender;
    private String COLOR;
    private String TYPE;

   
    

//    public int getClotheID() {
//        return ClotheID;
//    }
//
//    public void setClotheID(int ClotheID) {
//        this.ClotheID = ClotheID;
//    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }


    
    
    
}