package com.example.demo1;

import javafx.event.ActionEvent;
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

    public void practiceButton(ActionEvent event) throws IOException {
        System.out.println("complete");
        root = FXMLLoader.load((getClass().getResource("sin_up_view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //later add button
}
