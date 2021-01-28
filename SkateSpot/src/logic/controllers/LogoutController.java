package logic.controllers;

import javax.swing.*;

public class LogoutController
{
    private static LogoutController instance;

    private LogoutController(){}

    public static LogoutController getInstance()
    {
        if(instance == null)
            instance = new LogoutController();
        return instance;
    }

    public void logout()
    {
        JOptionPane.showMessageDialog(null," Bye "+UserContainer.getInstance().getNome()+" "+UserContainer.getInstance().getCognome()+", see you soon!","LOGOUT",JOptionPane.INFORMATION_MESSAGE);
        UserContainer.resetInstance();
    }
}
