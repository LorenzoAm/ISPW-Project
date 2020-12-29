package logic.controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import logic.gui.HomeMain;


public class LoginGuiController
{

    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
                HomeGuiController.getLoginStage().close();
                HomeMain.getStage().show();
                break;
            case "Sign In":     //login button clicked --> create bean class
                //IMPLEMENT SIGN IN USE CASE
                break;
        }
    }
}
