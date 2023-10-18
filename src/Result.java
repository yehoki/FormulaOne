import java.util.ArrayList;
import java.util.HashMap;

public class Result {

    private HashMap<String, HashMap<Integer, Driver>> results;

    public Result() {
        this.results = new HashMap<>();
    }

    public void addResults(String trackName, HashMap<Integer, Driver> driverOrder) {
        this.results.put(trackName, driverOrder);
    }

    public HashMap<String, HashMap<Integer, Driver>> getResults() {
        return this.results;
    }
}
