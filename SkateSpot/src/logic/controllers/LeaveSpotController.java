package logic.controllers;

import javax.swing.*;

import logic.entities.DAO.UserDAO;

public class LeaveSpotController
{
    private static LeaveSpotController instance;

    private LeaveSpotController(){}

    public static LeaveSpotController getInstance()
    {
        if (instance == null)
            instance = new LeaveSpotController();
        return instance;
    }

    public void leaveSpot()
    {
        JOptionPane.showMessageDialog(null," You're leaving "+UserContainer.getInstance().getSpot().getNome()+",hope you enjoyed your session!","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        UserDAO.leaveSpot(UserContainer.getInstance().getEmail(),UserContainer.getInstance().getPassword());
        UserContainer.getInstance().setSpot(null);
    }
}
