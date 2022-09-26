package session;



public class Session {
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getGame() {
        return game;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getnPost() {
        return nPost;
    }

    public int getPeriod() {
        return period;
    }

    String fName, lName, game, finishTime,startTime;
    int nPost,period;


    public Session() {
    }

    public Session(String fName, String lName, String game, int nPost, int period, String startTime, String finishTime) {
        this.fName = fName;
        this.lName = lName;
        this.game = game;
        this.nPost = nPost;
        this.period = period;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}
