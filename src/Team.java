public class Team {
    private String name;
    private Driver driverOne;
    private Driver driverTwo;

    private Engine engine;
    //    Individual car parts
//    Aerodynamics: 0-100 Influences how the car handles air resistance, closely following cars and cornering speeds
//    Chassis: 0-100 Influences how stable the car is, increases overall performance of the car
//    Powertrain: 0-100 Influences the maximum speed of a car
//    Durability: 0-100 Influences how often the car can get a mechanical failure, affects engine as well
    private int aerodynamics;
    private int chassis;
    private int powerTrain;
    private int durability;

    public Team(String name, Driver driverOne, Driver driverTwo, Engine engine,
                int aerodynamics, int chassis, int powerTrain, int durability) {
        this.name = name;
        this.driverOne = driverOne;
        this.driverTwo = driverTwo;
        this.engine = engine;
        this.aerodynamics = aerodynamics;
        this.chassis = chassis;
        this.powerTrain = powerTrain;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public Driver getDriverOne() {
        return driverOne;
    }

    public Driver getDriverTwo() {
        return driverTwo;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getAerodynamics() {
        return aerodynamics;
    }

    public int getChassis() {
        return chassis;
    }

    public int getDurability() {
        return durability;
    }

    public int getPowerTrain() {
        return powerTrain;
    }
}
