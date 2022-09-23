package admin;

import gamesRoom.GamesRoom;
import interfaces.IAdmin;
import post.Post;
import session.Session;

import java.sql.Time;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Admin implements IAdmin {
    @Override
    public void addSession(String fName, String lName, String game, int nPost, int period, Time startTimeT) {

        // Create an instance of the session object
        Session session = new Session(fName, lName, game, nPost, period,startTimeT);

        // Add the session to the list
        GamesRoom.places.offer(session);

        // Add the session to the post and make it not available
        HashMap<Post, Integer> posts = GamesRoom.posts;
        Iterator<Map.Entry<Post,Integer>> iterator = posts.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<Post, Integer> entry = iterator.next();
            Post post = (Post) entry.getKey();
            if(post.getPostNum()==nPost){
                entry.setValue(1);
                post.setSession(session);
            }

        }



    }

    @Override
    public void addClient() {

    }

    @Override
    public HashMap<Post, Integer> getPostsInfo() {
        HashMap<Post, Integer> posts = GamesRoom.posts;
        return posts;
    }

    @Override
    public String getTotalIncome() {
        return null;
    }
}
