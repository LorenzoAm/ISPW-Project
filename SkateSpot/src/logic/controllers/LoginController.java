package logic.controllers;

import javafx.scene.image.Image;
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

    public void login(String email,String password)
    {
        User user = UserDAO.findUser(email,password);
        if(user != null)
        {
            JOptionPane.showMessageDialog(null,"welcome back "+user.getNome()+" "+user.getCognome()+" !","WELCOME",JOptionPane.INFORMATION_MESSAGE);
            if(user.getSesso() == "M")
            {
                File file = new File("../resources/male_icon.png");
                Image image = new Image(file.toURI().toString());
                HomeGuiController.getProfilePic().setImage(image);

            }
            else
            {
                File file = new File("../resources/female_icon.png");
                Image image = new Image(file.toURI().toString());
                HomeGuiController.getProfilePic().setImage(image);
            }
            if(user.getTipo() == "Owner")
            {
                HomeGuiController.getPremiumArea().setDisable(false);
            }
            HomeGuiController.getUsernameLab().setText(user.getUsername());

            HomeGuiController.getLoginStage().close();      //viene chiusa la schermata di login e riaperta la home
            HomeMain.getStage().show();
        }
    }
}
