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

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setnPost(int nPost) {
        this.nPost = nPost;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

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
