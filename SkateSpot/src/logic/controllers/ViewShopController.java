package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.dao.ShopDAO;

public class ViewShopController 
{
	private static ViewShopController instance;
	private ArrayList<Shop> shops= new ArrayList<Shop>();
	
	public static ViewShopController getInstance()
	{
		if(instance == null)
			instance = new ViewShopController();
		return instance;
	}
	
	public ArrayList<Shop> getList()
	{
		shops=ShopDAO.getMyShops();
		return shops;
	}
}
