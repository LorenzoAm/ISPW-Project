package logic.gui;

//import javax.swing.JRadioButton;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import logic.bean.SignUpBean;


public class SignUpGuiController
{
	//fxml
	public TextField name;
	public TextField surname;
	public TextField email;
	public PasswordField password;
	public PasswordField confirmPassword;
	public DatePicker data;
	//private JRadioButton genderMale;
	//private JRadioButton genderFemale;

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
            case "Sign up":     //sign up button clicked --> create bean class
            	 SignUpBean bean = new SignUpBean(name.getText(),surname.getText(),email.getText(),password.getText(),confirmPassword.getText(), data.getValue());
            	 System.out.println(bean.toString());
                break;
        }

    }
}
