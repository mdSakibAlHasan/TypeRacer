package com.example.typeracer;

import com.example.typeracer.MainApplication;
import entryLevel.ReadStore;
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
import java.util.Vector;


public class SinUpController {
    private Stage stage;
    private Scene scene;
    private Vector<String> userNameAray = new Vector<>();

    public SinUpController()
    {
        ReadStore readStore = new ReadStore();
        userNameAray = readStore.getUserNameVector();
    }

    @FXML
    Label userNameAlert = new Label(), passwordMatchAlert = new Label();
    @FXML
    public TextField fullNameText, userNameText, passwordText, confirmPasswordText;
    private String fullName, userName, emailName, password, confirmPassword;

    //Later full name will save

    private boolean checkUniqueUserName()
    {
        userName = userNameText.getText();
        if(userName == null)
            return false;

        for (String s : userNameAray) {
            if(userName.equals(s)){
                return false;
            }
        }

        return true;
    }


    private boolean passwordMatch()
    {
        password = passwordText.getText();
        confirmPassword = confirmPasswordText.getText();

        if(password.equals(confirmPassword)){
            return true;
        }
        else{
            return false;
        }
    }


    private void saveDataInFile()
    {
        ReadStore readStore = new ReadStore();
        readStore.writeInFile(userName, password);
    }

    @FXML
    public void createAccount(ActionEvent event) throws IOException {

        if(checkAllData()){

            saveDataInFile();
            //scene change
            Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    private boolean checkAllData()
    {
        if(!checkUniqueUserName()){
            userNameAlert.setText("Select an unique user name");
            passwordMatchAlert.setText("");
            return false;
        }

        if(!passwordMatch()){
            passwordMatchAlert.setText("Password doesn't match");
            userNameAlert.setText("");
            return false;
        }

        return true;
    }
}
