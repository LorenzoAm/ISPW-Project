package logic.controllers;

import logic.beans.SignUpBean;
import logic.entities.dao.UserDAO;
import logic.gui.HomeGuiController;
import logic.gui.HomeMain;

public class SignUpController
{
	private static SignUpController instance;

	private SignUpController(){}
	
	public static SignUpController getInstance()
    {
       if(instance == null)
           instance = new SignUpController();
       return instance;
    }
	
	public void signUp(SignUpBean bean)
	{
		UserDAO.createUser(bean.getName(),bean.getSurname(),bean.getUsername(),bean.getEmail(),bean.getPassword(),bean.getDate(),bean.getGender(),bean.getTypeOfAccount());
		HomeGuiController.getSignUpStage().close();      //viene chiusa la schermata di login e riaperta la home
		HomeMain.getStage().show();
	}
}
