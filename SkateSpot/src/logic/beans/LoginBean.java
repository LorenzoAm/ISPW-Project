package logic.beans;

import javax.swing.*;

public class LoginBean
{
    private String email;
    private String password;

    public LoginBean() {}
    
    public LoginBean(String email, String password)
    {
        setEmail(email);
        setPassword(password);

    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean check()    //return true if both email and password are correct, else it returns false
    {
        return (checkEmail() && checkPassword());
    }

    private boolean checkPassword()
    {
        if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null," you must insert a password ");
            return false;
        }
        else
        {
            if(password.length()<8)
            {
                JOptionPane.showMessageDialog(null," the password must be 8 characters long ");
                return false;
            }
            else
            {
                return true;
            }
        }
    }

    private boolean checkEmail()
    {
        if(email.equals(""))
        {
            JOptionPane.showMessageDialog(null," you must insert an email address ");
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
            JOptionPane.showMessageDialog(null," the email address must contain the character '@' ");
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
            JOptionPane.showMessageDialog(null," the email address must contain only one character '@' ");
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
            JOptionPane.showMessageDialog(null," wrong email username or/and email domain ");
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
            JOptionPane.showMessageDialog(null," the email domain must contain the character '.' ");
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
            JOptionPane.showMessageDialog(null," the email domain must contain only one character '.' ");
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
            JOptionPane.showMessageDialog(null," the email domain does not exist ");
            return false;
        }
    }

}
