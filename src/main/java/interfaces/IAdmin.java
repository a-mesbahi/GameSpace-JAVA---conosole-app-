package interfaces;

import post.Post;

import java.sql.Time;
import java.util.HashMap;

public interface IAdmin {
    public void addSession(String fName, String lName, String game,int nPost, int period, java.sql.Time startTimeT);
    public void addClient();
    public String getTotalIncome();

    public HashMap<Post, Integer> getPostsInfo();
}
