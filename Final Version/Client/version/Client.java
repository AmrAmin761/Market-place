/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.version;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.OutputStream;
import classes.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public final class Client  {
    String str;
    Vector records;
    clothes c;
    int i=0;
    ObjectInputStream br = null;
    ObjectOutputStream outp =null;
    Socket clientSocket = null;
    DataOutputStream out=null;
    DataInputStream in=null;
    

    public Vector RecieveVector() throws IOException, ClassNotFoundException
    {
        br = new ObjectInputStream(clientSocket.getInputStream());
        
        records= (Vector) br.readObject();
        return records;
        //br.close();       
    }
    
    public ImageIcon ReciveImage() throws IOException{
        BufferedInputStream in1 = new BufferedInputStream(clientSocket.getInputStream());
        BufferedImage image =  ImageIO.read(in1);
        ImageIcon icon = new ImageIcon(image);
        return icon;

    }
    
    public void RequestFunction(String function) throws IOException
    {
        out = new DataOutputStream(clientSocket.getOutputStream());
        out.writeUTF(function);
        //out.close();
    }
    
    public void SendParameters(Vector parameters) throws IOException
    {   
        outp = new ObjectOutputStream(clientSocket.getOutputStream());
        outp.writeObject(parameters);
        
    }
     public void CloseSocket() throws IOException
     {
         clientSocket.close();
     }
    
    public void TestClothes(Vector clothe)
    {
        clothes c;
        i=0;
        while(i < clothe.size())
            {
            c = (clothes)clothe.elementAt(i);
            i++;
            System.out.println(c.getAmount()+"     "+c.getBrand()+"        "+c.getID()+"          "+"/n");  
            }  
    }
    public int RecieveValid() throws IOException
    {   

        in = new DataInputStream(clientSocket.getInputStream());

        int valid= in.read();
        
        return valid;
    }
    
    
    public Client() throws SQLException
    {
        c = null;
            try {
                  

                  clientSocket = new Socket("192.168.1.109",1234);

                 // TestClothes(records);
            } catch (IOException ex) {
                
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}