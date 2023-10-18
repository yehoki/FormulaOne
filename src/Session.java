import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Session {

    private ArrayList<SessionPosition> positions;
    private ArrayList<Driver> drivers;
    private String sessionName;
    private Track track;
    private double trackCondition;

    public Session(ArrayList<Driver> drivers, Track track, String sessionName) {
        this.positions = new ArrayList<>();
        for (int i = 0; i < drivers.size(); i++) {
            this.positions.add(new SessionPosition(drivers.get(i), i));
        }
        this.drivers = drivers;
        this.track = track;
        this.sessionName = sessionName;
        this.trackCondition = 1;
        if (sessionName.equals("Q1")) {
            this.trackCondition = 0.75;
        }
        if (sessionName.equals("Q2")) {
            this.trackCondition = 1.5;
        }
        if (sessionName.equals("Q3")) {
            this.trackCondition = 1.7;
        }
        if (sessionName.equals("race")) {
            this.trackCondition = 1.25;
        }

    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public ArrayList<SessionPosition> simulateSession() {

        if (sessionName.equals("Q1")) {
            for (int i = 0; i < 3; i++) {
                this.simulateLap();
            }
            this.sortPositions();
            this.printPositions();
        }

        if (sessionName.equals("Q2")) {
            for (int i = 0; i < 2; i++) {
                this.simulateLap();
            }
            this.sortPositions();
            this.printPositions();
        }

        if (sessionName.equals("Q3")) {
            this.simulateLap();
            this.sortPositions();
            this.printPositions();
        }


        if (sessionName.equals("race")) {
            int currentLap = 0;
            while (currentLap < this.track.getLaps()) {
                this.simulateLap();
                this.sortPositions();
                System.out.println("Current lap: " + currentLap);
                if (currentLap % 5 == 0) {
                    this.printPositions();
                }
                currentLap++;
            }
        }

        return this.positions;
    }


    private void sortPositions() {
        int index = 0;
        while (index < this.positions.size() - 1) {
            int largestAt = indexOfLargest(this.positions, index);
            swap(this.positions, index, largestAt);
            index++;
        }
    }


    private int indexOfLargest(ArrayList<SessionPosition> positions, int startIndex) {
        int placeOfLargest = startIndex;

        int index = startIndex;
        while (index < positions.size()) {
            if (positions.get(index).getDriverValue() > positions.get(placeOfLargest).getDriverValue()) {
                placeOfLargest = index;
            }
            index++;
        }
        return placeOfLargest;
    }

    private void swap(ArrayList<SessionPosition> positions, int firstIndex, int secondIndex) {
        SessionPosition tmp = positions.get(firstIndex);
        positions.set(firstIndex, positions.get(secondIndex));
        positions.set(secondIndex, tmp);
    }

    public void simulateLap() {
        for (Driver driver : this.drivers) {
            int driverRun = this.simulateDriverRun(driver);
            for (SessionPosition sessionPosition : this.positions) {
                if (sessionPosition.equals(driver)) {
                    if (driverRun == -1) {
                        sessionPosition.setDriverValue(driverRun);
                        continue;
                    }
                    if (driverRun > sessionPosition.getDriverValue() && sessionPosition.getDriverValue() != -1) {
                        sessionPosition.setDriverValue(driverRun);
                    }
                }
            }

        }
    }


//    public void simulateOvertake( )

    private int simulateDriverRun(Driver driver) {

        int durability = (driver.getTeam().getDurability() + driver.getTeam().getEngine().getDurability()) / 2;
        if (this.checkDurability(durability)) {
//            If the car breaks or malfunctions, return -1
            System.out.println(driver.getName() + " had a mechanical failure and has retired from " + this.sessionName);
            return -1;
        }

        double randomnessFactor = Math.random() * 0.1 * (2 - this.trackCondition);
        double carStats = 0;
        double powerTrain = (double) ((driver.getTeam().getPowerTrain()
                + driver.getTeam().getEngine().getPerformance()) / 2);
        if (this.track.getTrackType().contains("balanced")) {
            carStats += (double) driver.getTeam().getAerodynamics();
            carStats += (double) driver.getTeam().getChassis();
            carStats += powerTrain;
        }
        if (this.track.getTrackType().contains("low-downforce")) {
            carStats += (double) driver.getTeam().getAerodynamics() * 0.9;
            carStats += driver.getTeam().getChassis() * 0.9;
            carStats += powerTrain * 1.5;
        }
        if (this.track.getTrackType().contains("intermediate-downforce")) {
            carStats += (double) driver.getTeam().getAerodynamics() * 1.1;
            carStats += driver.getTeam().getChassis() * 1.05;
            carStats += powerTrain * 0.95;
        }
        if (this.track.getTrackType().contains("high-downforce")) {
            carStats += (double) driver.getTeam().getAerodynamics() * 1.25;
            carStats += driver.getTeam().getChassis() * 1.1;
            carStats += powerTrain * 0.85;
        }
        if (this.track.getTrackType().contains("street")) {
            carStats += (double) driver.getTeam().getAerodynamics() * 1.5;
            carStats += (double) driver.getTeam().getChassis() * 1.25;
            carStats += powerTrain * 0.9;
        }
        if (this.track.getTrackType().contains("technical")) {
            carStats += driver.getTeam().getAerodynamics();
            carStats += (double) driver.getTeam().getChassis() * 1.4;
            carStats += powerTrain;
        }
        if (this.track.getTrackType().contains("high-speed")) {
            carStats += (double) driver.getTeam().getAerodynamics() * 1.1;
            carStats += (double) driver.getTeam().getChassis() * 1.15;
            carStats += powerTrain * 2;
        }

        double driverStats = 0;

        if (this.sessionName.contains("Q")) {
            driverStats += (double) driver.getPace() * 2;
            driverStats += (double) driver.getRaceCraft() * 0.25;
            driverStats += (double) driver.getExperience();
            driverStats -= 100 - driver.getAwareness();
        }

        if (this.sessionName.equals("race")) {
            driverStats += (double) driver.getPace() * 1.25;
            driverStats += (double) driver.getRaceCraft() * 1.8;
            driverStats += (double) driver.getExperience() * 1.3;
            driverStats -= (double) (100 - driver.getAwareness()) * 1.25;
        }

        double finalStats = driverStats + carStats;
        finalStats += randomnessFactor * finalStats;
        finalStats *= this.trackCondition;

        return (int) finalStats;
    }

    private boolean checkDurability(int durability) {
//        Simulates the potential of the car breaking down based on its durability
//        Less durable cars are more likely to crash
//        Probability of crashing is (1/D) * (1/D) * (1- (21D/2000))
//        Where D = durability

        double random = Math.random() * 100;
        double durabilityFactor = (double) durability * 0.05;
        random -= durabilityFactor;
        if (random > durability) {
            int firstCheck = (int) Math.round(Math.random() * durability);
            int secondCheck = (int) Math.round(Math.random() * durability);
            return firstCheck == secondCheck;
        }
        return false;
    }

    private void printPositions() {
        System.out.printf("%-10s | %-30s | %-30s \n", "Position", "Driver", "Team");
        for (int i = 1; i <= this.positions.size(); i++) {
            System.out.printf("%-10s | %-30s | %-30s \n",
                    (i) + ".", this.positions.get(i - 1).getDriver().getName(),
                    this.positions.get(i - 1).getDriver().getTeam().getName() + ": "
                            + this.positions.get(i - 1).getDriverValue()
            );
        }
    }
}
