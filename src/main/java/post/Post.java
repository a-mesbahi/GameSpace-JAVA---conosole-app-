package post;

import session.Session;

import java.rmi.server.UID;
import java.util.HashMap;

public class Post {
    private static int count = 0;
    String id;
    String screen;
    String console;
    int postNum;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    Session session;

    public String getId() {
        return id;
    }

    public int getPostNum() {
        return postNum;
    }

    public String getScreen() {
        return screen;
    }

    public String getConsole() {
        return console;
    }

    public Post(String screen, String console){
        UID postId = new UID();
        this.id = postId.toString();
        this.console = console;
        this.screen = screen;
        this.postNum = ++count;

    }


}
