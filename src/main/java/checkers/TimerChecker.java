package checkers;

import admin.Admin;
import gamesRoom.GamesRoom;
import interfaces.ITimerChecker;
import post.Post;
import session.Session;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class TimerChecker implements ITimerChecker {
    Timer timer ;

    TimerTask task ;

    public TimerChecker(int nPost, Session session,int time)  {

        this.timer = new Timer();
        this.task = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("\nLe post %d est libre\n",nPost);
                HashMap<Post, Integer> posts = GamesRoom.posts;
                Iterator<Map.Entry<Post,Integer>> iterator = posts.entrySet().iterator();

                while(iterator.hasNext()){
                    Map.Entry<Post, Integer> entry = iterator.next();
                    Post post = (Post) entry.getKey();
                    if(post.getPostNum()==nPost){
                        entry.setValue(0);
                        post.setSession(null);
                    }
                }

                int index = GamesRoom.places.indexOf(session);
                GamesRoom.places.remove(index);


                Session newSession = GamesRoom.waitingLine.poll();


                if(newSession!=null){
                    LocalTime timeNow = LocalTime.now();

                    Admin admin = new Admin();

                    try {
                        admin.addSession(newSession.getfName(), newSession.getlName(), newSession.getGame(), nPost, newSession.getPeriod(), timeNow.toString());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }



            }
        };
        this.timer.schedule(this.task,time);
    }

    public TimerChecker() {
    }

    @Override
    public String getTheEndTime(String startTime, int period) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = df.parse(startTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, period);
        String newTime = df.format(cal.getTime());
        return newTime;
    }

    @Override
    public HashMap<String,String> getPlayingTime(LocalTime timeNow) {

        HashMap<String,String> schedulesAvailable = new HashMap<>();
        schedulesAvailable.put("0","full");
        schedulesAvailable.put("1","30min");

        if(timeNow.isBefore(GamesRoom.morningEnd) && timeNow.isAfter(GamesRoom.morningStart)){
            long diffStartMorning = Duration.between(timeNow,GamesRoom.morningEnd).toMinutes();
            if(diffStartMorning>=30){
                if(diffStartMorning>=60){
                    schedulesAvailable.put("2","1h");
                    if(diffStartMorning>=120){
                        schedulesAvailable.put("3","2h");
                    }
                }
            }else{
                schedulesAvailable.clear();
            }

        } else if (timeNow.isBefore(GamesRoom.eveningEnd) && timeNow.isAfter(GamesRoom.eveningStart)) {
            long diffStartEven = Duration.between(timeNow,GamesRoom.eveningEnd).toMinutes();
            if(diffStartEven<330){
                schedulesAvailable.remove("0");
            }
            if(diffStartEven>=30){
                if(diffStartEven>=60){
                    schedulesAvailable.put("2","1h");
                    if(diffStartEven>=120){
                        schedulesAvailable.put("3","2h");
                        if(diffStartEven>=300){
                            schedulesAvailable.put("4","5h");
                        }
                    }
                }

            }else{
                schedulesAvailable.clear();
            }
        }else{
            schedulesAvailable.clear();
            System.out.println("none");

        }

        return schedulesAvailable;



        /*
        long diffStartMorning = Duration.between(GamesRoom.morningStart,timeNow).toMinutes();
        long diffEndMorning = Duration.between(timeNow,GamesRoom.morningEnd).toMinutes();


        LocalTime diffStartEve = LocalTime.parse("02:00");
        LocalTime diffEndEve = LocalTime.parse("20:00");




        System.out.println(diffEndMorning);

         */
    }


}
