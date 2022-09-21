package checkers;

import interfaces.ITimerChecker;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class TimerChecker implements ITimerChecker {
    Timer timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("hello");
        }
    };

    @Override
    public String checkTime(Time time, Timer timer, TimerTask timerTask) {
        return null;
    }
}
