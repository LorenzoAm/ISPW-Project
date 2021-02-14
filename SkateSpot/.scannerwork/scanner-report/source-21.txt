package logic.controllers;


import logic.beans.LoginBean;
import logic.entities.User;
import logic.entities.dao.UserDAO;


public class LoginController
{
    private static LoginController instance;


    private LoginController(){}

    public static LoginController getInstance()
    {
       if(instance == null)
           instance = new LoginController();
       return instance;
    }

    public void login(LoginBean bean)
    {
        User user = UserDAO.findUser(bean.getEmail(),bean.getPassword());
        if(user != null)
            UserContainer.setInstance(user);

    }
}
