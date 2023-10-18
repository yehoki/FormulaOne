import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class GrandPrixController {
    private Track track;
    private ArrayList<Team> teams;
    private ArrayList<Driver> drivers;
    private ArrayList<Driver> initialDrivers;
    private String currentStage;
    private HashMap<Integer, SessionPosition> qualifyingPositions;
    private Result qualifyingResults;
    private Result raceResults;


    public GrandPrixController(Track track, ArrayList<Team> teams, ArrayList<Driver> drivers, String currentStage
            , HashMap<Integer, SessionPosition> qualifyingPositions,
                               Result qualifyingResults, Result raceResults) {
        this.track = track;
        this.teams = teams;
        this.drivers = drivers;
        this.currentStage = currentStage;
        this.qualifyingPositions = qualifyingPositions;
        this.qualifyingResults = qualifyingResults;
        this.raceResults = raceResults;
    }

    public GrandPrixController(Track track, ArrayList<Team> teams, ArrayList<Driver> drivers,
                               Result qualifyingResults, Result raceResults
    ) {
        this.track = track;
        this.teams = teams;
        this.drivers = drivers;
        this.initialDrivers = drivers;
        this.currentStage = "Q1";
        this.qualifyingPositions = new HashMap<>();
        this.qualifyingResults = qualifyingResults;
        this.raceResults = raceResults;
    }

    public Track getTrack() {
        return this.track;
    }

    public String getCurrentStage() {
        return this.currentStage;
    }

    public void simulateCurrentSession() {
        System.out.println("Current stage: " + this.currentStage);
        Session session = new Session(this.drivers, this.track, this.currentStage);

        ArrayList<SessionPosition> results = session.simulateSession();

        ArrayList<Driver> newDrivers = new ArrayList<>();

        if (this.currentStage.equals("race")) {
            HashMap<Integer, Driver> raceResults = new HashMap<>();
            for (int i = 0; i < results.size(); i++) {
                raceResults.put(i + 1, results.get(i).getDriver());
            }
            this.raceResults.addResults(this.track.getName(), raceResults);
        }

        if (this.currentStage.equals("Q1")) {
            for (int i = 0; i < 15; i++) {
                newDrivers.add(results.get(i).getDriver());
            }
            this.drivers = newDrivers;
            for (int i = 19; i > 14; i--) {
                this.qualifyingPositions.put(i + 1, results.get(i));
            }
        }

        if (this.currentStage.equals("Q2")) {
            for (int i = 0; i < 10; i++) {
                newDrivers.add(results.get(i).getDriver());
            }
            this.drivers = newDrivers;
            for (int i = 14; i > 9; i--) {
                this.qualifyingPositions.put(i + 1, results.get(i));
            }
        }

        if (this.currentStage.equals("Q3")) {
            for (int i = 0; i < 10; i++) {
                this.qualifyingPositions.put(i + 1, results.get(i));
            }
            this.drivers = this.initialDrivers;
            this.printCurrentPositions();
            HashMap<Integer, Driver> qualifyingResults = new HashMap<>();
            for (Integer position : this.qualifyingPositions.keySet()) {
                qualifyingResults.put(position, this.qualifyingPositions.get(position).getDriver());
            }
            this.qualifyingResults.addResults(this.track.getName(), qualifyingResults);
        }

        this.goToNextStage();
    }

    private void goToNextStage() {
        if (this.currentStage.equals("race")) {
            this.currentStage = "finished";
        }
        if (this.currentStage.equals("Q3")) {
            this.currentStage = "race";
        }
        if (this.currentStage.equals("Q2")) {
            this.currentStage = "Q3";
        }
        if (this.currentStage.equals("Q1")) {
            this.currentStage = "Q2";
        }
    }

    private void printCurrentPositions() {
        System.out.println("Latest qualifying results");
        System.out.printf("%-10s | %-30s | %-30s \n", "Position", "Driver", "Team");
        for (Integer position : this.qualifyingPositions.keySet()) {
            System.out.printf("%-10s | %-30s | %-30s \n",
                    position + ".", this.qualifyingPositions.get(position).getDriver().getName(),
                    this.qualifyingPositions.get(position).getDriver().getTeam().getName() + ": "
                            + this.qualifyingPositions.get(position).getDriverValue()
            );
        }
    }
}
