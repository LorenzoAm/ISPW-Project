package logic.controllers;

import logic.beans.ShopBean;
import logic.entities.DAO.ShopDAO;

public class ShopController 
{
	private static ShopController instance;
	private ShopController(){}	
	
	public static ShopController getInstance()
    {
       if(instance == null)
           instance = new ShopController();
       return instance;
    }
	public void createShop(ShopBean bean)
	{
		ShopDAO.createShop(bean.getPartitaIVA(),bean.getName(),bean.getDescription(),bean.getCity(),bean.getStreet(),bean.getNumber(),bean.getMunicipality(),bean.getArea(),bean.getCode());
	}
	
}
