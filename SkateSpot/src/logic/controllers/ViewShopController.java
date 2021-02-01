package logic.controllers;

import java.util.ArrayList;

import logic.entities.Shop;
import logic.entities.DAO.ShopDAO;

public class ViewShopController 
{
	public static ArrayList<Shop> getList()
	{
		ArrayList<Shop> shops=ShopDAO.getShops();
		return shops;
	}
}
