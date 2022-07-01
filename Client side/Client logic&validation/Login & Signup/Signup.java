package Login;

import java.io.*;
import java.net.Socket;

public class Signup {
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
        Function Name        : valPhone
        Function Returns     : boolean
        Function Arguments   : phoneNo
        Function Description : it checks if phone number is valid or not
    */
    public static boolean valPhone(String phoneNo) {
        boolean flag = false;
        if(phoneNo == null || phoneNo.isEmpty()) {
            return false;
        }
        if(phoneNo.charAt(0) == '0' && phoneNo.charAt(1) == '1' && phoneNo.length() == 11 && phoneNo.matches("[0-9]+")) {
            flag = true;
        }
        return flag;
    }
    /*
        Function Name        : signUpUser
        Function Returns     : int
        Function Arguments   : username, email, password, confirmPass, phoneNo
        Function Description : If email and phone number are valid, it checks the password and confirmation pass, then send data to server
    */
    public static int signUpUser(String username, String email, String password, String confirmPass, String phoneNo) {

        //Call valEmail function to check if the mail is valid or not before sending data to the server
        boolean checkEmail = valEmail(email);
        if(checkEmail == false){
            return -1;
        }
        //Call valPhone function to check if phone number is valid or not before sending data to the server
        boolean checkPhoneNo = valPhone(phoneNo);
        if(checkPhoneNo == false) {
            return -2;
        }
        //Check if password and confirmation password are equal
        if(!password.equals(confirmPass)) {
            return -3;
        }

        int takenUsername = 1;
        int takenEmail = 1;
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {

            socket = new Socket("localhost", 54321);

            inputStreamReader = new InputStreamReader(socket.getInputStream()); // Reading source
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());// Writing source

            //To increase the efficiency, two buffers for read and write are used
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            // Send data to server
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            //Server will check if username is not taken before
            takenUsername = bufferedReader.read(); //Server will return 0 if the username is not taken before

            bufferedWriter.write(email);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            //Server will check if email is not taken before
            takenEmail = bufferedReader.read();//Server will return 0 if the email is not taken before

            bufferedWriter.write(password);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedReader.read();

            bufferedWriter.write(phoneNo);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedReader.readLine();

            if(takenUsername == 0 && takenEmail == 0) {
                return 0;
            }else if (takenUsername == 1) {
                return 1;
            } else if (takenEmail == 1) {
                return 2;
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
        return 3;//Something went wrong!
    }

}
