package metier;

import post.Post;
import admin.Admin;

import java.sql.Time;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Metier {
        // Initiate the admin class
        Admin admin = new Admin();
        public void checkPosts(){
            HashMap<Post, Integer> posts = admin.getPostsInfo();
            Iterator<Map.Entry<Post,Integer>> iterator = posts.entrySet().iterator();
            int postNUm = 1;
            while(iterator.hasNext()){
                Map.Entry<Post, Integer> entry = iterator.next();
                Post post = (Post) entry.getKey();
                int ifAvailable = entry.getValue();
                String availablity = (ifAvailable!=0)? "Not Available":"Available";
                System.out.printf("%s-%-30d","Post",post.getPostNum());
                System.out.printf("ID : %-50s",post.getId());
                System.out.printf("Screen : %-40s",post.getScreen());
                System.out.printf("Console : %-40s",post.getConsole());
                System.out.printf("Availablity : %-50s",availablity);
                System.out.println(post.getSession());
                System.out.println();
            }
        }

        public void addSession(String fName, String lName, String game, int nPost, int period, Time startTimeT){
            admin.addSession(fName, lName, game, nPost, period, startTimeT);
        }
}
