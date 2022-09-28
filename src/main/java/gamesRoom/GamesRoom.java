package gamesRoom;

import incoming.Incoming;
import org.json.simple.JSONObject;
import post.Post;
import session.Session;
import writer.JsonWriter;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GamesRoom {
    public static HashMap <String, Integer> screens = new HashMap<>();
    public static HashMap <String, Integer> consoles = new HashMap<>();

    public static HashMap<Post, Integer> posts = new HashMap<>();

    public static LinkedList<Session> places = new LinkedList<Session>();

    public static  Queue<Session> waitingLine = new LinkedList<>();

    public static int TotalIncoming = 0;

    public static int MonthlyIncoming;


    public static Stack<JSONObject> monthlyIncoming = new Stack<>();

    public static final LocalTime morningStart = LocalTime.parse("09:00");
    public static final LocalTime morningEnd = LocalTime.parse("12:00");
    public static final LocalTime eveningStart = LocalTime.parse("02:00");
    public static final LocalTime eveningEnd = LocalTime.parse("20:00");

    public static int[] times = {1440,30,60,120,300};
    public static int[] money = {65,  5, 10, 18, 40};

    public static HashMap<Post, Integer> getPosts() {
        return posts;
    }

    public GamesRoom() throws Exception {

        // Add the screens
        screens.put("Dell",3);
        screens.put("HP",1);
        screens.put("Asus",2);
        screens.put("Samsung",2);

        // Add the consoles
        consoles.put("Xbox",4);
        consoles.put("PlayStation5",3);
        consoles.put("Nintendo switch",2);

        // Add posts
        posts.put(new Post("Dell","Xbox"),0);
        posts.put(new Post("HP","Xbox"),0);
        posts.put(new Post("Asus","Xbox"),0);
        posts.put(new Post("Samsung","Xbox"),0);
        posts.put(new Post("Samsung","PlayStation5"),0);
        posts.put(new Post("Dell","PlayStation5"),0);
        posts.put(new Post("Asus","PlayStation5"),0);
        posts.put(new Post("Dell","Nintendo switch"),0);
        posts.put(new Post("Asus","Nintendo switch"),0);


        //get the total incoming
        JsonWriter json = new JsonWriter();
        Stack<Incoming> moreThanMonth = json.allRecords();
        Incoming current = moreThanMonth.peek();
        GamesRoom.MonthlyIncoming = current.money;


    }


}
