package metier;

import checkers.TimerChecker;
import gamesRoom.GamesRoom;
import post.Post;
import admin.Admin;
import session.Session;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;

public class Metier {
        // Initiate the admin class
        Admin admin = new Admin();

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public void checkPosts(){
            HashMap<Post, Integer> posts = admin.getPostsInfo();
            Iterator<Map.Entry<Post,Integer>> iterator = posts.entrySet().iterator();
            int postNUm = 1;
            System.out.println();
            System.out.printf(ANSI_PURPLE + "%-10s ","Post");
            System.out.printf("%-50s","ID ");
            System.out.printf("%-40s","Screen ");
            System.out.printf("%-40s","Console ");
            System.out.printf("%-50s\n"+ ANSI_RESET,"Availablity ");
            System.out.println();
            while(iterator.hasNext()){
                Map.Entry<Post, Integer> entry = iterator.next();
                Post post = (Post) entry.getKey();
                int ifAvailable = entry.getValue();
                System.out.printf("%-10d",post.getPostNum());
                System.out.printf("%-50s",post.getId());
                System.out.printf("S%-40s",post.getScreen());
                System.out.printf("%-40s",post.getConsole());
                Session postSession = post.getSession();
                if(postSession!=null){
                    System.out.printf("This post will be available at : %s",postSession.getFinishTime());
                }else{
                    System.out.print("there is no player in this post");
                }
                System.out.println();
            }
        }

        public void addSession() throws ParseException {

            //LocalTime timeNow = LocalTime.now();
            LocalTime timeNow = LocalTime.parse("14:00");

            TimerChecker time = new TimerChecker();

            HashMap<String, String> result= time.getPlayingTime(timeNow);
            Iterator<Map.Entry<String, String>> iterator = result.entrySet().iterator();

            if(result.size()==0){
                System.out.println("Sorry will close");
            }else {
                Scanner input = new Scanner(System.in);
                System.out.printf("\nFirst Name : ");
                String fName = input.nextLine();

                System.out.printf("\nLast Name : ");
                String lName = input.nextLine();

                System.out.printf("\nGame : ");
                String game = input.nextLine();

                System.out.printf("\nPost number : ");
                int nPost = Integer.parseInt(input.nextLine());

                System.out.println();
                while(iterator.hasNext()) {
                    Map.Entry<String, String> entry = iterator.next();
                    String num = entry.getKey();
                    String option = entry.getValue();
                    System.out.printf("%30s-%s",num,option);
                }
                System.out.println();

                System.out.printf("\nPeriod : ");
                String periodS = input.nextLine();


                int period = GamesRoom.times[Integer.parseInt(periodS)];
                int money = GamesRoom.money[Integer.parseInt(periodS)];





                System.out.printf("\nTime to Start : ");
                String strTime = input.nextLine();


                admin.addSession(fName, lName, game, nPost, period, strTime);
                System.out.printf("You have to pay : %d DH",money);
            }



        }

        public void addToWaitingLine(){

            Scanner input = new Scanner(System.in);
            System.out.printf("\nFirst Name : ");
            String fName = input.nextLine();

            System.out.printf("\nLast Name : ");
            String lName = input.nextLine();

            System.out.printf("\nGame : ");
            String game = input.nextLine();


            System.out.printf("\nPeriod : ");
            int period = Integer.parseInt(input.nextLine());

            admin.addToWaitingLine(fName, lName, game, period);



        }
}
