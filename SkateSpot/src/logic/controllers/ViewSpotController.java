package logic.controllers;

import java.util.ArrayList;
import logic.entities.DAO.SpotDAO;
import logic.entities.Spot;

public class ViewSpotController 
{
	private static ViewSpotController instance;
	
	public static ViewSpotController getInstance()
	{
		if(instance == null)
			instance = new ViewSpotController();
		return instance;
	}
	
	public ArrayList<Spot> getList()
	{
		return SpotDAO.getSpots();
	}
}
