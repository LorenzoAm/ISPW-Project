package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.DAO.ShopDAO;

public class ViewMyShopsController 
{
private static ViewMyShopsController instance;
	
	private ViewMyShopsController() {};
	
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
