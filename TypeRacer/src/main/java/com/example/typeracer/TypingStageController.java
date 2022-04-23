package com.example.typeracer;

import entryLevel.StringHandle;
import entryLevel.TimeAndSpeed;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class TypingStageController implements Initializable,Runnable {

    //from here new class
    private String lebelText,word[];
    //private Timeline timeline;
    private int minutes =0, seconds = 0;
    private double progress=0.00, perWord;

    TimeAndSpeed timeAndSpeed;




    private int index=0;
    private String textFieldString;

    @FXML
    public Label label,finishedLabel,speed,timeText;
    @FXML
    private TextField textField = new TextField();

    StringHandle stringHandle = new StringHandle();
    public TypingStageController()
    {
        //timeAndSpeed = new TimeAndSpeed();
        textField.setDisable(true);
        lebelText = stringHandle.getShowText();
        word = stringHandle.getWord();
        perWord = stringHandle.getWordNumber();
    }

     Timeline timeline;

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

            //speed.setText(timeAndSpeed.getSpeed(index));
            //System.out.println("here " + timeAndSpeed.getSpeed(index));

        });
    }

    public void setTextSpeed()
    {
        speed.setText(timeAndSpeed.getSpeed(index));
    }

    @FXML
    private void startButtonClick(ActionEvent event)
    {
        textField.setDisable(false);
        timeAndSpeed = new TimeAndSpeed();
        finishedLabel.setText(" ");
        textFieldCotroller(event);


        label.setText(lebelText);
        System.out.println("Done label work");

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
    }

    @FXML
    private ProgressBar myProgressBar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void increaseProgress()
    {
        progress += perWord;
        myProgressBar.setProgress(progress);
    }

    @Override
    public void run() {
        System.out.println("here run");
        setTextSpeed();
    }


//    private void setTimeline() {
//     System.out.println("in set time linw");
////        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateStopwatchText()));
////        timeline.setAutoReverse(false);
////       timeline.setCycleCount(Timeline.INDEFINITE);
//
//        long endTime = System.currentTimeMillis();
//        final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//        final Timeline = new Timeline(
//                new KeyFrame(
//                        Duration.millis(1000),
//                        event ->{
//                            final long diff = endTime - System.currentTimeMillis();
//                            if(diff<0){
//                                timeText.setText(timeFormat.format(0));
//                            }
//                            else{
//                                timeText.setText(timeFormat.format(diff));
//                            }
//                        }
//                )
//        );




 //   }
//
//
//
//    @FXML
//    private void updateStopwatchText() {
//        System.out.println("in set time line 2nd call");
//        if (seconds == 60){
//            minutes++;
//            seconds = 0;
//        }
//        timeText.setText((((minutes/10) == 0) ? "0" : "") + minutes + ":"
//                + (((seconds/10) == 0) ? "0" : "") + seconds++);
//        System.out.println(seconds+" " +minutes+" tty "+timeText);
//    }
//
//
//    @Override
//    public void run() {
//         TimeAndSpeed timeAndSpeed = new TimeAndSpeed();
//         TypingStageController typingStageController = new TypingStageController();
//        String timeLabel = timeAndSpeed.getLebelTime(start);
//       // typingStageController.timeText.setText("sds");
//        finishedLabel.setText(timeLabel);
//        //speed.setText(timeAndSpeed.getSpeed(index,start));
//    }
}
