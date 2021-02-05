package logic.controllers;

import logic.beans.SpotBean;
import logic.entities.dao.SpotDAO;
import logic.entities.dao.UserDAO;

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
    }
}
