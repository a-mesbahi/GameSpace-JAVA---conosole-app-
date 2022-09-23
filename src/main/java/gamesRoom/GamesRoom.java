package gamesRoom;

import post.Post;
import session.Session;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GamesRoom {
    public static HashMap <String, Integer> screens = new HashMap<>();
    public static HashMap <String, Integer> consoles = new HashMap<>();

    public static HashMap<Post, Integer> posts = new HashMap<>();

    public static  Queue<Session> places = new LinkedList<>();
    public static  Queue<Session> waitingLine = new LinkedList<>();

    public static HashMap<Post, Integer> getPosts() {
        return posts;
    }

    public GamesRoom(){

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



    }


}
