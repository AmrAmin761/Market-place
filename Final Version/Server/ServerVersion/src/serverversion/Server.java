/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverversion;

/**
 *
 * @author user
 */
import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import classes.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Server extends Thread {

    
    
    Vector records;
    ServerSocket server = null;
    Socket client = null;
    DataInputStream in =null;
    DataOutputStream Dout=null;
    ObjectOutputStream out =null;
    ObjectInputStream br = null;
    clothes pub = null;
    
    public Server()
    {
        try {
            server = new ServerSocket(1234);
            System.out.println("Starting the Server");
            start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void send(Vector result) throws SQLException, IOException
    {
        try 
            {
            out = new ObjectOutputStream(client.getOutputStream());
            } 
        catch (IOException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("OutputStream received");
            records=result;
            out.writeObject((Vector<Object>)records);
            //out.close();
            System.out.println("String returned");
    }
    
    
    public String RecieveRequest() throws IOException
    {
        in = new DataInputStream(client.getInputStream());
        String function =in.readUTF();
        //in.close();
        return function;
    }
    public Vector RecieveParameter() throws IOException, ClassNotFoundException
    {
        br = new ObjectInputStream(client.getInputStream());
        return (Vector)br.readObject();
        
    }
    public void SendValid(int valid) throws IOException
    {
        Dout = new DataOutputStream(client.getOutputStream());
        Dout.write(valid);
    }
    public void SendImage(BufferedImage  image) throws IOException{ 
        BufferedOutputStream out1 = new BufferedOutputStream(client.getOutputStream());
        ImageIO.write(image, "png", out1);
    }

    public void run()
    {
        while(true)
        {
            
                
                try {
                    client = server.accept();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Connection accepted");   
            try {
                String function=RecieveRequest();   //determine what is service requested from the client
                System.out.println(function);
                if(function.equals("clothes"))
                {
                    send(Functions.Logic.retriveClothes());
                    System.out.println("sent");
                }
                else if(function.equals("login"))
                {   
                    System.out.println("started");
                    Vector parameter=RecieveParameter();
                    String email=parameter.get(0).toString();
                    String password=parameter.get(1).toString();
                    
                    System.out.println("email recieved in server:    "+email);
                    System.out.println("password recieved in server: "+password);
                    
                    System.out.println(Functions.validations.Login(email, password));
                    if(Functions.validations.Login(email, password))
                    {
                        SendValid(1); 
                        
                    }
                    else
                    {
                        SendValid(0);
                        
                    }
                }
                else if(function.equals("sign up"))
                {
                    Vector parameter=RecieveParameter();
                    String name=parameter.get(0).toString();
                    System.out.println(name);
                    String email=parameter.get(1).toString();
                    System.out.println(email);
                    String mobile=parameter.get(2).toString();
                    System.out.println(mobile);
                    String password=parameter.get(3).toString();
                    System.out.println(password);
                    if(Functions.Logic.SignUp(name, email, name, password))
                    {
                        SendValid(1); 
                    }
                    else
                    {
                        SendValid(0);
                        
                    }   
                }
                else if(function.equals("forgot password"))
                {
                    Vector parameter=RecieveParameter();
                    String email=parameter.get(0).toString();
                    if(Functions.validations.isExist(email))
                    {
                        SendValid(1);
                        System.out.println("1 is sent to client");
                        parameter=RecieveParameter();
                        
                        String code=parameter.get(0).toString();
                        System.out.println("code: "+code);
                        Functions.Logic.UpdatePassword(email, code);
                    }
                    else
                    {
                        SendValid(0);
                    }
                    
                }
                else if(function.equals("account info"))
                {
                    Vector parameter=RecieveParameter();
                    String email=parameter.get(0).toString();
                    send(Functions.Logic.GetInfo(email));
                    
                }
                else if(function.equals("consumables"))
                {
                    send(Functions.Logic.retriveConsumables());
                }
                else if(function.equals("purchase"))
                {
                    Vector parameter=RecieveParameter();
                    if(Functions.Logic.purchase(parameter))
                    {
                        SendValid(1);
                        System.out.println("Purchase is validates");
                        Vector parameters=RecieveParameter();
                        String email=parameters.get(0).toString();
                        int price =Integer.valueOf(parameters.get(1).toString());
                        Functions.Logic.Submit_order(email, parameter, price);
                    }
                    else
                    {
                        SendValid(0);
                        send(Functions.validations.CheckAndSetAmount(parameter));
                        System.out.println("Purchase not validate");
                    }
                }
                else if(function.equals("orders"))
                {   
                    System.out.println("Orders");
                    
                    Vector parameter=RecieveParameter();
                    String email=parameter.get(0).toString();
                    System.out.println("Email: " +email);
                    send(Functions.Logic.GetOrders(email));
                    System.out.println("Vector is sent");
                }
                else if(function.equals("order details"))
                {
                    System.out.println("Order details");
                    Vector parameter=RecieveParameter();
                    String Email=parameter.get(0).toString();
                    String ID=parameter.get(1).toString();
                    send(Functions.Logic.GetOrderDetails(Email, ID));
                }
                else if(function.equals("Change password"))
                {
                    Vector parameter=RecieveParameter();
                    String email=parameter.get(0).toString();
                    String password=parameter.get(1).toString();
                    System.out.println("Email: "+email +"Password: "+password);
                    Functions.Logic.UpdatePassword(email, password);
                }
                else if(function.equals("images"))
                {
                    Vector parameter=RecieveParameter();
                    String ID=parameter.get(0).toString();
                    String BRAND=parameter.get(1).toString();
                    SendImage(Functions.Logic.fetchImage(ID, BRAND));
                    System.out.println("Image is sent");
                    
                }
                else if(function.equals("report"))
                {
                    Vector parameters=Functions.Logic.facts();
                    send(parameters);
                }
                else if(function.equals("card"))
                {
                    Vector parameters=RecieveParameter();
                    if(Functions.validations.Card(parameters.get(0).toString(), parameters.get(1).toString(), parameters.get(2).toString(), parameters.get(3).toString(), parameters.get(4).toString(), parameters.get(5).toString(), parameters.get(6).toString(),parameters.get(7).toString()))
                        SendValid(1);
                    else
                        SendValid(0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                    

            
        }   
    }

}
