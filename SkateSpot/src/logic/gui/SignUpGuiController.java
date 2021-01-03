package logic.gui;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import logic.bean.SignUpBean;


public class SignUpGuiController
{
	//fxml
	@FXML public TextField name;
	@FXML public TextField surname;
	@FXML public TextField email;
	@FXML public PasswordField password;
	@FXML public PasswordField confirmPassword;
	@FXML public DatePicker data;
	@FXML private RadioButton maleButton;
	@FXML private RadioButton femaleButton;
	private String gender;
	ToggleGroup radioToggleGroup = new ToggleGroup();

	@FXML
	private void radioButtonChanged(ActionEvent event)
	{
		if(maleButton.isSelected())
		{
			gender="Male";
		}
		if(femaleButton.isSelected())
		{
			gender="Female";
		}
	}
	@FXML
	public void initialize()
	{
		maleButton.setToggleGroup(radioToggleGroup);
		femaleButton.setToggleGroup(radioToggleGroup); 
	}
    public void handle(MouseEvent mouseEvent)
    {
    	this.initialize();
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":        //home button clicked --> re-open home window
                HomeGuiController.getSignUpStage().close();
                HomeMain.getStage().show();
                break;
            case "Sign up":     //sign up button clicked --> create bean class
            	SignUpBean bean = new SignUpBean(name.getText(),surname.getText(),email.getText(),password.getText(),confirmPassword.getText(), data.getValue(),gender);
                break;
        }

    }	
}
