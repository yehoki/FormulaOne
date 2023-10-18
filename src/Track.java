import java.util.ArrayList;

public class Track {
    private String name;
    private String location;
    //    The track type will fall into the following categories
//    1. High-downforce: Tracks that require high downforce setups, where qualifying is more important and overtaking
//    is more difficult than on other tracks, even with DRS (Drag Reduction System) enabled.
//    2. Low-downforce: Tracks that require lower downforce setups, where cars with a higher top speed will be favoured.
//    3. Intermediate-downforce: Tracks where an overall balance is useful, the best overall car should be the quickest
//    4. High-speed tracks: Tracks which require a generally quick and stable car, cars with good powertrain and
//    chassis setups will perform great here
//    5. Technical tracks: Tracks which are quite technical and reward good drivers, however drivers with less
//    awareness are more likely to commit errors here
//    6. Street circuits: Tracks which are created on a street, where mistakes are very costly and require the drivers
//    to be aware and quick to finish the race
//    7. Variable: Tracks which have a large number of variety that could affect it, favours well balanced cars and
//    drivers
    private ArrayList<String> trackType;
    private int laps;

    public Track(String name, String location, ArrayList<String> trackType, int laps) {
        this.name = name;
        this.location = location;
        this.trackType = trackType;
        this.laps = laps;
    }

    public int getLaps() {
        return this.laps;
    }

    public String getTrackType() {
        String trackTypes = "";
        for (String trackType : this.trackType) {
            trackTypes += trackType + ", ";
        }
        return trackTypes;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }
}
