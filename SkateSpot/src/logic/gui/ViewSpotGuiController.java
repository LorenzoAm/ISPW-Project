package logic.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ViewSpotGuiController 
{
	@FXML private Label nome;
	@FXML private Label numero;
	@FXML private Label indirizzo;
	@FXML private Label zona;
	@FXML private Label comune;
	@FXML private Label tipo;
	@FXML private Label username;
	@FXML private Label data;
	@FXML private Label descrizione;
	
	public void handle(MouseEvent mouseEvent) throws IOException
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
            	HomeGuiController.getViewSpotStage().close();
                HomeMain.getStage().show();
                break;
        }
    }
}
