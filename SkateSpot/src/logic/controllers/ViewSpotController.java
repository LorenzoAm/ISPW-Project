package logic.controllers;

import java.util.ArrayList;

import logic.entities.Spot;
import logic.entities.dao.SpotDAO;

public class ViewSpotController 
{
	private static ViewSpotController instance;
	private ArrayList<Spot> spots= new ArrayList<Spot>();
	
	public static ViewSpotController getInstance()
	{
		if(instance == null)
			instance = new ViewSpotController();
		return instance;
	}
	
	public ArrayList<Spot> getList()
	{
		spots=SpotDAO.getSpots();
		return spots;
	}
}
