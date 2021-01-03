package logic.bean;
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
	private String email;
	private String password;
	private String gender;
	private Date data;
	private String alert="";
	public SignUpBean()
	{}
	public SignUpBean(String name,String surname,String email,String password,String confirmPassword,LocalDate data,String gender)
	{
		if(check(name,surname,email,password,confirmPassword,data,gender))
		{
			setName(name);
			setSurname(surname);
			setEmail(email);
			setPassword(password);
			setDate(data);
			setGender(gender);
		}
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
	public void setDate(LocalDate data)
	{
		Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		this.data=date;
	}
	public Date getDate()
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
	
	public boolean check(String name,String surname,String email,String password,String confirmPassword,LocalDate data,String gender)
	{
		if(checkName(name)&&checkSurname(surname)&&checkEmail(email)&&checkPassword(password,confirmPassword)&&checkDate(data)&&checkGender(gender))
		{
			JOptionPane.showMessageDialog(null, "Correctly recorded data.");
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, alert);
			return false;
		}
	}
	
	public boolean checkName(String name)
	{
		if ( (name!="") && (name != null) && (name.matches("^[a-zA-Z]*$")) ) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name entered is not valid, it should contain only alphabetic characters.";
			return false;
		}
	}
	public boolean checkSurname(String surname)
	{
		if ( (surname!="") && (surname != null) && (surname.matches("^[a-zA-Z]*$")) ) { 
		       return true;
		}
		else
		{
			alert+="\nThe surname entered is not valid, it should contain only alphabetic characters.";
			return false;
		}
	}
	public boolean checkPassword(String password, String confirmPassword)
	{
		if(password.length()>7)
		{
			if(password.equals(confirmPassword))
			{
				return true;
			}
			else
			{
				alert+="\nPasswords entered do not conicide.";
				return false;
			}
		}
		else
		{
			alert+="\nThe password must be at least 8 characters long.";
			return false;
		}
	}
	public boolean checkEmail(String email)
	{
		if(email.contains("@"))
		{
			String[] emailSplit = email.split("@");
			if(emailSplit.length==2)
			{
				if(!emailSplit[0].equals(""))
				{
					if(emailSplit[1].contains("."))
					{
						String[] emailSplit2 = emailSplit[1].split("\\.");
						if(( (!emailSplit2[0].equals("")) && (emailSplit2[0].matches("^[a-zA-Z]*$")) ) && ( (!emailSplit2[1].equals("")) && (emailSplit2[1].matches("^[a-zA-Z]*$")) ))
						{
							return true;
						}
						else
						{
							alert+="\nThe email entered is incorrect, the email domain does not exist.";
							return false;
						}
					}
					else
					{
						alert+="\nThe email entered is incorrect, the email domain does not exist.";
						return false;
					}
				}
				else
				{
					alert+="\nThe email entered is incorrect, the username of the email can contain only alphanumeric characters.";
					return false;					
				}
			}
			else
			{
				alert+="\nThe email entered is incorrect, too many @ entered.";
				return false;
			}
		}
		else
		{
			alert+="\nThe email entered is incorrect, @ absent.";
			return false;
		}
	}
	//ERRORE SE IL CAMPO E' VUOTO
	public boolean checkDate(LocalDate data)
	{
		 Instant instant = Instant.from(data.atStartOfDay(ZoneId.systemDefault()));
		 Date date = Date.from(instant);
		 Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		 calendar.add(Calendar.YEAR, -10);
		 Date today = calendar.getTime();
		 if(date.before(today))
		 {
			 return true;
		 }
		 else
		 {
			 alert+="\nYou must be at least 10 years old to use the software.";
			 return false;
		 }
	}
	public boolean checkGender(String gender)
	{
		if(gender.equals("Male")||gender.equals("Female"))
		{
			 return true;
		}
		else
		{
			alert+="\nGender not selected.";
			 return false;
		}
	}
	
}