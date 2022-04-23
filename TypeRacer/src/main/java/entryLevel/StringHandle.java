package entryLevel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class StringHandle {
    private String lebelText = "Dhaka is the capital of Bangladesh. It is a mega city.";
    private String showText = "Dhaka is the \ncapital of Bangladesh.\nIt is a mega city.";
    private String word[] = lebelText.split(" ");
    private String newWord[] = new String[word.length];


    public StringHandle()
    {
        int wordSize = word.length,check=0;
        for(String str: word){
            if(check != (wordSize-1) ){
                newWord[check++] = str + " ";
            }
            else{
                newWord[check] = str;
            }
        }
    }

    public String[] getWord()
    {
        return newWord;
    }

    public String getShowText()
    {
        return showText;
    }

    public double getWordNumber()
    {
        int wordLengrh =  word.length;
        double perWord = 1.00/(double) wordLengrh;

        return perWord;
    }





}
