package logic.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.beans.PullBean;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class HomeGuiController
{

    @FXML
    private ImageView profilePic;
    @FXML
    private Label usernameLab;
    @FXML
    private Button premiumArea;

    private static Stage signUp;
    private static Stage login;
    private static Stage addSpot;
    private static Stage premArea;

    private static boolean logged = false;


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
            case "PREMIUM AREA" -> {
                if(getPremiumAreaStage() == null)   //prima apertura di premium area
                {
                    root = FXMLLoader.load(getClass().getResource("../gui/premiumAreaLayout.fxml"));
                    scene = new Scene(root);
                    premArea = new Stage();
                    premArea.setTitle("PREMIUM AREA");
                    premArea.setScene(scene);
                    premArea.show();
                    HomeMain.getStage().close();
                }
             
                else
                {
                	premArea.show();
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
    
    public static Stage getPremiumAreaStage()
    {
        return premArea;
    }

    public static Stage getAddSpotStage(){ return addSpot; }

    public static boolean getLogged()
    {
        return logged;
    }

    public static void setLogged(boolean value)
    {
        logged = value;
    }


    public void openAdd(ActionEvent actionEvent) throws IOException {
        Scene scene;
        Parent root;

        if(getLogged())
        {
            root = FXMLLoader.load(getClass().getResource("../gui/addSpotLayout.fxml"));
            scene = new Scene(root);
            addSpot = new Stage();
            addSpot.setTitle("LOGIN");
            addSpot.setScene(scene);
            addSpot.show();
            HomeMain.getStage().close();
        }
        else
        {
            JOptionPane.showMessageDialog(null," You have to sign in before adding a spot ","WARNING",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}