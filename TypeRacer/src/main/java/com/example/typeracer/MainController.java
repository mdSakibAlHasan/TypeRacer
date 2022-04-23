package com.example.typeracer;

import entryLevel.SinInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;


    @FXML
    public TextField name,password;
    //    @FXML
//    public PasswordField password;
    @FXML
    Label label = new Label();

    String strName, strPass;
    @FXML
    public void sinInButton(ActionEvent event) throws IOException {
        strName = name.getText();
        strPass = password.getText();

        SinInController sinInController = new SinInController(strName, strPass);
        if(sinInController.isUser()){
            root = FXMLLoader.load((getClass().getResource("main-stage-view.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            System.out.println("Wrong");
            label.setText("Wrong password or user name");
        }


    }

    @FXML
    private void sinUpButton(ActionEvent event) throws Exception {
        //switch to sinup

        root = FXMLLoader.load((getClass().getResource("sin_up_view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}