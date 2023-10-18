public class Driver {
    private String name;
    private Team team;
    private String nationality;
    //    Driver parameters:
//    Experience: 0-100 How experience the driver is - influences race craft value
//    Pace: 0-100 How quick the driver is on a single lap - influences qualifying ability and
//    Race craft: 0-100 How well the driver works during the race - influences their ability to overtake
//    Awareness: 0-100 How aware the driver is of the surroundings - influences how often they make mistakes
    private int experience;
    private int pace;
    private int raceCraft;
    private int awareness;


    public Driver(String name, Team team, String nationality, int experience, int pace, int raceCraft, int awareness) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.experience = experience;
        this.pace = pace;
        this.raceCraft = raceCraft;
        this.awareness = awareness;
    }

    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getPace() {
        return this.pace;
    }

    public int getRaceCraft() {
        return this.raceCraft;
    }

    public int getAwareness() {
        return this.awareness;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Driver && ((Driver) obj).getName().equals(this.name)) {
            return true;
        }
        return false;
    }
}

