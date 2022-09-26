package interfaces;


import java.text.ParseException;
import java.time.LocalTime;
import java.util.HashMap;

public interface ITimerChecker {
    String getTheEndTime(String startTime, int period) throws ParseException;

    HashMap<String,String> getPlayingTime(LocalTime timeNow);
}
