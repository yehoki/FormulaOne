public class Engine {

    private String name;
    //    durability: 0-100 Influences how often an engine gets broken down during the race
//    performance: 0-100 Influences the performance of an engine, such as max speed
    private int durability;
    private int performance;

    public Engine(String name, int durability, int performance) {
        this.name = name;
        this.durability = durability;
        this.performance = performance;
    }

    public String getName() {
        return this.name;
    }

    public int getDurability() {
        return this.durability;
    }

    public int getPerformance() {
        return this.performance;
    }
}
