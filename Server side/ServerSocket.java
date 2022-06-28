// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server {
   
    private static final int PORT = 444;
    
    // constructor with port
    public Server() throws IOException {
    
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("[server] I am waiting");

        while (true) {
            
            Socket client = ss.accept();
            System.out.println("[server] I am connected");
            new ServerThread(client).start();
        }
    }

    public static void main(String args[]) throws IOException {
        Server server = new Server();
    }
}
