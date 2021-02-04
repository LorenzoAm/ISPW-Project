package logic.beans;

import javax.swing.*;

public class JoinSpotBean
{
    private String street;
    private String number;
    private String city;
    private String alert;

    public JoinSpotBean(String street,String number,String city)
    {
        setStreet(street);
        setNumber(number);
        setCity(city);
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

    public boolean check()
    {
        if(checkStreet()&&checkNumber()&&checkCity())
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

    private boolean checkCity()
    {
        if (city.equals("")) 
        {
        	alert+="\nThe name of the city wasn't entered.";
            return false;
        }
        else
        {
            return true;
        }
    }

    private boolean checkStreet()
    {
        if (!street.equals("")) 
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
        if ( (!number.equals("")) && (number.matches("^[0-9]*$")))
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
