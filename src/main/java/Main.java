import gamesRoom.GamesRoom;
import incoming.Incoming;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import post.Post;
import writer.JsonWriter;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {


        HashMap<Post, Integer> posts = GamesRoom.posts;
        Iterator<Map.Entry<Post,Integer>> iterator = posts.entrySet().iterator();
        /*
        while(iterator.hasNext()){
            Map.Entry<Post, Integer> entry = iterator.next();
            Post post = (Post) entry.getKey();
            System.out.println(post.getScreen());
        }

         */
        /*
        for (String name:queue) {
            System.out.println( name);
        }
         */


        JsonWriter json = new JsonWriter();
        Stack<Incoming> moreThanMonth = json.allRecords();
        Incoming current = moreThanMonth.peek();
        System.out.println(current.money);















    }
}
