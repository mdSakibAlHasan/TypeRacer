package com.example.typeracer;

import highScore.Read_score;
import highScore.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HighScoreController {

    public Label label0, label1, label2, label3, label4;

    public void writeAll()
    {
        Read_score read_score = new Read_score();
        try {
            User user[] =  read_score.userDetails();
            for(int i=0;i< read_score.getSize();i++){
                if(i==0)
                    label0.setText(String.valueOf(user[i].getTime()));
                else if (i == 1)
                    label1.setText(String.valueOf(user[i].getTime()));
                else if (i == 2)
                    label2.setText(String.valueOf(user[i].getTime()));
                else if (i == 3)
                    label3.setText(String.valueOf(user[i].getTime()));
                else
                    label4.setText(String.valueOf(user[i].getTime()));



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    public void button(ActionEvent event){
        writeAll();
    }
}
