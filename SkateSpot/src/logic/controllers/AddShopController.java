package logic.controllers;

import logic.beans.ShopBean;
import logic.entities.dao.ShopDAO;
import logic.entities.dao.UserDAO;
import logic.exception.ExistingShopException;

import java.time.LocalDate;


public class AddShopController
{
	private static AddShopController instance;

	private AddShopController(){}
	
	public static AddShopController getInstance()
    {
       if(instance == null)
           instance = new AddShopController();
       return instance;
    }
	public void createShop(ShopBean bean) throws ExistingShopException
	{
		Integer code = UserDAO.findCodeUser(UserContainer.getInstance().getEmail(),UserContainer.getInstance().getPassword());  //estraiamo il codice dell'utente loggato dal DB in base alle sue credenziali
		LocalDate date = LocalDate.now();
		ShopDAO.createShop(bean.getPartitaIVA(),bean.getName(),bean.getDescription(),bean.getCity(),bean.getStreet(),bean.getNumber(),bean.getMunicipality(),bean.getArea(),code,date);

	}
	
}
