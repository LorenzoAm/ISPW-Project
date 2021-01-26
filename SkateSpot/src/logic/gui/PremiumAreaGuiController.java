package logic.gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class PremiumAreaGuiController 
{
	private static Stage addShop;
	@FXML
    private Button addNewShop;
	@FXML
    private Button viewShop;

    public void handle(MouseEvent mouseEvent) throws IOException
    {
    	Scene scene;
        Parent root;
        Button button = (Button) mouseEvent.getSource();
        String value = button.getText();
        switch(value)
        {
            case "":            //home button clicked --> re-open home window
                HomeGuiController.getPremiumAreaStage().close();
                HomeMain.getStage().show();
                break;
                
            case "Add new shop":     //
            	if(getAddShopStage() == null)   //prima apertura di add shop
                {
                    root = FXMLLoader.load(getClass().getResource("../gui/addShopLayout.fxml"));
                    scene = new Scene(root);
                    addShop = new Stage();
                    addShop.setTitle("ADD SHOP");
                    addShop.setScene(scene);
                    addShop.show();
                    HomeGuiController.getPremiumAreaStage().close();
                }
                else
                {
                    addShop.show();
                    HomeMain.getStage().close();
                }

            
                break;
            case "View your shops":     //
                
                break;
        }
    }
    public static Stage getAddShopStage()
    {
        return addShop;
    }
}
