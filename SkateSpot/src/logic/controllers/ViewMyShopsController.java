package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.dao.ShopDAO;

public class ViewMyShopsController 
{
	private static ViewMyShopsController instance;
	private ArrayList<Shop> shops= new ArrayList<Shop>();
	
	public static ViewMyShopsController getInstance()
	{
		if(instance == null)
			instance = new ViewMyShopsController();
		return instance;
	}
	
	public ArrayList<Shop> getList()
	{
		shops=ShopDAO.getMyShops();
		return shops;
	}
}
