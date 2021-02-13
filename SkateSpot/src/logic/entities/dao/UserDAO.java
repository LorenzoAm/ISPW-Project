package logic.entities.dao;

import logic.controllers.UserContainer;
import logic.entities.Spot;
import logic.entities.User;
import logic.exception.ExistingEmailException;
import logic.exception.FullSpotException;
import logic.exception.SpotNotFoundException;
import java.sql.*;
import java.time.LocalDate;


public class UserDAO
{
    //dichiarazioni utili alla connessione con il dbms

    private static final String USER = "root";
    private static final String PSW = "PASSWORD";
    private static final String URL = "jdbc:mysql://localhost:3306/skate_spot";
    
    private UserDAO() {}

    public static User findUser(String email,String password)  //metodo utilizzato per il login
    {
        Connection connection = null; //interface
        Statement statement = null;
        User user = null;

        try
        {

            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT * FROM utente WHERE Email = '"+email+"' AND Password = '"+password+"';";
            ResultSet rs = statement.executeQuery(query);
           
            if (rs.first()) //la query non ha prodotto risultati
            {
            	
            	user = new User(rs.getString("Email"),rs.getString("Username"),rs.getString("Password"),rs.getString("Nome"),rs.getString("Cognome"),rs.getDate("DataDiNascita"),rs.getString("Sesso"));
            	user.setTipo(rs.getString("Tipo"));
                Integer spotCode = rs.getInt("CodiceSpot");   //se l'utente ha un riferimento ad uno spot si crea lo spot

                if(spotCode != null)
                {
                    user.setSpot(SpotDAO.createSpot(spotCode));   //si assegna il riferimento all'istanza di spot
                }
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

        return user;
    }

    // metodo utilizzato per il sign up
    public static void createUser(String name,String surname,String username,String email,String password,LocalDate data,String gender,String typeOfAccount) throws ExistingEmailException
	{
    	Connection connection = null; //interface
        Statement statement = null;
        try
        {

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
            	statement.executeUpdate(query);
            		
            }
            else
            {
                throw new ExistingEmailException(email);
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

	//metodo utilizzato per risalire al codice dell'utente che sta aggiungendo uno shop/spot
    public static Integer findCodeUser(String email,String password)
    {
    	 Connection connection = null; //interface
         Statement statement = null;
         Integer code = null;

         try
         {

             connection=DriverManager.getConnection(URL,USER,PSW);
             //creazione ed esecuzione query
             statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             String query = "SELECT U.Codice FROM utente U WHERE U.Email = '"+email+"' AND U.Password = '"+password+"';";
             ResultSet rs = statement.executeQuery(query);

             if(rs.first()) {

            	 code = rs.getInt("Codice");
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
         return code;

    }

    public static void leaveSpot(String email,String password)
    {
        Connection connection = null; 
        Statement statement = null;
        int updatedNumber;
        int code;

        try
        {

            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT S.Codice,S.NumeroDiSkater FROM spot S JOIN utente U ON U.CodiceSpot = S.Codice WHERE U.Email ='"+email+"' AND U.Password = '"+password+"'";
            ResultSet rs = statement.executeQuery(query);
            updatedNumber = rs.getInt("S.NumeroDiSkater")-1;
            code = rs.getInt("S.Codice");

            query = "UPDATE utente SET CodiceSpot = NULL WHERE Email = '" + email + "' AND Password = '" + password + "';";
            statement.executeUpdate(query);

               
            query = "UPDATE spot SET NumeroDiSkater = '"+updatedNumber+"' WHERE Codice = '"+code+"';";
            statement.executeUpdate(query);

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

    public static Spot joinSpot(String street, String number, String city) throws FullSpotException,SpotNotFoundException
    {
        Connection connection = null; //interface
        Statement statement = null;
        Spot spot = null;

        try
        {
            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String query = "SELECT S.Codice,S.Nome,S.Via,S.Civico,S.Citta,S.Zona,S.Comune,S.Descrizione,S.NumeroDiSkater,S.Tipo,S.DataInserimento,U.Username FROM spot S JOIN utente U ON S.CodiceSkater = U.Codice WHERE Via = '"+street+"' AND Civico = '"+number+"' AND Citta ='"+city+"'";
            ResultSet rs = statement.executeQuery(query);

            if(rs.first())
            {
                if(rs.getInt("NumeroDiSkater")<20)
                {
                 
                    int codice = rs.getInt("S.Codice");
                    int updatedNumber = rs.getInt("S.NumeroDiSkater")+1;

                    String indirizzo = rs.getString("S.Via")+" "+rs.getInt("S.Civico")+" "+rs.getString("S.Citta");

                    spot = new Spot(indirizzo,rs.getString("S.Zona"),rs.getString("S.Nome"),rs.getString("S.Tipo"),rs.getString("S.Comune"),rs.getInt("S.NumeroDiSkater"),rs.getString("S.Descrizione"),rs.getString("U.Username"),rs.getDate("S.DataInserimento"));

                    query = "UPDATE spot SET NumeroDiSkater = '"+updatedNumber+"' WHERE Via = '"+rs.getString("S.Via")+"' AND Civico = '"+rs.getInt("S.Civico")+"' AND Citta = '"+rs.getString("S.Citta")+"' ";
                    statement.executeUpdate(query);

                    query = "UPDATE utente SET CodiceSpot ='"+codice+"' WHERE  Email ='"+UserContainer.getInstance().getEmail()+"' AND Password ='"+UserContainer.getInstance().getPassword()+"' ";
                    statement.executeUpdate(query);


                }
                else
                {
                    throw new FullSpotException(rs.getString("S.Nome"));
                }
            }
            else
            {
            	String indirizzo=street+" "+number+","+city+" ";
               throw new SpotNotFoundException(indirizzo);
            }

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
        return spot;
    }
    public static String getUsername(int codice)
    {
    	 Connection connection = null; //interface
         Statement statement = null;
         String username = null;

         try
         {

             //apertura della connessione
             connection=DriverManager.getConnection(URL,USER,PSW);
             //creazione ed esecuzione query
             statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             
             String query = "SELECT Username FROM utente WHERE Codice= "+codice+";";
             ResultSet rs = statement.executeQuery(query);

             if(rs.first()) {

            	 username = rs.getString("Username");
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
         return username;

    }

}

	