package logic.beans;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;

public class SpotBean
{
    private String name;
    private String street;
    private String number;
    private String city;
    private String municipality;
    private String area;
    private String type;
    private String description;
    private String alert;

    public SpotBean(String name,String street,String number,String city,String municipality,String area)
    {
        setName(name);
        setStreet(street);
        setNumber(number);
        setCity(city);
        setMunicipality(municipality);
        setArea(area);
    }

    public void control(String type,String description)
    {
        setType(street);
        setDescription(number);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setMunicipality(String municipality)
    {
        this.municipality = municipality;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getStreet()
    {
        return street;
    }

    public String getNumber()
    {
        return number;
    }

    public String getCity()
    {
        return city;
    }

    public String getMunicipality()
    {
        return municipality;
    }

    public String getArea()
    {
        return area;
    }

    public String getType()
    {
        return type;
    }

    public String getDescription()
    {
        return description;
    }


    public boolean check()
    {
        if(checkName()&&checkStreet()&&checkNumber()&&checkCity()&&checkMunicipality()&&checkArea()&&checkType()&&checkDescription())
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

    private boolean checkType()
    {
        if ( (name!="") && (name != null))
        {
            return true;
        }
        else
        {
            alert+="\nThe type of the spot wasn't entered.";
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
            alert+="\nThe name of the spot wasn't entered.";
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
            alert+="\nThe name of the city wasn't entered.";
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
            alert+="\nThe municipality wasn't entered.";
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
            alert+="\nThe area wasn't entered.";
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
            alert+="\nThe description wasn't entered.";
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
            alert+="\nThe street wasn't entered.";
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
            alert+="\nThe number wasn't correct.";
            return false;
        }
    }
}
