package logic.beans;

public class PushBean
{
    private String sesso;
    private String username;
    private String tipo;

    public PushBean(String username,String sesso,String tipo)
    {
        setUsername(username);
        setSesso(sesso);
        setTipo(tipo);
    }

    public void setSesso(String sesso)
    {
        this.sesso = sesso;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getUsername()
    {
        return username;
    }

    public String getSesso()
    {
        return sesso;
    }

    public String getTipo()
    {
        return tipo;
    }
}
