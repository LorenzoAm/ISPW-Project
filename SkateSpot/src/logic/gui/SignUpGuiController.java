package logic.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import logic.beans.SignUpBean;


public class SignUpGuiController
{
	//fxml
	@FXML public TextField name;
	@FXML public TextField surname;
	@FXML public TextField username;
	@FXML public TextField email;
	@FXML public PasswordField password;
	@FXML public PasswordField confirmPassword;
	@FXML public DatePicker data;
	@FXML private RadioButton maleButton;
	@FXML private RadioButton femaleButton;
	@FXML private RadioButton skaterButton;
	@FXML private RadioButton ownerButton;
	private String gender;
	private String typeOfAccount;
	ToggleGroup genderRadioToggleGroup = new ToggleGroup();
	ToggleGroup typeOfAccountRadioToggleGroup = new ToggleGroup();

	@FXML
	private void radioButtonChanged(ActionEvent event)
	{
		if(maleButton.isSelected())
		{
			gender="M";
		}
		if(femaleButton.isSelected())
		{
			gender="F";
		}
	}
	@FXML
	private void typeOfAccountRadioButtonChanged(ActionEvent event)
	{
		if(skaterButton.isSelected())
		{
			typeOfAccount="Skater";
		}
		if(ownerButton.isSelected())
		{
			typeOfAccount="Owner";
		}
	}
	@FXML
	public void initialize()
	{
		maleButton.setToggleGroup(genderRadioToggleGroup);
		femaleButton.setToggleGroup(genderRadioToggleGroup); 
		skaterButton.setToggleGroup(typeOfAccountRadioToggleGroup);
		ownerButton.setToggleGroup(typeOfAccountRadioToggleGroup); 
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
            case "Sign up":     //sign up button clicked --> create beans class
            	SignUpBean bean = new SignUpBean(name.getText(),surname.getText(),username.getText(),email.getText(),password.getText(),confirmPassword.getText());
            	bean.control(data.getValue(),gender,typeOfAccount);
            	bean.check();
                break;
        }

    }	
}
