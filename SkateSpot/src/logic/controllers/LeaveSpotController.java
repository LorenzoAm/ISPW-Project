package logic.controllers;


import logic.entities.dao.UserDAO;

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
        UserDAO.leaveSpot(UserContainer.getInstance().getEmail(),UserContainer.getInstance().getPassword());
        UserContainer.getInstance().setSpot(null);
    }
}
