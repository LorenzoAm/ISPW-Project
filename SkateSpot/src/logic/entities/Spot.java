package logic.entities;

import java.util.Date;

public class Spot
{
    private String indirizzo;
    private String zona;
    private String nome;
    private String tipo;
    private String comune;
    private Integer numeroDiSkater;
    private String descrizione;
    private String username;       //username di chi ha aggiunto lo spot
    private Date data;          //data in cui è stato aggiunto lo spot


    public Spot(String indirizzo, String zona, String nome, String tipo, String comune, Integer numeroDiSkater, String descrizione, String username, Date data)
    {
        setIndirizzo(indirizzo);
        setZona(zona);
        setNome(nome);
        setTipo(tipo);
        setComune(comune);
        setNumeroDiSkater(numeroDiSkater);
        setDescrizione(descrizione);
        setUsername(username);
        setData(data);
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public void setNumeroDiSkater(Integer numeroDiSkater)
    {
        this.numeroDiSkater = numeroDiSkater;
    }

    public void setComune(String comune)
    {
        this.comune = comune;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setZona(String zona)
    {
        this.zona = zona;
    }

    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }

    public String getIndirizzo()
    {
        return indirizzo;
    }

    public String getNome()
    {
        return nome;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String getZona()
    {
        return zona;
    }

    public String getComune()
    {
        return comune;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public Integer getNumeroDiSkater()
    {
        return numeroDiSkater;
    }

    public String getUsername()
    {
        return username;
    }

    public Date getData()
    {
        return data;
    }

    public String toString()
    {
        return " Nome spot : "+getNome()+"\n indirizzo : "+getIndirizzo()+"\n comune : "+getComune()+"\n zona : "+getZona()+"\n tipo : "+getTipo()+"\n descrizione : "+getDescrizione()+"\n skater attualmente presenti "+getNumeroDiSkater()+"\n aggiunto da : "+getUsername()+" in data : "+getData();
    }


}
