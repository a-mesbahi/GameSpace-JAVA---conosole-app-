package admin;

import gamesRoom.GamesRoom;
import interfaces.IAdmin;
import session.Session;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Queue;

public class Admin implements IAdmin {
    @Override
    public void addSession(String fName, String lName, String game, String screen, String console, int nPost, int period, int time, String startTimeT) {
        // Convert the string to time type
        LocalTime startTimeS = LocalTime.parse( startTimeT) ;
        // Create an instance of the session object
        Session session = new Session(fName, lName, game, screen, console, nPost, period, time,startTimeS);
        // Add the session to the list
        GamesRoom.places.offer(session);
    }

    @Override
    public void addClient() {

    }

    @Override
    public String getTotalIncome() {
        return null;
    }
}
