import admin.Admin;
import gamesRoom.GamesRoom;
import post.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {


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










    }
}
