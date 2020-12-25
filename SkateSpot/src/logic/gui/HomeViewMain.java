package logic.gui;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.fxml.*;


public class HomeViewMain extends Application
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
	}


	public void handle(MouseEvent mouseEvent) throws Exception					//Controller grafico
	{
		Stage stage;
		Scene scene;
		Parent root;
		Button clickedButton = (Button)mouseEvent.getSource();
		String value = clickedButton.getText();
		switch (value)
		{
			case "LOGIN" -> {
				root = FXMLLoader.load(getClass().getResource("loginLayout.fxml"));
				scene = new Scene(root);
				stage = new Stage();
				stage.setTitle("LOGIN");
				stage.setScene(scene);
				stage.show();
			}
			case "SIGN UP" -> {
				root = FXMLLoader.load(getClass().getResource("registerLayout.fxml"));
				scene = new Scene(root);
				stage = new Stage();
				stage.setTitle("SIGN UP");
				stage.setScene(scene);
				stage.show();
			}
		}
	}
}
