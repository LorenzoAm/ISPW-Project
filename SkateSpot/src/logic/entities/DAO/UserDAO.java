package logic.entities.DAO;

import logic.entities.User;

import javax.swing.*;
import java.sql.*;

public class UserDAO
{
    //dichiarazioni utili alla connessione con il dbms

    private static String USER = "root";
    private static String PSW = "PASSWORD";
    private static String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static User findUser(String email,String password)
    {
        Connection connection = null;
        Statement statement = null;
        User user = null;

        try
        {
            //loading dinamico del driver specifico
            Class.forName(DRIVER_CLASS_NAME);

            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);

            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM utente WHERE Email = '"+email+"' AND Password = '"+password+"';";
            ResultSet rs = statement.executeQuery(query);

            if (!rs.first()) //la query non ha prodotto risultati
            {
                JOptionPane.showMessageDialog(null," No user found with password : "+password+" and email : "+email," ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //creazione istanza di tipo User
                 user = new User(rs.getString("Email"),rs.getString("Username"),rs.getString("Password"),rs.getString("Nome"),rs.getString("Cognome"),rs.getDate("DataDiNascita"),rs.getString("Sesso"),rs.getString("Tipo"));

            }

            //chiudiamo il result set generato dalla query
            rs.close();

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally  //chiudiamo statement e connessione
        {
            try
            {
                if(statement != null)
                    statement.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }

            return user;
        }


    }

}
