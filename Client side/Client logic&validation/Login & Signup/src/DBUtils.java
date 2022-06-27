
import javafx.scene.control.Alert;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DBUtils {
    /*
	    Function Name        : signUpUser
	    Function Returns     : void
	    Function Arguments   : event, username, password
	    Function Description : it manages the user to signup and has an account in the application
    */
    public static void signUpUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        //Connect to the database
        try {
            connection = DriverManager.getConnection("??????", "????", "????");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            //Check if the username was already taken
            if (resultSet.isBeforeFirst()) {
                /*If the username was already taken before, then the user cannot use this name*/
                System.out.println("This user name already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {
                /*
                    If the username was not taken before,
                    then signup complete and the username and password will be inserted into the database.
                */
                psInsert = connection.prepareStatement("INSERT INTO user (username, password) VALUES (?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();
                //Call the function which change scene
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        //Release database connection
        finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if(psCheckUserExists != null){
                try {
                    psCheckUserExists.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if(psInsert != null){
                try {
                    psInsert.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

     /*
	    Function Name        : logInUser
	    Function Returns     : void
	    Function Arguments   : event, username, password
	    Function Description : it manages the user to log his account
    */
    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //Connect to the database
        try {
            connection = DriverManager.getConnection("??????", "????", "????");
            preparedStatement = connection.prepareStatement("SELECT password FROM user WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            //Check if the user does not exist
            if(!resultSet.isBeforeFirst()) {
                System.out.println("User not found!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email or Password is incorrect");
                alert.show();
            }
            //If the user does exist, then check the password
            else {
                while(resultSet.next()) {
                    String retrievedPass = resultSet.getString("password");
                    if(retrievedPass.equals(password))
                    {
                        //Call the function which change scene
                    }
                    else {
                        System.out.println("Incorrect data");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Email or Password is incorrect");
                        alert.show();
                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        //Release database connection
        finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
