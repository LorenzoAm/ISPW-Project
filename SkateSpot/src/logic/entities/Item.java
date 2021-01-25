package logic.entities;

public class Item
{
    private String nome;
    private String descrizione;
    private String marca;
    private Double prezzo;
    private String immagine;

    public Item(String nome,String descrizione,String marca,Double prezzo,String immagine)
    {
        setNome(nome);
        setDescrizione(descrizione);
        setMarca(marca);
        setPrezzo(prezzo);
        setImmagine(immagine);
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public void setPrezzo(Double prezzo)
    {
        this.prezzo = prezzo;
    }

    public void setImmagine(String immagine)
    {
        this.immagine = immagine;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescrizione()
    {
        return descrizione;
    }

    public String getMarca()
    {
        return marca;
    }

    public Double getPrezzo()
    {
        return prezzo;
    }

    public String getImmagine()
    {
        return immagine;
    }

    public String toString()
    {
        return " Nome prodotto : "+getNome()+"\n marca : "+getMarca()+"\n descrizione : "+getDescrizione()+"\n prezzo : "+getPrezzo()+"€";
    }
}
