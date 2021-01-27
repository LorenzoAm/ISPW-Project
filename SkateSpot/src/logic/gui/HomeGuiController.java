package logic.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.controllers.UserContainer;
import javax.swing.*;
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



    public void handle(MouseEvent mouseEvent) throws IOException
    {
        Scene scene;
        Parent root;
        Button clickedButton = (Button) mouseEvent.getSource();
        String value = clickedButton.getText();
            switch (value)
            {
                case "LOGIN" -> {
                    if (UserContainer.getInstance() == null) {
                        if (getLoginStage() == null)   //prima apertura di login
                        {
                            root = FXMLLoader.load(getClass().getResource("../gui/loginLayout.fxml"));
                            scene = new Scene(root);
                            login = new Stage();
                            login.setTitle("LOGIN");
                            login.setScene(scene);
                            login.show();
                            HomeMain.getStage().close();
                        } else {
                            login.show();
                            HomeMain.getStage().close();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " You're already logged in the system !", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                case "SIGN UP" -> {
                    if (getSignUpStage() == null)   //prima apertura di signUp
                    {
                        root = FXMLLoader.load(getClass().getResource("../gui/signUpLayout.fxml"));
                        scene = new Scene(root);
                        signUp = new Stage();
                        signUp.setTitle("SIGN UP");
                        signUp.setScene(scene);
                        signUp.show();
                        HomeMain.getStage().close();
                    } else {
                        signUp.show();
                        HomeMain.getStage().close();
                    }
                }
                case "PREMIUM AREA" -> {
                    if (UserContainer.getInstance() != null) {
                        if (UserContainer.getInstance().getTipo().equals("Owner")) {
                            if (getPremiumAreaStage() == null)   //prima apertura di premium area
                            {
                                root = FXMLLoader.load(getClass().getResource("../gui/premiumAreaLayout.fxml"));
                                scene = new Scene(root);
                                premArea = new Stage();
                                premArea.setTitle("PREMIUM AREA");
                                premArea.setScene(scene);
                                premArea.show();
                                HomeMain.getStage().close();
                            } else {
                                premArea.show();
                                HomeMain.getStage().close();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, " You must have a shop owner account in order to access the premium area! ", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " You must be logged in the system in order to access the premium area!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
    }


    public void openAddSpot(ActionEvent actionEvent) throws IOException
    {
        Scene scene;
        Parent root;
        if(UserContainer.getInstance() != null)
        {
            if (getAddSpotStage() == null)   //prima apertura di addSpot
            {
                root = FXMLLoader.load(getClass().getResource("../gui/addSpotLayout.fxml"));
                scene = new Scene(root);
                addSpot = new Stage();
                addSpot.setTitle("ADD SPOT");
                addSpot.setScene(scene);
                addSpot.show();
                HomeMain.getStage().close();
            } else {
                login.show();
                HomeMain.getStage().close();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null," You must be logged in the system in order to add a spot! ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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

    public static Stage getAddSpotStage()
    {
        return addSpot;
    }

}
