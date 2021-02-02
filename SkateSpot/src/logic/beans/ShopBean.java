package logic.beans;

import javax.swing.JOptionPane;


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
	private String alert;

	public ShopBean(String name,String city,String partitaIVA,String municipality,String area,String description)
	{
		setName(name);
		setCity(city);
		setPartitaIVA(partitaIVA);
		setMunicipality(municipality);
		setArea(area);
		setDescription(description);
	}
	public void control(String street,String number)
	{
		setStreet(street);
		setNumber(number);
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
		if ( !name.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name of the shop wasn't entered.";
			return false;
		}
	}
	private boolean checkCity()
	{
		if ( !city.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name of the city wasn't entered.";
			return false;
		}
	}
	private boolean checkPartitaIVA()
	{
		if ( !(partitaIVA.equals("")) && (partitaIVA.matches("^[0-9]*$")) && (partitaIVA.length()== 11))
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
		if ( !municipality.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe municipality wasn't entered.";
			return false;
		}
	}
	private boolean checkArea()
	{
		if ( !area.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe area wasn't entered.";
			return false;
		}
	}
	private boolean checkDescription()
	{
		if ( !description.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe description wasn't entered.";
			return false;
		}
	}
	private boolean checkStreet()
	{
		if ( !street.equals("")) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe street wasn't entered.";
			return false;
		}
	}
	private boolean checkNumber()
	{
		if ( !(number.equals("")) && (number.matches("^[0-9]*$"))) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe number wasn't correct.";
			return false;
		}
	}
	
}
