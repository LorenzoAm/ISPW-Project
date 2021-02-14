package logic.gui;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.LoginBean;
import logic.controllers.LoginController;
import logic.controllers.UserContainer;


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
        if(value.equals(""))//home button clicked --> re-open home window
        {
                HomeGuiController.getLoginStage().close();
                HomeMain.getStage().show();
        }
//login button clicked --> create beans class
        else
        {
                LoginBean bean = new LoginBean(email.getText(), password.getText());
                if (bean.check()) {
                    LoginController.getInstance().login(bean); //richiamiamo login sull'istanza singleton passando i dati verificati dalla bean
                    if(UserContainer.getInstance()!=null)
                    {
                    	 JOptionPane.showMessageDialog(null,"Welcome back "+UserContainer.getInstance().getNome()+" "+UserContainer.getInstance().getCognome()+" !","WELCOME",JOptionPane.INFORMATION_MESSAGE);
                    	 if(UserContainer.getInstance().getSpot() != null)
                         {
                             JOptionPane.showMessageDialog(null," You're currently skating in "+UserContainer.getInstance().getSpot().getNome()+", enjoy your session ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                         }
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(null," Entered data doesn't match with any user! ","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                HomeGuiController.getLoginStage().close();      //viene chiusa la schermata di login e riaperta la home
                HomeMain.getStage().show();
        }
    }
}
