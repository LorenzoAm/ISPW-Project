package logic.controller;

import com.sun.glass.ui.Application;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SignUpGuiController
{
    private Stage home;

    public SignUpGuiController(Stage home)
    {
        this.home = home;
    }

    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":        //home button clicked --> re-open home window
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
                home.show();
                break;
            case "Sign Up":     //sign up button clicked --> create bean class
                //IMPLEMENT SING UP USE CASE
                break;
        }

    }
}
