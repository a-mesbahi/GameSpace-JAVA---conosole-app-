package gamesRoom;

import session.Session;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GamesRoom {
    public static HashMap <String, Integer> screens = new HashMap<>();
    public static HashMap <String, Integer> consoles = new HashMap<>();
    public static  Queue<Session> places = new LinkedList<>();

}
