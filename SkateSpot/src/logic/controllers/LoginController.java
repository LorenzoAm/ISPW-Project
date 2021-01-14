package logic.controllers;

import javafx.scene.image.Image;
import logic.beans.LoginBean;
import logic.beans.PushBean;
import logic.entities.DAO.UserDAO;
import logic.entities.User;
import logic.gui.HomeGuiController;
import logic.gui.HomeMain;

import javax.swing.*;
import java.io.File;

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
        {
            File file;
            Image image;

            JOptionPane.showMessageDialog(null,"welcome back "+user.getNome()+" "+user.getCognome()+" !","WELCOME",JOptionPane.INFORMATION_MESSAGE);

            PushBean push = new PushBean(user.getUsername(),user.getSesso(),user.getTipo());

            HomeGuiController home = new HomeGuiController();
            home.changeUserInfo(push);

            HomeGuiController.getLoginStage().close();      //viene chiusa la schermata di login e riaperta la home
            HomeMain.getStage().show();
        }
    }
}
