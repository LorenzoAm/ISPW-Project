package logic.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.SpotBean;
import logic.controllers.AddSpotController;
import logic.exception.ExistingSpotException;

public class AddSpotGUIController
{
    @FXML private TextField name;
    @FXML private TextField street;
    @FXML private TextField number;
    @FXML private TextField city;
    @FXML private TextField municipality;
    @FXML private TextField area;
    @FXML private TextField type;
    @FXML private TextField description;

    public void handle(MouseEvent mouseEvent) throws IOException
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        if(value.equals(""))//home button clicked --> re-open home window
         {
                HomeGuiController.getAddSpotStage().close();
                HomeMain.getStage().show();
         }
        else
        {
                SpotBean bean = new SpotBean(name.getText(), street.getText(), number.getText(), city.getText(), municipality.getText(), area.getText());//costruttore
                bean.control(type.getText(), description.getText());//finisce di passare i dati necessari (sonalCloud non accetta pi� di 7 parametri per costruttore)
                if (bean.check()) 
                {
                	try 
                	{
                		AddSpotController.getInstance().createSpot(bean);
                	}
                	catch(ExistingSpotException e) 
                	{
                		e.printStackTrace();
                	}
                	finally
                	{
                		HomeGuiController.getAddSpotStage().close();
                		HomeMain.getStage().show();
                	}
                }
         }
        
    }
}
