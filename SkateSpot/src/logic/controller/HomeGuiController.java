package logic.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeGuiController
{
    private Stage home;

    public HomeGuiController(Stage home)
    {
       this.home = home;
    }
    public void handle(MouseEvent mouseEvent) throws Exception
    {
        Stage stage;
        Scene scene;
        Parent root;
        Button clickedButton = (Button)mouseEvent.getSource();
        String value = clickedButton.getText();
        switch (value)
        {
            case "LOGIN" -> {
                root = FXMLLoader.load(getClass().getResource("../gui/loginLayout.fxml"));
                scene = new Scene(root);
                stage = new Stage();
                stage.setTitle("LOGIN");
                stage.setScene(scene);
                stage.show();
                LoginGuiController l = new LoginGuiController(home);  //home stage is passed to LoginGuiController
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            }
            case "SIGN UP" -> {
                root = FXMLLoader.load(getClass().getResource("../gui/signUpLayout.fxml"));
                scene = new Scene(root);
                stage = new Stage();
                stage.setTitle("SIGN UP");
                stage.setScene(scene);
                stage.show();
                SignUpGuiController s = new SignUpGuiController(home);  //home stage is passed to the SignUpGuiController
                ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
            }
        }
    }
}
