package logic.entities.DAO;

import logic.entities.User;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class UserDAO
{
    //dichiarazioni utili alla connessione con il dbms

    private static String USER = "root";
    private static String PSW = "PASSWORD";
    private static String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static User findUser(String email,String password)
    {
        Connection connection = null; //interface
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
    
    public static void createUser(String name,String surname,String username,String email,String password,LocalDate data,String gender,String typeOfAccount)
	{
    	Connection connection = null; //interface
        Statement statement = null;
        int retFromQuery;
        try
        {
            //loading dinamico del driver specifico
            try {
				Class.forName(DRIVER_CLASS_NAME);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM utente WHERE Email = '"+email+"';";
            ResultSet rs = statement.executeQuery(query);
           
            if (!rs.first()) //la query non ha prodotto risultati
            {
                //Inserisco dati nel db
            	query = "INSERT INTO utente (Email,Username,Password,Nome,Cognome,DataDiNascita,Sesso,Tipo) VALUES ('"+email+"','"+username+"','"+password+"','"+name+"','"+surname+"','"+data+"','"+gender+"','"+typeOfAccount+"');";
            	retFromQuery = statement.executeUpdate(query);
            	if (retFromQuery==2) //la query non ha prodotto risultati
                {
            		JOptionPane.showMessageDialog(null," OPS! Something went wrong."," ERROR",JOptionPane.ERROR_MESSAGE);
                }
            	else
            	{
            		JOptionPane.showMessageDialog(null," Your data has been saved into db!","WELCOME", JOptionPane.INFORMATION_MESSAGE);
            	}
            	
            }
            else
            {
                //Messagio Errore
            	JOptionPane.showMessageDialog(null," Email already in use."," ERROR",JOptionPane.ERROR_MESSAGE);

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

        }

	}
}

	