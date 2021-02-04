package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.dao.ShopDAO;

public class ViewMyShopsController 
{
private static ViewMyShopsController instance;
	
	public static ViewMyShopsController getInstance()
	{
		if(instance == null)
			instance = new ViewMyShopsController();
		return instance;
	}
	
	public ArrayList<Shop> getList()
	{
		return ShopDAO.getMyShops();
	}
}
