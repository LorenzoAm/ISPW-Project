package logic.beans;

import javafx.scene.image.ImageView;
import logic.controllers.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginBean
{
    private String email;
    private String password;


    public LoginBean(String email,String password)
    {
        setEmail(email);
        setPassword(password);
        if(check())
        {
            JOptionPane.showMessageDialog(null," correctly recorded data ","INFO",JOptionPane.INFORMATION_MESSAGE);
            LoginController.getInstance().login(getEmail(),getPassword()); //richiamiamo login sull'istanza singleton passando i dati verificati dalla bean
        }

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

    private boolean check()    //return true if both email and password are correct, else it returns false
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
            if(email.contains("@"))
            {
                 String[] splittedEmail = email.split("@",-1);
                 if((splittedEmail.length)==2)
                 {
                     if((!splittedEmail[0].equals(""))&&(!splittedEmail[1].equals("")))
                     {
                         if(splittedEmail[1].contains("."))
                         {
                             String[] splittedEmail2 = splittedEmail[1].split("\\.",-1);
                             if ((splittedEmail2.length) == 2)
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
                             else
                             {
                                 JOptionPane.showMessageDialog(null," the email domain must contain only one character '.' ");
                                 return false;
                             }
                         }
                         else
                         {
                             JOptionPane.showMessageDialog(null," the email domain must contain the character '.' ");
                             return false;
                         }
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null," wrong email username or/and email domain ");
                         return false;
                     }

                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null," the email address must contain only one character '@' ");
                     return false;
                 }
            }
            else
            {
                JOptionPane.showMessageDialog(null," the email address must contain the character '@' ");
                return false;
            }

        }
    }

}
