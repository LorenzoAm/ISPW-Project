package logic.gui;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.JoinSpotBean;
import logic.controllers.JoinSpotController;
import logic.controllers.UserContainer;
import logic.exception.FullSpotException;
import logic.exception.SpotNotFoundException;


public class JoinSpotGUIController
{
    @FXML private TextField street;
    @FXML private TextField number;
    @FXML private TextField city;


    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        if(value.equals("")) {
        						//home button clicked --> re-open home window
                HomeGuiController.getJoinSpotStage().close();
                HomeMain.getStage().show();
        }
        							//login button clicked --> create beans class
        else
        {
                JoinSpotBean bean = new JoinSpotBean(street.getText(), number.getText(), city.getText());
                if (bean.check()) 
                {
                	try 
                	{
                		JoinSpotController.getInstance().joinSpot(bean); //richiamiamo login sull'istanza singleton passando i dati verificati dalla bean
                		JOptionPane.showMessageDialog(null," You've joined "+UserContainer.getInstance().getSpot().getNome()+", enjoy your session!","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                	}
                	catch(FullSpotException | SpotNotFoundException e)
                	{
                		e.printStackTrace();
                	}
                    finally
                    {
                    	HomeGuiController.getJoinSpotStage().close();
                    	HomeMain.getStage().show();
                    }
                }
        }
    }
}
