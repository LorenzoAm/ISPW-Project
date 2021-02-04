package logic.entities.dao;

import logic.entities.Spot;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SpotDAO
{
    private static final String USER = "root";
    private static final String PSW = "PASSWORD";
    private static final String URL = "jdbc:mysql://localhost:3306/skate_spot";
    
    private SpotDAO() {}

    public static Spot createSpot(Integer code)  //crea un istanza di Spot in base alla chiave esterna di un utente
    {
        Connection connection = null;
        Statement statement = null;
        Spot spot = null;

        try
        {

            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT S.Via,S.Civico,S.Citta,S.Zona,S.Nome,S.Tipo,S.Comune,S.NumeroDiSkater,S.Descrizione,S.DataInserimento,U.Username FROM spot S JOIN utente U ON S.CodiceSkater = U.Codice WHERE S.Codice = '"+ code +"';";

            ResultSet rs = statement.executeQuery(query);

            if(rs.first())
            {
                String indirizzo = rs.getString("Via")+" "+rs.getInt("Civico")+" "+rs.getString("Citta");

                spot = new Spot(indirizzo,rs.getString("Zona"),rs.getString("Nome"),rs.getString("Tipo"),rs.getString("Comune"),rs.getInt("NumeroDiSkater"),rs.getString("Descrizione"),rs.getString("Username"),rs.getDate("DataInserimento"));

                rs.close();
            }
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

    public static void createSpot(String name, String street, String number, String city, String municipality, String area, String type, String description, Integer code, LocalDate date)
    {
        Connection connection = null; //interface
        Statement statement = null;
        int retFromQuery;
        try
        {
            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            Integer streetNumber = Integer.parseInt(number);

            String query = "SELECT * FROM spot WHERE Via = '"+street+"' AND Civico = '"+streetNumber+"';";
            ResultSet rs = statement.executeQuery(query);

            if (!rs.first()) //la query non ha prodotto risultati
            {
                //Inserisco dati nel db
                query = "INSERT INTO spot(Via,Civico,Citta,Zona,Nome,Tipo,Comune,NumeroDiSkater,Descrizione,CodiceSkater,DataInserimento) VALUES ('"+street+"','"+streetNumber+"','"+city+"','"+area+"','"+name+"','"+type+"','"+municipality+"','0','"+description+"','"+code+"','"+date+"');";
                retFromQuery = statement.executeUpdate(query);
                if (retFromQuery==2) //la query non ha prodotto risultati
                {
                    JOptionPane.showMessageDialog(null," OPS! Something went wrong."," ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null," Your data has been saved into db!","INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                }

            }
            else
            {
                //Messagio Errore
                JOptionPane.showMessageDialog(null," The spot already exists ! "," ERROR",JOptionPane.ERROR_MESSAGE);

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
    public static ArrayList<Spot> getSpots()
    {
    	Connection connection = null;
        Statement statement = null;
        Spot spot = null;
        ArrayList<Spot> spots = new ArrayList<Spot>();

        try
        {

            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM spot ;";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String indirizzo = rs.getString("Via")+", "+rs.getInt("Civico")+", "+rs.getString("Citta");
                String username=UserDAO.getUsername(rs.getInt("CodiceSkater"));
                spot = new Spot(indirizzo,rs.getString("Zona"),rs.getString("Nome"),rs.getString("Tipo"),rs.getString("Comune"),rs.getInt("NumeroDiSkater"),rs.getString("Descrizione"),username,rs.getDate("DataInserimento"));
                spots.add(spot);
            }
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
        return spots;
    }
}
