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


        List<Object> strings = new ArrayList<>();
        strings.add("amine");
        strings.add("amine");
        strings.add("amine");
        strings.add(2);
        strings.add("amine");
        strings.add("amine");


        for (Object item : strings){
            if (item instanceof String) {
                System.out.println(item);
            }
        }
        System.out.println(strings);















    }
}
