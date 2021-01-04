package logic.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeGuiController
{
    @FXML public static ImageView profilePic;
    @FXML public static Label usernameLabel;
    private static Stage signUp;
    private static Stage login;

    public void handle(MouseEvent mouseEvent) throws IOException
    {
        Scene scene;
        Parent root;
        Button clickedButton = (Button)mouseEvent.getSource();
        String value = clickedButton.getText();
        switch (value)
        {
            case "LOGIN" -> {
                if(getLoginStage() == null)   //prima apertura di login
                {
                    root = FXMLLoader.load(getClass().getResource("../gui/loginLayout.fxml"));
                    scene = new Scene(root);
                    login = new Stage();
                    login.setTitle("LOGIN");
                    login.setScene(scene);
                    login.show();
                    HomeMain.getStage().close();
                }
                else
                {
                    login.show();
                    HomeMain.getStage().close();
                }

            }
            case "SIGN UP" -> {
                if(getSignUpStage() == null)   //prima apertura di signUp
                {
                    root = FXMLLoader.load(getClass().getResource("../gui/signUpLayout.fxml"));
                    scene = new Scene(root);
                    signUp = new Stage();
                    signUp.setTitle("SIGN UP");
                    signUp.setScene(scene);
                    signUp.show();
                    HomeMain.getStage().close();
                }
                else
                {
                    signUp.show();
                    HomeMain.getStage().close();
                }
            }
        }
    }

    public static Stage getSignUpStage()
    {
        return signUp;
    }

    public static Stage getLoginStage()
    {
        return login;
    }
}
