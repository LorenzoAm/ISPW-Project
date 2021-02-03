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
	private String alert="";
	private String match="^[a-zA-Z]*$";

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
		if(checkName()&&checkSurname()&&checkUsername()&&checkEmail()&&checkPassword()&&checkDate()&&checkGender()&&checkTypeOfAccount())
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
		
		if ( !(name.equals("")) && (name.matches(match)) ) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe name entered is not valid, it should contain only alphabetic characters.";
			return false;
		}
	}
	private boolean checkSurname()
	{
		if ( !(surname.equals("")) && (surname.matches(match)) ) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe surname entered is not valid, it should contain only alphabetic characters and numbers.";
			return false;
		}
	}
	private boolean checkUsername()
	{
		if ( !(username.equals("")) && (username.matches("^[a-zA-Z0-9]*$")) ) 
		{ 
		       return true;
		}
		else
		{
			alert+="\nThe username entered is not valid, it should contain only alphabetic characters.";
			return false;
		}
	}
	private boolean checkPassword()
	{
		if(password.length()>7)
		{
			if(password.equals(confirmPassword))
			{
				return true;
			}
			else
			{
				alert+="\nPasswords entered do not coincide.";
				return false;
			}
		}
		else
		{
			alert+="\nThe password must be at least 8 characters long.";
			return false;
		}
	}
	private boolean checkEmail()
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
						if(( (!emailSplit2[0].equals("")) && (emailSplit2[0].matches(match)) ) && ( (!emailSplit2[1].equals("")) && (emailSplit2[1].matches(match)) ))
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
	private boolean checkDate()
	{
		if(data==null)
		{
			alert+="\nYou must insert your birth date.";
			return false;
		}
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
	private boolean checkGender()
	{
		if(gender.equals("M")||gender.equals("F"))
		{
			 return true;
		}
		else
		{
			alert+="\nGender not selected.";
			 return false;
		}
	}
	private boolean checkTypeOfAccount()
	{
		if(typeOfAccount.equals("Skater")||typeOfAccount.equals("Owner"))
		{
			 return true;
		}
		else
		{
			alert+="\nType of account not selected.";
			 return false;
		}
	}
	
}