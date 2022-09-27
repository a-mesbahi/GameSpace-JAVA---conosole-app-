package writer;

import incoming.Incoming;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JsonWriter {

    public JSONArray monthlyIncoming = new JSONArray();

    public JsonWriter() throws Exception {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("totalIncoming.json");
        Object obj = jsonParser.parse(reader);
        this.monthlyIncoming = (JSONArray) obj;
    }

    public void write(Incoming incoming) throws IOException {
        JSONObject obj = new JSONObject();


        obj.put("Month",incoming.getMonth());
        obj.put("Money",incoming.getMoney());



        this.monthlyIncoming.add(obj);

        FileWriter file = new FileWriter("totalIncoming.json");

        file.write(this.monthlyIncoming.toJSONString());
        file.flush();

    }

    public Incoming read(JSONObject obj) throws Exception{
         String month = (String) obj.get("Month");
        Long money = (Long) obj.get("Money");
         Incoming incoming = new Incoming(month, Math.toIntExact(money));
         return incoming;
    }


    public Stack<Incoming> allRecords(){
        Stack<Incoming> records = new Stack<>();
        this.monthlyIncoming.forEach(emp-> {
            try {
                Incoming incoming = this.read((JSONObject)emp);
                records.add(incoming);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return records;
    }



}
