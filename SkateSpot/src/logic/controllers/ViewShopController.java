package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.dao.ShopDAO;

public class ViewShopController 
{
	private static ViewShopController instance;
	
	public static ViewShopController getInstance()
	{
		if(instance == null)
			instance = new ViewShopController();
		return instance;
	}
	
	public ArrayList<Shop> getList()
	{
		return ShopDAO.getShops();
	}
}
