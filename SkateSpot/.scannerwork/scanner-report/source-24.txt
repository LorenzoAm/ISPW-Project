package logic.controllers;

import logic.entities.User;

public class UserContainer
{
    private static User instance = null;
    
    private UserContainer()
    {
    }

    public static void setInstance(User user)
    {
        instance = user;
    }

    public static void resetInstance()
    {
        instance = null;
    }

    public static User getInstance()
    {
        return instance;
    }


}
