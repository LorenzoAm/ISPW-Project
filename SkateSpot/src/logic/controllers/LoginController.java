package logic.controllers;

import javafx.scene.image.Image;
import logic.beans.LoginBean;
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

            UserContainer.setInstance(user);

            System.out.println(" email : "+UserContainer.getInstance().getEmail()+" password : "+UserContainer.getInstance().getPassword());

            JOptionPane.showMessageDialog(null,"welcome back "+UserContainer.getInstance().getNome()+" "+UserContainer.getInstance().getCognome()+" !","WELCOME",JOptionPane.INFORMATION_MESSAGE);

            if(user.getSpot() != null)
            {
                JOptionPane.showMessageDialog(null," You're currently skating in "+UserContainer.getInstance().getSpot().getNome()+", enjoy your session ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            }

            HomeGuiController.getLoginStage().close();      //viene chiusa la schermata di login e riaperta la home
            HomeMain.getStage().show();
        }
    }
}
