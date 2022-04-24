package highScore;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int speed;


    public User(String name,int speed){
        this.name = name;
        this.speed = speed;

    }

    public String getName(){
        return name;
    }
    public int getTime(){
        return speed;
    }


}
