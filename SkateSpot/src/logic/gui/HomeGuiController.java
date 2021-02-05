package logic.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.controllers.LeaveSpotController;
import logic.controllers.LogoutController;
import logic.controllers.UserContainer;
import javax.swing.*;
import java.io.IOException;


public class HomeGuiController
{

    private static Stage signUp;
    private static Stage login;
    private static Stage addSpot;
    private static Stage premArea;
    private static Stage joinSpot;
    private static Stage viewSpot;
    private static Stage viewShop;


    public void handle(MouseEvent mouseEvent) throws IOException
    {
        Scene scene;
        Parent root;
        Button clickedButton = (Button) mouseEvent.getSource();
        String value = clickedButton.getText();
            switch (value)
            {
                case "LOGIN-LOGOUT" -> {
                    if (UserContainer.getInstance() == null) {
                        if (getLoginStage() == null)   //prima apertura di login
                        {
                            root = FXMLLoader.load(getClass().getResource("loginLayout.fxml"));
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
                    	JOptionPane.showMessageDialog(null," Bye "+UserContainer.getInstance().getNome()+" "+UserContainer.getInstance().getCognome()+", see you soon!","LOGOUT",JOptionPane.INFORMATION_MESSAGE);
                        LogoutController.getInstance().logout();
                    }

                }
                case "SIGN UP" -> {
                    if (getSignUpStage() == null)   //prima apertura di signUp
                    {
                        root = FXMLLoader.load(getClass().getResource("signUpLayout.fxml"));
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
                                root = FXMLLoader.load(getClass().getResource("premiumAreaLayout.fxml"));
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

                case "VIEW SPOTS" -> {
                	if (getViewSpotStage() == null)   //prima apertura di viewSpot
                    {
                        root = FXMLLoader.load(getClass().getResource("viewSpot.fxml"));
                        scene = new Scene(root);
                        viewSpot = new Stage();
                        viewSpot.setTitle("VIEW SPOTS");
                        viewSpot.setScene(scene);
                        viewSpot.show();
                        HomeMain.getStage().close();
                    } else {
                    	viewSpot.show();
                        HomeMain.getStage().close();
                    }
                }

                case "VIEW SHOPS" -> {
                	if (getViewShopStage() == null)   //prima apertura di viewShop
                    {
                        root = FXMLLoader.load(getClass().getResource("viewShop.fxml"));
                        scene = new Scene(root);
                        viewShop = new Stage();
                        viewShop.setTitle("VIEW SHOPS");
                        viewShop.setScene(scene);
                        viewShop.show();
                        HomeMain.getStage().close();
                    } else {
                    	viewShop.show();
                        HomeMain.getStage().close();
                    }
                }
                default ->{
                	break;
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
                root = FXMLLoader.load(getClass().getResource("addSpotLayout.fxml"));
                scene = new Scene(root);
                addSpot = new Stage();
                addSpot.setTitle("ADD SPOT");
                addSpot.setScene(scene);
                addSpot.show();
                HomeMain.getStage().close();
            } else {
                addSpot.show();
                HomeMain.getStage().close();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null," You must be logged in the system in order to add a spot! ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void joinLeaveSpot(ActionEvent actionEvent) throws IOException
    {
        Scene scene;
        Parent root;
        if(UserContainer.getInstance() != null)
        {
            if(UserContainer.getInstance().getSpot() == null)  //se l'utente non ha un riferimento ad uno spot viene effettuato il join spot use case
            {
                if(getJoinSpotStage()==null)     //prima apertura di joinSpot stage
                {
                    root = FXMLLoader.load(getClass().getResource("joinSpotLayout.fxml"));
                    scene = new Scene(root);
                    joinSpot = new Stage();
                    joinSpot.setTitle("JOIN SPOT");
                    joinSpot.setScene(scene);
                    joinSpot.show();
                    HomeMain.getStage().close();
                }
                else
                {
                    joinSpot.show();
                    HomeMain.getStage().close();
                }
            }
            else   //leave spot use case
            {
            	JOptionPane.showMessageDialog(null," You're leaving "+UserContainer.getInstance().getSpot().getNome()+",hope you enjoyed your session!","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
                LeaveSpotController.getInstance().leaveSpot();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null," You must be logged in the system in order to join or leave a spot! ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
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

    public static Stage getJoinSpotStage()
    {
        return joinSpot;
    }

    public static Stage getViewSpotStage()
    {
    	return viewSpot;
    }
    
    public static Stage getViewShopStage()
    {
    	return viewShop;
    }

}
