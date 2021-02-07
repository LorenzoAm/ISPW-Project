package logic.beans;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JOptionPane;

public class SignUpBean
{
	private String name;
	private String surname;
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	private String gender;
	private String typeOfAccount;
	private LocalDate data;
	private String match="^[a-zA-Z]*$";
	//private String alert
	
	public SignUpBean() {}

	public SignUpBean(String name,String surname,String username,String email,String password,String confirmPassword)
	{
			setName(name);
			setSurname(surname);
			setUsername(username);
			setEmail(email);
			setPassword(password);
			setConfirmPassword(confirmPassword);
	}
	public void control(LocalDate data,String gender,String typeOfAccount)
	{
		setDate(data);
		setGender(gender);
		setTypeOfAccount(typeOfAccount);
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public String getSurname()
	{
		return surname;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return username;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}

	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword=confirmPassword;
	}
	public String getconfirmPassword()
	{
		return confirmPassword;
	}
	
	public void setDate(LocalDate data)
	{
		this.data=data;
	}
	public LocalDate getDate()
	{
		return data;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return gender;
	}
	
	
	public void setTypeOfAccount(String typeOfAccount)
	{
		this.typeOfAccount=typeOfAccount;
	}
	public String getTypeOfAccount()
	{
		return typeOfAccount;
	}
	
	public boolean check()
	{
		return (checkName()&&checkSurname()&&checkUsername()&&checkEmail()&&checkPassword()&&checkDate()&&checkGender()&&checkTypeOfAccount());
	}
	
	private boolean checkName()
	{
		return( !(name.equals("")) && (name.matches(match)) );
	}
	private boolean checkSurname()
	{
		return( !(surname.equals("")) && (surname.matches(match)) );
	}
	private boolean checkUsername()
	{
		return( !(username.equals("")) && (username.matches("^[a-zA-Z0-9]*$")) );
	}
	private boolean checkPassword()
	{
		if(password.length()>7)
		{
			return(password.equals(confirmPassword));
		}
		else
		{
			return false;
		}
	}
	private boolean checkEmail()
    {
        if(email.equals(""))
        {
            return false;
        }
        else
        {
            return this.checkAtEmail();

        }
    }
    
    private boolean checkAtEmail()
    {
    	if(email.contains("@"))
        {
             String[] splittedEmail = email.split("@",-1);
             return this.checkSplittedEmail(splittedEmail);
        }
        else
        {
            return false;
        }
    }
    
    private boolean checkSplittedEmail(String[] splittedEmail)
    {
    	if((splittedEmail.length)==2)
        {
            return this.checkEmailIntegrity(splittedEmail);
        }
        else
        {
            return false;
        }
    }
    
    private boolean checkEmailIntegrity(String[] splittedEmail)
    {
    	if((!splittedEmail[0].equals(""))&&(!splittedEmail[1].equals("")))
        {
            return this.checkDotDomain(splittedEmail[1]);
        }
        else
        {
            return false;
        }
    }
    
    private boolean checkDotDomain(String splittedEmail)
    {
    	if(splittedEmail.contains("."))
        {
            String[] splittedEmail2 = splittedEmail.split("\\.",-1);
            return this.checkDomain(splittedEmail2);
        }
        else
        {
            return false;
        }
    }
    
    private boolean checkDomain(String[] splittedEmail2)
    {
    	if ((splittedEmail2.length) == 2)
        {
            return this.checkDomain2(splittedEmail2);
        }
        else
        {
            return false;
        }
    }
    
    private boolean checkDomain2(String[] splittedEmail2)
    {
    	if((!splittedEmail2[0].equals(""))&&(splittedEmail2[0].matches("^[a-zA-Z]*$"))&&(!splittedEmail2[1].equals(""))&&(splittedEmail2[1].matches("^[a-zA-Z]*$")))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
	
	private boolean checkDate()
	{
		if(data==null)
		{
			//alert+="\nYou must insert your birth date.";
			return false;
		}
		 Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
		 Date date = Date.from(instant);
		 Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		 calendar.add(Calendar.YEAR, -10);
		 Date today = calendar.getTime();
		 return(date.before(today));
	}
	private boolean checkGender()
	{
		return(gender.equals("M")||gender.equals("F"));
	}
	private boolean checkTypeOfAccount()
	{
		return(typeOfAccount.equals("Skater")||typeOfAccount.equals("Owner"));
	}
	
}