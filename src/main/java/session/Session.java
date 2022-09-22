package session;


import java.time.LocalTime;

public class Session {
    String fName, lName, game, screen, console;
    int nPost,period,time;
    LocalTime startTime;

    public Session() {
    }

    public Session(String fName, String lName, String game, String screen, String console, int nPost, int period, int time, LocalTime startTime) {
        this.fName = fName;
        this.lName = lName;
        this.game = game;
        this.screen = screen;
        this.console = console;
        this.nPost = nPost;
        this.period = period;
        this.time = time;
        this.startTime = startTime;
    }
}
