package logic.controllers;

import java.util.ArrayList;

import logic.entities.Spot;
import logic.entities.DAO.SpotDAO;

public class ViewSpotController 
{
	public static ArrayList<Spot> getList()
	{
		ArrayList<Spot> spots=SpotDAO.getSpots();
		return spots;
	}
}
