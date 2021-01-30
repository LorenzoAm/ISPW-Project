package logic.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.LoginBean;
import logic.controllers.LoginController;


public class LoginGuiController
{

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    public void handle(MouseEvent mouseEvent)
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch (value) {
//home button clicked --> re-open home window
            case "" -> {
                HomeGuiController.getLoginStage().close();
                HomeMain.getStage().show();
            }
//login button clicked --> create beans class
            case "Sign in" -> {
                LoginBean bean = new LoginBean(email.getText(), password.getText());
                if (bean.check()) {
                    LoginController.getInstance().login(bean); //richiamiamo login sull'istanza singleton passando i dati verificati dalla bean
                }
            }
        }
    }
}
