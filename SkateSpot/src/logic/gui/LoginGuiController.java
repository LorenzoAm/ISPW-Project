package logic.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.LoginBean;


public class LoginGuiController
{

    @FXML
    public TextField email;
    public PasswordField password;

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
            case "Sign in":     //login button clicked --> create beans class
                LoginBean bean = new LoginBean(email.getText(),password.getText());
                break;
        }
    }
}
