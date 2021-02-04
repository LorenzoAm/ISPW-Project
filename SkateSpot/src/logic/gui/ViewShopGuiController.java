package logic.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import logic.controllers.ViewShopController;
import logic.entities.Shop;


public class ViewShopGuiController 
{
	@FXML private Label nome;
	@FXML private Label indirizzo;
	@FXML private Label zona;
	@FXML private Label comune;
	@FXML private Label username;
	@FXML private Label data;
	@FXML private Label descrizione;
	ArrayList<Shop> shops;
	private SimpleDateFormat sdf;
	private int i=0;	
	
	public void handle(MouseEvent mouseEvent) throws IOException
    {	
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
            	HomeGuiController.getViewShopStage().close();
                HomeMain.getStage().show();
                break;
               
            case "NEXT":
            	nextShop();
            	break;
            	
            case "PREVIOUS":
            	previousShop();
            	break;
            default: 
            	break;
        } 
    }
	public void nextShop()
	{
		shops = ViewShopController.getInstance().getList();
		if(shops==null)
		{
			JOptionPane.showMessageDialog(null,"ERROR! No shop was found!","WARNING",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if(i>=shops.size())
			{
				i=0;
			}
			if(i<0)
			{
				i=shops.size()-1;
			}
			nome.setText(shops.get(i).getNome());
			indirizzo.setText(shops.get(i).getIndirizzo());
			zona.setText(shops.get(i).getZona());
			comune.setText(shops.get(i).getComune());
			username.setText(shops.get(i).getUsername());
			sdf=new SimpleDateFormat();
			data.setText(sdf.format(shops.get(i).getData()));
			descrizione.setText(shops.get(i).getDescrizione());
			descrizione.setWrapText(true);
		}
		i++;
	}
	public void previousShop()
	{
		shops = ViewShopController.getInstance().getList();
		if(shops==null)
		{
			JOptionPane.showMessageDialog(null,"ERROR! No shop was found!","WARNING",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if(i>=shops.size())
			{
				i=shops.size()-2;
			}
			if(i<0)
			{
				i=shops.size()-1;
			}
			nome.setText(shops.get(i).getNome());
			indirizzo.setText(shops.get(i).getIndirizzo());
			zona.setText(shops.get(i).getZona());
			comune.setText(shops.get(i).getComune());
			username.setText(shops.get(i).getUsername());
			sdf=new SimpleDateFormat();
			data.setText(sdf.format(shops.get(i).getData()));
			descrizione.setText(shops.get(i).getDescrizione());
			descrizione.setWrapText(true);
		}
		i--;
	}
}
