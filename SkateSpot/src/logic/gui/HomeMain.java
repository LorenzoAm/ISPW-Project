package logic.gui;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;
import logic.controller.HomeGuiController;


public class HomeMain extends Application
{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("homeLayout.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("SkateSpot");
		stage.setScene(scene);
		stage.show();
		HomeGuiController h = new HomeGuiController(stage);
	}


}
