public class DriverPoints {

    private Driver driver;
    private Integer points;

    public DriverPoints(Driver driver, Integer points) {
        this.driver = driver;
        this.points = points;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public Integer getPoints() {
        return this.points;
    }

    public void addPoints(Integer points) {
        this.points += points;
    }


}
