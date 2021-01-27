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
	@FXML public TextField name;
	@FXML public TextField city;
	@FXML public TextField partitaIVA;
	@FXML public TextField municipality;
	@FXML public TextField area;
	@FXML public TextField description;
	@FXML public TextField street;
	@FXML public TextField number;
	
	public void handle(MouseEvent mouseEvent) throws IOException
    {
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
                PremiumAreaGuiController.getAddShopStage().close();
                HomeMain.getStage().show();
                break;
            case "Register shop":
            	ShopBean bean = new ShopBean(name.getText(),city.getText(),partitaIVA.getText(),municipality.getText(),area.getText(),description.getText());//costrutttore
            	bean.control(street.getText(),number.getText());//finisce di passare i dati necesari (sonalCloud non accetta pi� di 7 parametri per costruttore)
            	if(bean.check())
            	{
            		 AddShopController.getInstance().createShop(bean);
            	}
                break;
        }
    }
}
