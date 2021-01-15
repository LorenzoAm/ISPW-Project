package logic.gui;

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
import logic.beans.PushBean;

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

    public void changeUserInfo(PushBean bean)
    {
        File file;
        Image image;

        profilePic = new ImageView();
        usernameLab = new Label();
        premiumArea = new Button();

        usernameLab.setText(bean.getUsername());

        if(bean.getSesso() == "M")
        {
            file = new File("../resources/male_icon.png");
            image = new Image(file.toURI().toString());

        }
        else
        {
            file = new File("../resources/female_icon.png");
            image = new Image(file.toURI().toString());
        }

        profilePic.setImage(image);


        if(bean.getTipo() == "Owner")
        {
            premiumArea.setDisable(false);
        }

    }


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
