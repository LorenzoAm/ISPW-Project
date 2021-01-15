package logic.entities;

import java.util.Date;

public class User
{
    private String email;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private String sesso;
    private String tipo;

    public User(String email, String username, String password, String nome, String cognome, Date dataDiNascita, String sesso, String tipo)
    {
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setNome(nome);
        setCognome(cognome);
        setDataDiNascita(dataDiNascita);
        setSesso(sesso);
        setTipo(tipo);
    }

    public User() {

    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public void setNome(String nome)
    {
        this.nome=nome;
    }

    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }

    public void setDataDiNascita(Date dataDiNascita)
    {
        this.dataDiNascita=dataDiNascita;
    }

    public void setSesso(String sesso)
    {
        this.sesso=sesso;
    }

    public void setTipo(String tipo)
    {
        this.tipo=tipo;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getNome()
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public Date getDataDiNascita()
    {
        return dataDiNascita;
    }

    public String getSesso()
    {
        return sesso;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String toString()
    {
        return " nome : "+getNome()+" cognome : "+getCognome()+" data di nascita : "+getDataDiNascita()+" sesso : "+getSesso()+" tipo di account : "+getTipo()+" username : "+getUsername()+" email : "+getEmail()+" password : "+getPassword();
    }
}
