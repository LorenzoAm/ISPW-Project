package logic.controllers;

import logic.beans.JoinSpotBean;
import logic.entities.dao.UserDAO;
import logic.exception.FullSpotException;
import logic.exception.SpotNotFoundException;


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

    public void joinSpot(JoinSpotBean bean) throws FullSpotException,SpotNotFoundException
    {
        UserContainer.getInstance().setSpot(UserDAO.joinSpot(bean.getStreet(),bean.getNumber(),bean.getCity()));
    }
}
