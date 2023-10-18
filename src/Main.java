import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        UserInterface ui = new UserInterface(scanner, gameController);

        ui.start();
    }
}