package logic.gui;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;


public class HomeMain extends Application
{
	private static Stage home;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("homeLayout.fxml"));
		Scene scene = new Scene(root);
		home = primaryStage;
		home.setTitle("SkateSpot");
		home.setScene(scene);
		home.show();

	}

	public static Stage getStage()
	{
		return home; vb
	}


}
