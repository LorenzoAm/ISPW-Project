package logic.controllers;

import logic.beans.SpotBean;
import logic.entities.DAO.SpotDAO;
import logic.entities.DAO.UserDAO;
import logic.gui.HomeGuiController;
import logic.gui.HomeMain;

import java.time.LocalDate;

public class AddSpotController
{
    private static AddSpotController instance;

    private AddSpotController(){}

    public static AddSpotController getInstance()
    {
        if(instance == null)
            instance = new AddSpotController();
        return instance;
    }

    public void createSpot(SpotBean bean)
    {
        Integer code = UserDAO.findCodeUser(UserContainer.getInstance().getEmail(),UserContainer.getInstance().getPassword());
        LocalDate date = LocalDate.now();
        SpotDAO.createSpot(bean.getName(),bean.getStreet(),bean.getNumber(),bean.getCity(),bean.getMunicipality(),bean.getArea(),bean.getType(),bean.getDescription(),code,date);

        HomeGuiController.getAddSpotStage().close();
        HomeMain.getStage().show();
    }
}