package session;


import java.sql.Time;

public class Session {
    String fName, lName, game;
    int nPost,period;
    java.sql.Time startTime;

    public Session() {
    }

    public Session(String fName, String lName, String game, int nPost, int period, Time startTime) {
        this.fName = fName;
        this.lName = lName;
        this.game = game;
        this.nPost = nPost;
        this.period = period;
        this.startTime = startTime;
    }
}
