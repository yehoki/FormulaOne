import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private GameController gameController;
    private ArrayList<String> commands;

    public UserInterface(Scanner scanner, GameController gameController) {
        this.scanner = scanner;
        this.gameController = gameController;
        this.commands = new ArrayList<>();
        this.initialiseCommands();
    }

    public void start() {
        System.out.println("———— Welcome to the Formula 1 simulation! ————");
        while (true) {
            System.out.println("Please enter a command from the list below:");
            this.printCommands();
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                break;
            }

            if (input.equals("begin")) {
                this.begin();
            }

            if (input.equals("standings")) {
                gameController.printDriverStandings();
            }

            if (input.equals("teams")) {
                gameController.printTeams();
            }

            if (input.equals("gps")) {
                gameController.printTracks();
            }

            if (input.equals("drivers")) {
                gameController.printDrivers();
            }

            if (input.equals("season")) {
                this.simulateSeason();
            }
        }
    }

    private void initialiseCommands() {
        this.commands.add("begin - Begins the game");
        this.commands.add("quit - Quits the game");
        this.commands.add("teams - Displays the current teams");
        this.commands.add("drivers - Displays the current drivers");
        this.commands.add("standings - Displays the current standings");
        this.commands.add("gps - Displays all the Grand Prixs in the calendar");
    }

    private void begin() {
        GrandPrixController currentGrandPrix = gameController.getCurrentGrandPrix();
        System.out.println("Welcome to the " + currentGrandPrix.getTrack().getName());
        System.out.println();

        while (true) {
            String stage = currentGrandPrix.getCurrentStage();
            if (stage.equals("finished")) {
                gameController.nextGrandPrix();
                currentGrandPrix = gameController.getCurrentGrandPrix();
                break;
            }
            currentGrandPrix.simulateCurrentSession();
            String command = scanner.nextLine();
        }
    }

    private void simulateSeason() {
        GrandPrixController currentGrandPrix = gameController.getCurrentGrandPrix();
        while (gameController.getCurrentTrack() < 23 && gameController.getCurrentTrack() != 0) {
            System.out.println("Welcome to the " + currentGrandPrix.getTrack().getName());
            System.out.println();
            while (true) {
                String stage = currentGrandPrix.getCurrentStage();
                if (stage.equals("finished")) {
                    gameController.nextGrandPrix();
                    currentGrandPrix = gameController.getCurrentGrandPrix();
                    break;
                }
                currentGrandPrix.simulateCurrentSession();
            }
        }
        gameController.printDriverStandings();
    }


    private void printCommands() {
        for (String command : this.commands) {
            System.out.println(command);
        }
    }
}

