package Login;

import java.io.*;
import java.net.Socket;


public class Login {
    /*
        Function Name        : valEmail
	    Function Returns     : boolean
	    Function Arguments   : email
	    Function Description : it checks if email is valid or not
    */
    public static boolean valEmail(String email) {
        boolean flag = false;
        if(email == null || email.isEmpty()) {
            return false;
        }
        if(email.charAt(0) != '@' && email.contains("@") && email.endsWith(".com")) {
            flag = true;
        }
        return flag;
    }

    /*
        Function Name        : logInUser
        Function Returns     : int
        Function Arguments   : email, password
        Function Description : If email is valid it sends the email to the server and returns data read from it
    */
    public static int logInUser(String email, String password) {

        //Call valEmail function to check if the mail is valid or not before sending it to the server
        boolean checkEmail = valEmail(email);
        if(checkEmail == false){
            return -1;
        }

        String passFromServer = "";
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            socket = new Socket("localhost", 123456);

            inputStreamReader = new InputStreamReader(socket.getInputStream()); // Reading source
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());// Writing source

            //To increase the efficiency, two buffers for read and write are used
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            // Send email to server
            bufferedWriter.write(email);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            /*
                Server will check the email sent,
                if the email already exists it will return the password associated with this email
            */
            passFromServer = bufferedReader.readLine();

            /*
                If the password returned from the server matches with the password from user return 1,
                which means login done successfully
            */
            if(passFromServer.equals(password)) {
                return 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;//Login failed mismatch passwords
    }
}
