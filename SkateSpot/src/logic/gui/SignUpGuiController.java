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
import logic.beans.SignUpBean;
import logic.controllers.SignUpController;
import logic.exception.ExistingEmailException;


public class SignUpGuiController
{
	
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private TextField username;
	@FXML private TextField email;
	@FXML private PasswordField password;
	@FXML private PasswordField confirmPassword;
	@FXML private DatePicker data;
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
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
		if(value.equals(""))//home button clicked --> re-open home window
		{
				HomeGuiController.getSignUpStage().close();
				HomeMain.getStage().show();
		}
//sign up button clicked --> create beans class
		else
		{
				SignUpBean bean = new SignUpBean(name.getText(), surname.getText(), username.getText(), email.getText(), password.getText(), confirmPassword.getText());//costrutttore
				bean.control(data.getValue(), gender, typeOfAccount);//finisce di passare i dati necesari (sonalCloud non accetta pi� di 7 parametri per costruttore)
				if (bean.check()) 
				{
					try
					{
						SignUpController.getInstance().signUp(bean); //richiamiamo signUp sull'istanza singleton passando i dati verificati dalla bean
					}
					catch(ExistingEmailException e)
					{
						e.printStackTrace();
					}
					finally
					{
						HomeGuiController.getSignUpStage().close();      //viene chiusa la schermata di login e riaperta la home
						HomeMain.getStage().show();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data insert is incorrect:\nName and surname must containt only alphabetics character;\nUsername must contain only alphanumerical characters;\nEmail must be in the form username@domain;\nPassword and confirm password must match;\nYou must be at least 10 years old.");
				}
		}
    }	
}
