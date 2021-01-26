package logic.beans;

import javax.swing.JOptionPane;

import logic.entities.DAO.UserDAO;
import logic.entities.User;

public class ShopBean 
{
	private String name;
	private String city;
	private String partitaIVA;
	private String municipality;
	private String area;
	private String description;
	private String street;
	private String number;
	private String code;
	private String alert;
	private int dim=11;
	public ShopBean()
	{
		
	}
	public ShopBean(String name,String city,String partitaIVA,String municipality,String area,String description)
	{
		setName(name);
		setCity(city);
		setPartitaIVA(partitaIVA);
		setMunicipality(municipality);
		setArea(area);
		setDescription(description);
		setCode();
	}
	public void control(String street,String number)
	{
		setStreet(street);
		setNumber(number);
	}
	public void setCode()
	{
		code=UserDAO.findCodeUser(User.getEmail(),User.getPassword());
	}
	public String getCode()
	{
		return code;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getCity()
	{
		return city;
	}
	public void setPartitaIVA(String partitaIVA)
	{
		this.partitaIVA=partitaIVA;
	}
	public String getPartitaIVA()
	{
		return partitaIVA;
	}
	public void setMunicipality(String municipality)
	{
		this.municipality=municipality;
	}
	public String getMunicipality()
	{
		return municipality;
	}
	public void setArea(String area)
	{
		this.area=area;
	}
	public String getArea()
	{
		return area;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return description;
	}
	public void setStreet(String street)
	{
		this.street=street;
	}
	public String getStreet()
	{
		return street;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getNumber()
	{
		return number;
	}
	
	public boolean check()
	{
		if(checkName()&&checkCity()&&checkPartitaIVA()&&checkMunicipality()&&checkArea()&&checkDescription()&&checkStreet()&&checkNumber())
		{
			JOptionPane.showMessageDialog(null, "data entered correctly.");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, alert);
			return false;
		}
		
	}
	
	private boolean checkName()
	{
		if ( (name!="") && (name != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name of the shop isn't entered.";
			return false;
		}
	}
	private boolean checkCity()
	{
		if ( (city!="") && (city != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name of the city isn't entered.";
			return false;
		}
	}
	private boolean checkPartitaIVA()
	{
		if ( (partitaIVA!="") && (partitaIVA != null) && (partitaIVA.matches("^[0-9]*$")) && (partitaIVA.length()== dim)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe VAT number isn't correct.";
			return false;
		}
	}
	private boolean checkMunicipality()
	{
		if ( (municipality!="") && (municipality != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe municipality isn't entered.";
			return false;
		}
	}
	private boolean checkArea()
	{
		if ( (area!="") && (area != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe area isn't entered.";
			return false;
		}
	}
	private boolean checkDescription()
	{
		if ( (description!="") && (description != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe description isn't entered.";
			return false;
		}
	}
	private boolean checkStreet()
	{
		if ( (street!="") && (street != null)) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe street isn't entered.";
			return false;
		}
	}
	private boolean checkNumber()
	{
		if ( (number!="") && (number != null) && (number.matches("^[0-9]*$"))) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe number isn't correct.";
			return false;
		}
	}
	
}
