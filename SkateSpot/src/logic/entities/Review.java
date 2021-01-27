package logic.entities;

import java.util.Date;

public class Review
{
    private String descrizione;
    private Integer rating;
    private String username;
    private Date data;

    public Review(String descrizione, Integer rating, String username, Date data)
    {
        setDescrizione(descrizione);
        setRating(rating);
        setUsername(username);
        setData(data);
    }

    private void setUsername(String username)
    {
        this.username = username;
    }

    private void setRating(Integer rating)
    {
        this.rating = rating;
    }

    private void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    private void setData(Date data)
    {
        this.data = data;
    }

    public String getUsername()
    {
        return username;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public Date getData()
    {
        return data;
    }

    public Integer getRating()
    {
        return rating;
    }

    public String toString()
    {
        return " Descrizione : "+getDescrizione()+"\n rating : "+getRating()+"\n scritta da : "+getUsername()+" in data : "+getData();
    }
}
