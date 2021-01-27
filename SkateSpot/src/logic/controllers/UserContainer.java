package logic.controllers;

import logic.entities.User;

public class UserContainer
{
    private static User instance = null;

    public static void setInstance(User user)
    {
        instance = user;
    }

    public static User getInstance()
    {
        return instance;
    }


}
