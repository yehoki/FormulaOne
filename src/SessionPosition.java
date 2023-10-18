public class SessionPosition {
    private Driver driver;
    private int driverValue;

    public SessionPosition(Driver driver, int driverValue) {
        this.driver = driver;
        this.driverValue = driverValue;
    }

    public int getDriverValue() {
        return this.driverValue;
    }

    public void setDriverValue(int newValue) {
        this.driverValue = newValue;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public boolean equals(Driver driver) {
        return driver.getName().equals(this.driver.getName());
    }
}
