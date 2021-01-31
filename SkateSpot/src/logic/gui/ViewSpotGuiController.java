package logic.gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import logic.controllers.ViewSpotController;
import logic.entities.Spot;


public class ViewSpotGuiController 
{
	@FXML private Label nome;
	@FXML private Label numero;
	@FXML private Label indirizzo;
	@FXML private Label zona;
	@FXML private Label comune;
	@FXML private Label tipo;
	@FXML private Label username;
	@FXML private Label data;
	@FXML private Label descrizione;
	ArrayList<Spot> spots;
	private SimpleDateFormat sdf;
	private int i=0;	
	
	public void handle(MouseEvent mouseEvent) throws IOException
    {	
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
            	HomeGuiController.getViewSpotStage().close();
                HomeMain.getStage().show();
                break;
               
            case "NEXT":
            	nextSpot();
            	break;
            	
            case "PREVIOUS":
            	previousSpot();
            	break;
        } 
    }
	public void nextSpot()
	{
		spots=ViewSpotController.getList();
		if(spots==null)
		{
			JOptionPane.showMessageDialog(null,"ERROR! No spot was found!","WARNING",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if(i>=spots.size())
			{
				i=0;
			}
			if(i<0)
			{
				i=spots.size()-1;
			}
			nome.setText(spots.get(i).getNome());
			System.out.println(spots.get(i).getNome());
			System.out.println(spots.get(i).getNome());
			numero.setText(String.valueOf(spots.get(i).getNumeroDiSkater()).toString());
			indirizzo.setText(spots.get(i).getIndirizzo());
			zona.setText(spots.get(i).getZona());
			comune.setText(spots.get(i).getComune());
			tipo.setText(spots.get(i).getTipo());
			username.setText(spots.get(i).getUsername());
			sdf=new SimpleDateFormat();
			data.setText(sdf.format(spots.get(i).getData()));
			descrizione.setText(spots.get(i).getDescrizione());
			descrizione.setWrapText(true);
		}
		i++;
	}
	public void previousSpot()
	{
		spots=ViewSpotController.getList();
		if(spots==null)
		{
			JOptionPane.showMessageDialog(null,"ERROR! No spot was found!","WARNING",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			if(i>=spots.size())
			{
				i=spots.size()-2;
			}
			if(i<0)
			{
				i=spots.size()-1;
			}
			nome.setText(spots.get(i).getNome());
			System.out.println(spots.get(i).getNome());
			System.out.println(spots.get(i).getNome());
			numero.setText(String.valueOf(spots.get(i).getNumeroDiSkater()).toString());
			indirizzo.setText(spots.get(i).getIndirizzo());
			zona.setText(spots.get(i).getZona());
			comune.setText(spots.get(i).getComune());
			tipo.setText(spots.get(i).getTipo());
			username.setText(spots.get(i).getUsername());
			sdf=new SimpleDateFormat();
			data.setText(sdf.format(spots.get(i).getData()));
			descrizione.setText(spots.get(i).getDescrizione());
			descrizione.setWrapText(true);
		}
		i--;
	}
}
