package logic.entities.dao;

import logic.entities.Spot;
import logic.exception.ExistingSpotException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SpotDAO
{
    private static final String USER = "root";
    private static final String PSW = "PASSWORD";
    private static final String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String typeL;
    private static String areaL;
    private static String descriptionL;
    private static Connection connection=null;
    private static Statement statement = null;
    private static ResultSet rs;

    private SpotDAO( ) {}
    
    public static void addValues(String type,String area, String description)
    {
    	typeL=type;
    	areaL=area;
    	descriptionL=description;
    }
    private static void connect(String query)
    {
    	try
        {

            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            rs = statement.executeQuery(query);

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
    public static Spot createSpot(Integer code)  //crea un istanza di Spot in base alla chiave esterna di un utente
    {
        Spot spot = null;
        String query = "SELECT S.Via,S.Civico,S.Citta,S.Zona,S.Nome,S.Tipo,S.Comune,S.NumeroDiSkater,S.Descrizione,S.DataInserimento,U.Username FROM spot S JOIN utente U ON S.CodiceSkater = U.Codice WHERE S.Codice = '"+ code +"';";
        connect(query);
        try
        {
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
        return spot;
    }

    public static void createSpot(String name, String street, String number, String city, String municipality, Integer code, LocalDate date) throws ExistingSpotException
    {
       

            Integer streetNumber = Integer.parseInt(number);

            String query = "SELECT * FROM spot WHERE Via = '"+street+"' AND Civico = '"+streetNumber+"';";
            
            connect(query);
            try
            {
            	if (!rs.first()) //la query non ha prodotto risultati
            	{
            		//Inserisco dati nel db
            		query = "INSERT INTO spot(Via,Civico,Citta,Zona,Nome,Tipo,Comune,NumeroDiSkater,Descrizione,CodiceSkater,DataInserimento) VALUES ('"+street+"','"+streetNumber+"','"+city+"','"+areaL+"','"+name+"','"+typeL+"','"+municipality+"','0','"+descriptionL+"','"+code+"','"+date+"');";
            		statement.executeUpdate(query);

            	}
            	else
            	{
            		throw new ExistingSpotException();
            	}
      
            	rs.close();

            }
            catch(SQLException e)
            {
            	e.printStackTrace();
            }        
    }
    public static ArrayList<Spot> getSpots()
    {
        Spot spot = null;
        ArrayList<Spot> spots = new ArrayList<>();
        String query = "SELECT * FROM spot ;";
        connect(query);
        try
        {     
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
        return spots;
    }
}
