import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ServerThread extends Thread{
    
    Socket client;
 
    
    public ServerThread(Socket socket){
        this.client = socket;
    }
    
    public void String_response (String respond) throws IOException{
        PrintWriter out = new PrintWriter(client.getOutputStream() , true);
        out.println(respond);
    }
    
    public void vector_response (Vector<Object> respond) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(respond); 
    }
    
    
    @Override
    public void run(){
        
        try {
            String mssg;
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            while( !(mssg = in.readLine()).equals("close")){
                System.out.println("[clinet] " + mssg);
            }
            System.out.println("ended");
            client.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
