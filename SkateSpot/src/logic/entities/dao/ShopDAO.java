package logic.entities.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import logic.controllers.UserContainer;
import logic.entities.Shop;

public class ShopDAO
{
    private static final String USER = "root";
    private static final String PSW = "PASSWORD";
    private static final String URL = "jdbc:mysql://localhost:3306/skate_spot";
<<<<<<< HEAD
=======
    
>>>>>>> stash

    private ShopDAO( ) {}
    public static void createShop(String partitaIVA, String name, String description, String city, String street, String number, String municipality, String area, Integer code, LocalDate date)
	{
    	Connection connection = null; //interface
        Statement statement = null;
        int retFromQuery;
        try
        {
<<<<<<< HEAD
=======
           
>>>>>>> stash
            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            int streetNumber = Integer.parseInt(number);

            String query = "SELECT * FROM shop WHERE PartitaIVA = '"+partitaIVA+"' OR Nome = '"+name+"' OR (Via = '"+street+"' AND Civico = '"+streetNumber+"');";
            ResultSet rs = statement.executeQuery(query);
           
            if (!rs.first()) //la query non ha prodotto risultati
            {
                //Inserisco dati nel db
            	query = "INSERT INTO shop (PartitaIVA,Nome,Descrizione,Citta,Via,Civico,Comune,Zona,CodiceProprietario,DataInserimento) VALUES ('"+partitaIVA+"','"+name+"','"+description+"','"+city+"','"+street+"','"+streetNumber+"','"+municipality+"','"+area+"','"+code+"','"+date+"');";
            	retFromQuery = statement.executeUpdate(query);
            	/*if (retFromQuery==2) //la query non ha prodotto risultati
                {
            		JOptionPane.showMessageDialog(null," OPS! Something went wrong."," ERROR",JOptionPane.ERROR_MESSAGE);
                }
            	else
            	{
            		JOptionPane.showMessageDialog(null," Your data has been saved into db!","INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            	}*/
            	
            }
           /* else
            {
                //Messagio Errore
            	JOptionPane.showMessageDialog(null," The shop already exists ! "," ERROR",JOptionPane.ERROR_MESSAGE);

            }*/	

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
    
    public static ArrayList<Shop> getShops()
    {
    	Connection connection = null;
        Statement statement = null;
        Shop shop = null;
        ArrayList<Shop> shops = new ArrayList<Shop>();

        try
        {

            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT * FROM shop ;";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String indirizzo = rs.getString("Via")+", "+rs.getInt("Civico")+", "+rs.getString("Citta");
                String username=UserDAO.getUsername(rs.getInt("CodiceProprietario"));
                shop = new Shop(rs.getString("PartitaIVA"),rs.getString("Nome"),rs.getString("Descrizione"),indirizzo,rs.getString("Zona"),rs.getString("Comune"),username,rs.getDate("DataInserimento"));
                shops.add(shop);
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
        return shops;
    }

	public static ArrayList<Shop> getMyShops() 
	{
		Connection connection = null;
        Statement statement = null;
        Shop shop = null;
        ArrayList<Shop> shops = new ArrayList<>();

        try
        {
<<<<<<< HEAD
=======

>>>>>>> stash
            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT S.Via,S.Civico,S.Citta,S.CodiceProprietario,S.PartitaIVA,S.Nome,S.Descrizione,S.Zona,S.Comune,S.DataInserimento FROM shop S JOIN utente U ON S.CodiceProprietario = U.Codice WHERE U.Email = '"+UserContainer.getInstance().getEmail()+"' AND U.Password = '"+UserContainer.getInstance().getPassword()+"';";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String indirizzo = rs.getString("S.Via")+", "+rs.getInt("S.Civico")+", "+rs.getString("S.Citta");
                String username=UserDAO.getUsername(rs.getInt("S.CodiceProprietario"));
                shop = new Shop(rs.getString("S.PartitaIVA"),rs.getString("S.Nome"),rs.getString("S.Descrizione"),indirizzo,rs.getString("S.Zona"),rs.getString("S.Comune"),username,rs.getDate("S.DataInserimento"));
                shops.add(shop);
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
        return shops;
	}
}
