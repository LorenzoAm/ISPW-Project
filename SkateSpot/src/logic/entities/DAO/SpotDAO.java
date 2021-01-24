package logic.entities.DAO;

import logic.entities.Spot;
import logic.entities.User;

import java.sql.*;

public class SpotDAO
{
    private static String USER = "root";
    private static String PSW = "PASSWORD";
    private static String URL = "jdbc:mysql://localhost:3306/skate_spot";
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    public static Spot createSpot(Integer code)
    {
        Connection connection = null;
        Statement statement = null;
        Spot spot = null;

        try
        {
            Class.forName(DRIVER_CLASS_NAME);

            connection = DriverManager.getConnection(URL,USER,PSW);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT S.Via,S.Civico,S.Città,S.Zona,S.Nome,S.Tipo,S.Comune,S.NumeroDiSkater,S.Descrizione,S.Immagine,S.Rating,S.Data,U.Username FROM spot S JOIN utente U ON S.CodiceSkater = U.Codice WHERE S.Codice = '"+ code +"';";

            ResultSet rs = statement.executeQuery(query);

            if(rs.first())
            {
                String indirizzo = rs.getString("Via")+" "+rs.getInt("Civico")+" "+rs.getString("Città");

                spot = new Spot(indirizzo,rs.getString("Zona"),rs.getString("Nome"),rs.getString("Tipo"),rs.getString("Comune"),rs.getInt("NumeroDiSkater"),rs.getString("Descrizione"),rs.getString("Immagine"),rs.getInt("Rating"),rs.getString("Username"),rs.getDate("Data"));

                rs.close();
            }
        }
        catch(SQLException | ClassNotFoundException e)
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

            return spot;
        }
    }
}
