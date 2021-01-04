package logic.controller;

public class LoginController
{
    private static LoginController instance;

    private LoginController(){}

    public static LoginController getInstance()
    {
       if(instance == null)
           instance = new LoginController();
       return instance;
    }

    public void login()
    {
        //TODO implementare connessione al DB tramite classe DAO
    }
}
