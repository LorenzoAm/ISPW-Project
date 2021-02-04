package logic.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.beans.ShopBean;
import logic.controllers.AddShopController;

public class addShopGuiController 
{
	@FXML private TextField name;
	@FXML private TextField city;
	@FXML private TextField partitaIVA;
	@FXML private TextField municipality;
	@FXML private TextField area;
	@FXML private TextField description;
	@FXML private TextField street;
	@FXML private TextField number;
	
	public void handle(MouseEvent mouseEvent) throws IOException
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
		if(value.equals(""))//home button clicked --> re-open home window
		{
				PremiumAreaGuiController.getAddShopStage().close();
				HomeGuiController.getPremiumAreaStage().show();
		}
		else
		{
				ShopBean bean = new ShopBean(name.getText(), city.getText(), partitaIVA.getText(), municipality.getText(), area.getText(), description.getText());//costrutttore
				bean.control(street.getText(), number.getText());//finisce di passare i dati necesari (sonalCloud non accetta pi� di 7 parametri per costruttore)
				if (bean.check()) {
					AddShopController.getInstance().createShop(bean);
				}
		}
    }
}
