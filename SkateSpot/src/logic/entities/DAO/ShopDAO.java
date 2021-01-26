package logic.entities.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

public class ShopDAO
{
    private static String USER = "root";
    private static String PSW = "PASSWORD";
    private static String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public static void createShop(String partitaIVA,String name,String description,String city,String street,String number,String municipality,String area,String code)
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
            String query = "SELECT * FROM shop WHERE PartitaIVA = '"+partitaIVA+"' AND NOME= '"+name+"';";
            ResultSet rs = statement.executeQuery(query);
           
            if (!rs.first()) //la query non ha prodotto risultati
            {
                //Inserisco dati nel db
            	query = "INSERT INTO shop (PartitaIVA,Nome,Descrizione,Citta,Via,Civico,Comune,Zona,CodiceProprietario) VALUES ('"+partitaIVA+"','"+name+"','"+description+"','"+name+"','"+city+"','"+street+"','"+number+"','"+municipality+"','"+area+"','"+code+"');";
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
            	JOptionPane.showMessageDialog(null," VAT number and same name already in use!"," ERROR",JOptionPane.ERROR_MESSAGE);

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
