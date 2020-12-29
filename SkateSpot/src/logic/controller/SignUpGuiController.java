package logic.controller;

import com.sun.glass.ui.Application;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import logic.gui.HomeMain;


public class SignUpGuiController
{


    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":        //home button clicked --> re-open home window
                HomeGuiController.getSignUpStage().close();
                HomeMain.getStage().show();
                break;
            case "Sign Up":     //sign up button clicked --> create bean class
                //IMPLEMENT SING UP USE CASE
                break;
        }

    }
}
