package logic.entities;

import java.util.Date;

public class Shop
{
    private String partitaIVA;
    private String nome;
    private String descrizione;
    private String indirizzo;
    private String zona;
    private String comune;
    private String username;        //username proprietario
    private Date data;              //data in cui è stato aggiunto lo shop




    public Shop(String partitaIVA,String nome,String descrizione,String indirizzo,String zona,String comune,String username,Date data )
    {
        setPartitaIVA(partitaIVA);
        setNome(nome);
        setDescrizione(descrizione);
        setIndirizzo(indirizzo);
        setZona(zona);
        setComune(comune);
        setUsername(username);
        setData(data);
    }

    public void setPartitaIVA(String partitaIVA)
    {
        this.partitaIVA = partitaIVA;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public void setIndirizzo(String indirizzo)
    {
        this.indirizzo = indirizzo;
    }

    public void setZona(String zona)
    {
        this.zona = zona;
    }

    public void setComune(String comune)
    {
        this.comune = comune;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public String getPartitaIVA()
    {
        return partitaIVA;
    }

    public String getNome()
    {
        return nome;
    }

    public String getIndirizzo()
    {
        return indirizzo;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public String getUsername()
    {
        return username;
    }

    public String getZona()
    {
        return zona;
    }

    public String getComune()
    {
        return comune;
    }

    public Date getData()
    {
        return data;
    }

    public String toString()
    {
        return " Nome shop : "+getNome()+"\n partitaIVA : "+getPartitaIVA()+"\n username proprietario : "+getUsername()+"\n indirizzo : "+getIndirizzo()+"\n comune : "+getComune()+"\n zona : "+getZona()+"\n descrizione : "+getDescrizione()+"\n aggiunto in data : "+getData();
    }
}
