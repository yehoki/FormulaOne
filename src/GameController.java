import java.util.*;

public class GameController {

    private ArrayList<Track> tracks;
    private ArrayList<Team> teams;
    private ArrayList<Driver> drivers;

    private Integer currentTrack;
    private Result qualifyingResults;
    private Result raceResults;

    public GameController() {
        this.initializeTracks();
        this.initializeTeams();
        this.currentTrack = 0;
        this.qualifyingResults = new Result();
        this.raceResults = new Result();
    }

    public GrandPrixController getCurrentGrandPrix() {
        return new GrandPrixController(this.tracks.get(this.currentTrack), this.teams, this.drivers,
                this.qualifyingResults, this.raceResults
        );
    }

    public Integer getCurrentTrack() {
        return this.currentTrack;
    }

    public void nextGrandPrix() {
        if (this.currentTrack == 22) {
            this.currentTrack = 0;
        } else {
            this.currentTrack++;
        }
    }

    private void initializeTracks() {
        ArrayList<Track> trackList = new ArrayList<>();

//        Initialize each track manually
        trackList.add(new Track("Bahrain International Circuit", "Sakhir, Bahrain",
                new ArrayList<>(List.of("balanced", "intermediate-downforce")), 57));
        trackList.add(new Track("Jeddah Street Circuit", "Jeddah, Saudi Arabia",
                new ArrayList<>(List.of("high-speed")), 50));
        trackList.add(new Track("Albert Park Circuit", "Melbourne, Australia",
                new ArrayList<>(List.of("variable")), 58));
        trackList.add(new Track("Baku City Circuit", "Baku, Azerbaijan",
                new ArrayList<>(List.of("low-downforce")), 51));
        trackList.add(new Track("Miami International Autodrome", "Miami, USA",
                new ArrayList<>(List.of("street")), 60));
        trackList.add(new Track("Imola Circuit", "Imola, Italy",
                new ArrayList<>(List.of("technical")), 63));
        trackList.add(new Track("Circuit de Monaco", "Monaco",
                new ArrayList<>(List.of("high-downforce", "street")), 78));
        trackList.add(new Track("Circuit de Barcelona-Catalunya", "Barcelona, Spain",
                new ArrayList<>(List.of("intermediate-downforce")), 66));
        trackList.add(new Track("Circuit Gilles Villeneuve", "Montreal, Canada",
                new ArrayList<>(List.of("intermediate-downforce")), 70));
        trackList.add(new Track("Red Bull Ring", "Spielberg, Austria",
                new ArrayList<>(List.of("variable")), 71));
        trackList.add(new Track("Silverstone Circuit", "Silverstone, UK",
                new ArrayList<>(List.of("high-speed")), 52));
        trackList.add(new Track("Hungaroring", "Budapest, Hungary",
                new ArrayList<>(List.of("technical")), 70));
        trackList.add(new Track("Circuit de Spa-Francorchamps", "Spa, Belgium",
                new ArrayList<>(List.of("technical")), 44));
        trackList.add(new Track("Circuit Park Zandvoort", "Zandvoort, Netherlands",
                new ArrayList<>(List.of("intermediate-downforce")), 63));
        trackList.add(new Track("Autodromo Nazionale Monza", "Monza, Italy",
                new ArrayList<>(List.of("low-downforce")), 53));
        trackList.add(new Track("Marina Bay Street Circuit", "Singapore",
                new ArrayList<>(List.of("high-downforce", "street")), 61));
        trackList.add(new Track("Suzuka Circuit", "Suzuka, Japan",
                new ArrayList<>(List.of("technical")), 53));
        trackList.add(new Track("Lusail International Circuit", "Lusail, Qatar",
                new ArrayList<>(List.of("technical")), 57));
        trackList.add(new Track("Circuit of the Americas", "Austin, USA",
                new ArrayList<>(List.of("high-speed")), 56));
        trackList.add(new Track("Autodromo Hermanos Rodriguez", "Mexico City, Mexico",
                new ArrayList<>(List.of("high-speed")), 71));
        trackList.add(new Track("Interlagos Circuit", "Sao Paulo, Brazil",
                new ArrayList<>(List.of("technical")), 71));
        trackList.add(new Track("Las Vegas Street Circuit", "Las Vegas, USA",
                new ArrayList<>(List.of("high-speed", "street")), 59));
        trackList.add(new Track("Yas Marina Circuit", "Yas Island, Abu Dhabi, UAE",
                new ArrayList<>(List.of("intermediate-downforce")), 55));

        this.tracks = trackList;
    }

    private void initializeTeams() {
        ArrayList<Driver> driverList = new ArrayList<>();
        ArrayList<Team> teamList = new ArrayList<>();

//        Add the engines based on the database given
        Engine renaultEngine = new Engine("Renault", 82, 83);
        Engine redBullEngine = new Engine("Red Bull", 81, 90);
        Engine mercedesEngine = new Engine("Mercedes", 90, 90);
        Engine ferrariEngine = new Engine("Ferrari", 97, 95);

//        Initialize drivers and teams
        Driver max = new Driver("Max Verstappen", null, "Netherlands", 85, 97, 86, 98);
        Driver sergio = new Driver("Sergio Perez", null, "Mexico", 92, 95, 86, 85);
        Team redBull = new Team("Red Bull Racing F1 Team", max, sergio, redBullEngine, 93, 89, 93, 95);
        max.setTeam(redBull);
        sergio.setTeam(redBull);

        driverList.add(max);
        driverList.add(sergio);
        teamList.add(redBull);

        Driver lewis = new Driver("Lewis Hamilton", null, "England", 98, 94, 84, 92);
        Driver george = new Driver("George Russell", null, "England", 77, 88, 80, 90);
        Team mercedes = new Team("Mercedes AMG F1 Team", lewis, george, mercedesEngine, 88, 83, 87, 91);
        lewis.setTeam(mercedes);
        george.setTeam(mercedes);

        driverList.add(lewis);
        driverList.add(george);
        teamList.add(mercedes);

        Driver carlos = new Driver("Carlos Sainz Jr.", null, "Spain", 85, 92, 79, 89);
        Driver charles = new Driver("Charles Leclerc", null, "Monaco", 78, 82, 82, 90);
        Team ferrari = new Team("Scuderia Ferrari F1 Team", carlos, charles, ferrariEngine, 85, 84, 89, 84);
        carlos.setTeam(ferrari);
        charles.setTeam(ferrari);

        driverList.add(carlos);
        driverList.add(charles);
        teamList.add(ferrari);

        Driver fernando = new Driver("Fernando Alonso", null, "Spain", 99, 93, 78, 94);
        Driver lance = new Driver("Lance Stroll", null, "Canada", 80, 89, 78, 78);
        Team astonMartin = new Team("Aston Martin F1 Team", fernando, lance, mercedesEngine, 84, 83, 85, 84);
        fernando.setTeam(astonMartin);
        lance.setTeam(astonMartin);

        driverList.add(fernando);
        driverList.add(lance);
        teamList.add(astonMartin);

        Driver lando = new Driver("Lando Norris", null, "England", 77, 88, 78, 92);
        Driver oscar = new Driver("Oscar Piastri", null, "Australia", 58, 79, 80, 87);
        Team mclaren = new Team("Mclaren F1 Team", lando, oscar, mercedesEngine, 87, 83, 80, 80);
        lando.setTeam(mclaren);
        oscar.setTeam(mclaren);

        driverList.add(lando);
        driverList.add(oscar);
        teamList.add(mclaren);

        Driver pierre = new Driver("Pierre Gasly", null, "France", 79, 92, 76, 84);
        Driver esteban = new Driver("Esteban Ocon", null, "France", 79, 92, 76, 84);
        Team alpine = new Team("Alpine F1 Team", pierre, esteban, renaultEngine, 81, 81, 80, 78);
        pierre.setTeam(alpine);
        esteban.setTeam(alpine);

        driverList.add(pierre);
        driverList.add(esteban);
        teamList.add(alpine);

        Driver alex = new Driver("Alexander Albon", null, "Thailand", 77, 84, 77, 91);
        Driver logan = new Driver("Logan Sargeant", null, "United States", 59, 73, 74, 69);
        Team williams = new Team("Williams F1 Team", alex, logan, mercedesEngine, 75, 75, 90, 79);
        alex.setTeam(williams);
        logan.setTeam(williams);

        driverList.add(alex);
        driverList.add(logan);
        teamList.add(williams);

        Driver valtteri = new Driver("Valtteri Bottas", null, "Finland", 88, 85, 97, 87);
        Driver zhou = new Driver("Zhou Guanyu", null, "China", 67, 81, 79, 82);
        Team alfaRomeo = new Team("Alfa Romeo Sauber F1 Team", valtteri, zhou, ferrariEngine, 75, 77, 77, 78);
        valtteri.setTeam(alfaRomeo);
        zhou.setTeam(alfaRomeo);

        driverList.add(valtteri);
        driverList.add(zhou);
        teamList.add(alfaRomeo);

        Driver nico = new Driver("Nico Hulkenberg", null, "Germany", 86, 80, 81, 81);
        Driver kevin = new Driver("Kevin Magnussen", null, "Denmark", 82, 77, 80, 82);
        Team haas = new Team("Haas F1 Team", nico, kevin, ferrariEngine, 75, 74, 71, 77);
        nico.setTeam(haas);
        kevin.setTeam(haas);

        driverList.add(nico);
        driverList.add(kevin);
        teamList.add(haas);

        Driver daniel = new Driver("Daniel Ricciardo", null, "Australia", 90, 85, 84, 86);
        Driver yuki = new Driver("Yuki Tsunoda", null, "Japan", 71, 79, 74, 89);
        Team alphaTauri = new Team("Scuderia AlphaTauri", yuki, daniel, redBullEngine, 74, 70, 76, 77);
        daniel.setTeam(alphaTauri);
        yuki.setTeam(alphaTauri);

        driverList.add(daniel);
        driverList.add(yuki);
        teamList.add(alphaTauri);

        this.drivers = driverList;
        this.teams = teamList;
    }

    public void printTracks() {
        System.out.printf("%-30s | %-30s | %-40s | %-10s\n", "Track", "Location", "Track types", "Laps");
        for (Track track : this.tracks) {
            System.out.printf("%-30s | %-30s | %-40s | %-10s\n", track.getName(), track.getLocation(),
                    track.getTrackType(), track.getLaps());
        }
        System.out.println();
    }

    public void printDrivers() {
        System.out.printf("%-40s | %-25s | %-25s | %-15s | %-15s | %-15s | %-15s \n", "Name", "Nationality", "Team", "Experience",
                "Pace", "Racecraft", "Awareness");
        for (Driver driver : this.drivers) {
            System.out.printf("%-40s | %-25s | %-25s | %-15s | %-15s | %-15s | %-15s \n",
                    driver.getName(), driver.getNationality(), driver.getTeam().getName(),
                    driver.getExperience(), driver.getPace(), driver.getRaceCraft(),
                    driver.getAwareness());
        }
        System.out.println();
    }

    public void printTeams() {
        System.out.printf("%-30s | %-25s | %-25s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                "Name", "First Driver", "Second Driver",
                "Engine Supplier", "Aerodynamics", "Chassis",
                "Powertrain", "Durability");
        for (Team team : this.teams) {
            System.out.printf("%-30s | %-25s | %-25s | %-20s | %-20s | %-20s | %-20s | %-20s \n",
                    team.getName(), team.getDriverOne().getName(), team.getDriverTwo().getName(),
                    team.getEngine().getName(), team.getAerodynamics(), team.getChassis(),
                    team.getPowerTrain(), team.getDurability());
        }
        System.out.println();
    }

    public void printDriverStandings() {
        System.out.printf("%-30s | %-10s  \n",
                "Name", "Points");


        ArrayList<DriverPoints> driverPoints = new ArrayList<>();
        for (Driver driver : this.drivers) {
            driverPoints.add(new DriverPoints(driver, 0));
        }

        for (String trackName : this.raceResults.getResults().keySet()) {
            for (Integer position : this.raceResults.getResults().get(trackName).keySet()) {
                Driver driver = this.raceResults.getResults().get(trackName).get(position);
                int points = this.getPointsFromResult(position);
                for (DriverPoints driverPoint : driverPoints) {
                    Driver newDriver = driverPoint.getDriver();
                    if (newDriver.getName().equals(driver.getName())) {
                        driverPoint.addPoints(points);
                    }
                }
            }
        }

        driverPoints = this.sortDriversOnPoints(driverPoints);

        for (DriverPoints driversPoints : driverPoints) {
            System.out.println(driversPoints.getDriver().getName() + ": " + driversPoints.getPoints());
        }

    }


    public ArrayList<DriverPoints> sortDriversOnPoints(ArrayList<DriverPoints> driverPoints) {
        int index = 0;
        while (index < driverPoints.size() - 1) {
            int largestAt = this.getIndexOfMostPoints(driverPoints, index);
            swap(driverPoints, index, largestAt);
            index++;
        }
        return driverPoints;
    }

    public int getIndexOfMostPoints(ArrayList<DriverPoints> driverPoints, int startIndex) {
        int placeOfLargest = startIndex;

        int index = startIndex;
        while (index < driverPoints.size()) {
            if (driverPoints.get(index).getPoints() > driverPoints.get(placeOfLargest).getPoints()) {
                placeOfLargest = index;
            }
            index++;
        }
        return placeOfLargest;
    }

    private void swap(ArrayList<DriverPoints> driverPoints, int first, int second) {
        DriverPoints tmp = driverPoints.get(first);
        driverPoints.set(first, driverPoints.get(second));
        driverPoints.set(second, tmp);
    }

    public Integer getPointsFromResult(Integer result) {
        if (result == 1) {
            return 25;
        }
        if (result == 2) {
            return 18;
        }
        if (result == 3) {
            return 15;
        }
        if (result == 4) {
            return 12;
        }
        if (result == 5) {
            return 10;
        }
        if (result == 6) {
            return 8;
        }
        if (result == 7) {
            return 6;
        }
        if (result == 8) {
            return 4;
        }
        if (result == 9) {
            return 2;
        }
        if (result == 10) {
            return 1;
        }
        return 0;
    }
}

