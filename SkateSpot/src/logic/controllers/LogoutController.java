package logic.controllers;

public class LogoutController
{
    private static LogoutController instance;

    private LogoutController(){}

    public static LogoutController getInstance()
    {
        if(instance == null)
            instance = new LogoutController();
        return instance;
    }

    public void logout()
    {
        UserContainer.resetInstance();
    }
}
