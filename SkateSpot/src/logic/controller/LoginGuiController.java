package logic.controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginGuiController
{
    private Stage home;

    public LoginGuiController(Stage home)
    {
        this.home = home;
    }

    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                home.show();
                break;
            case "Sign In":     //login button clicked --> create bean class
                //IMPLEMENT SIGN IN USE CASE
                break;
        }
    }
}
