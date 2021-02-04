package logic.controllers;

import logic.beans.JoinSpotBean;
import logic.entities.dao.UserDAO;

import javax.swing.*;

public class JoinSpotController
{
    private static JoinSpotController instance;

    private JoinSpotController(){}

    public static JoinSpotController getInstance()
    {
        if(instance == null)
            instance = new JoinSpotController();
        return instance;
    }

    public void joinSpot(JoinSpotBean bean)
    {
        UserContainer.getInstance().setSpot(UserDAO.joinSpot(bean.getStreet(),bean.getNumber(),bean.getCity()));
        if(UserContainer.getInstance().getSpot()!=null)
            JOptionPane.showMessageDialog(null," You've joined "+UserContainer.getInstance().getSpot().getNome()+", enjoy your session!","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
    }
}
