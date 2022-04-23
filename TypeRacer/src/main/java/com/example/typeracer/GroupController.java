package com.example.typeracer;

import entryLevel.StringHandle;
import entryLevel.TimeAndSpeed;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class GroupController extends TypingStageController {

    @FXML
    private ProgressBar myProgressBar, oponentProgressBar;
    @FXML
    //private Label oponentLebel;
    private int oponentWord, myWord;


    private String lebelText,word[];
    //private Timeline timeline;
    private int minutes =0, seconds = 0;
    private double ownProgress=0.00, otherProgress = 0.00, perWord;

    TimeAndSpeed timeAndSpeed;
    Timeline timeline;


    public GroupController()
    {
        textField.setDisable(true);
        lebelText = stringHandle.getShowText();
        word = stringHandle.getWord();
        perWord = stringHandle.getWordNumber();
    }

    private int index=0;
    private String textFieldString;

    @FXML
    public Label label,finishedLabel,speed,timeText,waitingMessage;
    @FXML
    private TextField textField = new TextField();

    StringHandle stringHandle = new StringHandle();



    @FXML
    private void textFieldCotroller(ActionEvent event)
    {

        textField.setOnKeyReleased(keyEvent -> {

            textFieldString = textField.getText();
            System.out.println(textFieldString);
            if(textFieldString.equals(word[index])){
                textField.clear();
                index++;
                increaseProgress();
            }

            if(textFieldString.equals(" ")){
                textField.clear();
            }

            if(index == word.length){
                textField.setDisable(true);
                finishedLabel.setText("Finished");
                 timeline.stop();
            }


        });
    }


    @FXML
    private void startButtonClick(ActionEvent event) throws InterruptedException {
        waitingMessage.setText("Wait for 5 second");

        Thread.sleep(5000);
        waitingMessage.setText(" ");
        textField.setDisable(false);
        timeAndSpeed = new TimeAndSpeed();
        finishedLabel.setText(" ");
        textFieldCotroller(event);


        label.setText(lebelText);

        final DateFormat format = DateFormat.getInstance();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                // @Override
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent event)
                    {
                        final Calendar cal = Calendar.getInstance();
                        // speed.setText(format.format(cal.getTime()));
                        speed.setText(timeAndSpeed.getSpeed(index));
                    }
                }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        System.out.println("Done label work");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void increaseMyProgress()
    {
        ownProgress += perWord;
        myProgressBar.setProgress(ownProgress);
    }

    @FXML
    public void increaseOponentProgress()
    {
        otherProgress += perWord;
        oponentProgressBar.setProgress(otherProgress);
    }





}
