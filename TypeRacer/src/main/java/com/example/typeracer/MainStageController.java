package com.example.typeracer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStageController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void practiceButton(ActionEvent event) throws IOException {
        System.out.println("complete");
        root = FXMLLoader.load((getClass().getResource("typing-stage-controller.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //System.out.println("hew donwe");
       // new TypingStageController();
    }

    @FXML
    public void hostButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("make-group-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //new GroupController();
    }

    @FXML
    public void clientButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("client-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       // new GroupController();
    }

    @FXML
    public void highScoreButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("high-score-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        new HighScoreController();
    }

    //later add button
}
