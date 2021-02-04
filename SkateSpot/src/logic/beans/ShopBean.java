package logic.beans;

import javax.swing.JOptionPane;


public class ShopBean 
{
	private String name="";
	private String city="";
	private String partitaIVA="";
	private String municipality="";
	private String area="";
	private String description="";
	private String street="";
	private String number="";
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
		if ( !name.equals("")) 
		{ 
			this.name=name;
		}
		else
		{
			alert+="\nThe name of the shop wasn't entered.";
		}
		
	}
	public String getName()
	{
		return name;
	}
	public void setCity(String city)
	{
		if ( !city.equals("")) 
		{ 
			this.city=city;
		}
		else
		{
			alert+="\nThe name of the city wasn't entered.";
		}		
	}
	public String getCity()
	{
		return city;
	}
	public void setPartitaIVA(String partitaIVA)
	{
		if ( !(partitaIVA.equals("")) && (partitaIVA.matches("^[0-9]*$")) && (partitaIVA.length()== 11))
		{ 
			this.partitaIVA=partitaIVA;
		}
		else
		{
			alert+="\nThe VAT number isn't correct.";
		}		
	}
	public String getPartitaIVA()
	{
		return partitaIVA;
	}
	public void setMunicipality(String municipality)
	{
		if ( !municipality.equals("")) 
		{ 
			this.municipality=municipality;
		}
		else
		{
			alert+="\nThe municipality wasn't entered.";
		}		
	}
	public String getMunicipality()
	{
		return municipality;
	}
	public void setArea(String area)
	{
		if ( !area.equals("")) 
		{ 
			this.area=area;
		}
		else
		{
			alert+="\nThe area wasn't entered.";
		}		
	}
	public String getArea()
	{
		return area;
	}
	public void setDescription(String description)
	{
		if ( !description.equals("")) 
		{ 
			this.description=description;
		}
		else
		{
			alert+="\nThe description wasn't entered.";
		}
		
	}
	public String getDescription()
	{
		return description;
	}
	public void setStreet(String street)
	{
		if ( !street.equals("")) 
		{ 
			this.street=street;
		}
		else
		{
			alert+="\nThe street wasn't entered.";
		}
		
	}
	public String getStreet()
	{
		return street;
	}
	public void setNumber(String number)
	{
		if ( !(number.equals("")) && (number.matches("^[0-9]*$"))) 
		{ 
			this.number=number;
		}
		else
		{
			alert+="\nThe number wasn't correct.";
		}
		
	}
	public String getNumber()
	{
		return number;
	}
	
	public boolean check()
	{
		if(!name.equals("")&&!city.equals("")&&!partitaIVA.equals("")&&!municipality.equals("")&&!area.equals("")&&!description.equals("")&&!street.equals("")&&!number.equals(""))
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
}