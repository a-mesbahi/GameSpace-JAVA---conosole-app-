package interfaces;

import java.sql.Time;

public interface IAdmin {
    public void addSession(String fName, String lName, String game, String screen, String console, int nPost, int period, int time, String startTime);
    public void addClient();
    public String getTotalIncome();
}
