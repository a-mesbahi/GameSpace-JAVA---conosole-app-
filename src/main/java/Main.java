import admin.Admin;
import checkers.TimerChecker;
import gamesRoom.GamesRoom;
import post.Post;
import session.Session;

import java.awt.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime timeNow = LocalTime.now();

        TimerChecker time = new TimerChecker();


        LocalTime diffEndMorning = LocalTime.parse("14:31");

        HashMap<String, String> reuslt= time.getPlayingTime(diffEndMorning);

        System.out.println(reuslt);














    }
}
