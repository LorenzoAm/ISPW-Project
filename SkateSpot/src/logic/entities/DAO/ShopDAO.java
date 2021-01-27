package logic.entities.DAO;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ShopDAO
{
    private static String USER = "root";
    private static String PSW = "PASSWORD";
    private static String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static void createShop(String partitaIVA, String name, String description, String city, String street, String number, String municipality, String area, Integer code, LocalDate date)
	{
    	Connection connection = null; //interface
        Statement statement = null;
        int retFromQuery;
        try
        {
            //loading dinamico del driver specifico

            Class.forName(DRIVER_CLASS_NAME);
            //apertura della connessione
            connection=DriverManager.getConnection(URL,USER,PSW);
            //creazione ed esecuzione query
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            Integer streetNumber = Integer.parseInt(number);

            String query = "SELECT * FROM shop WHERE PartitaIVA = '"+partitaIVA+"' OR Nome = '"+name+"' OR (Via = '"+street+"' AND Civico = '"+streetNumber+"');";
            ResultSet rs = statement.executeQuery(query);
           
            if (!rs.first()) //la query non ha prodotto risultati
            {
                //Inserisco dati nel db
            	query = "INSERT INTO shop (PartitaIVA,Nome,Descrizione,Immagine,Citta,Via,Civico,Comune,Zona,CodiceProprietario,DataInserimento) VALUES ('"+partitaIVA+"','"+name+"','"+description+"','','"+city+"','"+street+"','"+number+"','"+municipality+"','"+area+"','"+code+"','"+date+"');";
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
            	JOptionPane.showMessageDialog(null," The shop already exists ! "," ERROR",JOptionPane.ERROR_MESSAGE);

            }

            //chiudiamo il result set generato dalla query
            rs.close();

        }
        catch(SQLException  | ClassNotFoundException e)
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
