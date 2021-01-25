package logic.controllers;

import javafx.scene.image.Image;
import logic.beans.LoginBean;
import logic.beans.PullBean;
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

            if(user.getSpot() != null)
            {
                JOptionPane.showMessageDialog(null," You're currently skating in "+user.getSpot().getNome()+", enjoy your session ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            }

            //TODO aggiornare la view dopo che l'utente ha effettuato il login

            HomeGuiController.setLogged(true);      //settiamo a true la variabile globale di login
            HomeGuiController.getLoginStage().close();      //viene chiusa la schermata di login e riaperta la home
            HomeMain.getStage().show();
        }
    }
}
