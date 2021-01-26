package logic.gui;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class addShopGuiController 
{
	public void handle(MouseEvent mouseEvent) throws IOException
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
                PremiumAreaGuiController.getAddShopStage().close();
                HomeMain.getStage().show();
                break;
        }
    }
}
