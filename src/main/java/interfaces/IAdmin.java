package interfaces;

import post.Post;

import java.sql.Time;
import java.text.ParseException;
import java.util.HashMap;

public interface IAdmin {
    public void addSession(String fName, String lName, String game,int nPost, int period, String startTimeT) throws ParseException;
    public void addClient();
    public void addToWaitingLine(String fName, String lName, String game, int period);
    public String getTotalIncome();

    public HashMap<Post, Integer> getPostsInfo();
}
