package entryLevel;

import java.util.Scanner;

public class TimeAndSpeed {
    private long last, diff,start;
    private int speed;
    private String text;

    public TimeAndSpeed()
    {
        start = System.currentTimeMillis();
    }

    public float getTotalMinute()
    {
        last = System.currentTimeMillis();
        diff =  (last - start);
        float minute = diff/60000F;

        return minute;
    }

    public String getSpeed(int wordType)
    {
            float time = getTotalMinute();
            float f_speed = (float)wordType/time;
            speed = (int) f_speed;
       // System.out.println(time+ " "+speed+ " "+f_speed);
            String str = " "+speed;
            return str;
    }

 public int getFinalSpeed(int wordType)
    {
            float time = getTotalMinute();
            float f_speed = (float)wordType/time;
            speed = (int) f_speed;
       return speed;
    }



}
