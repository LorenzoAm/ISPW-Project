package logic.beans;


public class JoinSpotBean
{
    private String street;
    private String number;
    private String city;
    
    public JoinSpotBean() {}

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
        return(checkStreet()&&checkNumber()&&checkCity());
        
    }

    private boolean checkCity()
    {
        return(!city.equals(""));
        
    }

    private boolean checkStreet()
    {
        return(!street.equals(""));
        
    }

    private boolean checkNumber()
    {
        return( (!number.equals("")) && (number.matches("^[0-9]*$")));
        
    }


}
