import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Closes the input reader when the application finishes.
        try (Scanner scanner = new Scanner(System.in)) {

            // Example maximum port capacity: 10,000 ton.
            PortManager manager = new PortManager(10000);

            // Connects the menu to the manager and starts interaction.
            ConsoleMenu menu = new ConsoleMenu(manager, scanner);
            menu.start();
        }
    }
}