import java.util.Scanner;

public class ConsoleMenu {
    private final PortManager  portManager;
    private final Scanner scanner;

    // Creates the menu with the manager and input reader it will use.
    public ConsoleMenu(PortManager portManager, Scanner scanner) {
        if (portManager == null || scanner == null) {
            throw new IllegalArgumentException("PortManager or scanner cannot be null...");
        }
        this.portManager = portManager;
        this.scanner = scanner;
    }

    // Display menu choices.
    private void displayMenu() {
        System.out.println("\n=== Port Cargo Management ===");
        System.out.println("1. Add Cargo");
        System.out.println("2. Display All Cargo");
        System.out.println("3. Search by ID");
        System.out.println("4. Remove Cargo");
        System.out.println("5. Inspect Cargo");
        System.out.println("6. Show Total Weight");
        System.out.println("7. Show Total Fees");
        System.out.println("8. Exit");
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            displayMenu();

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addCargo();
                        break;
                    case 2:
                        portManager.displayAllCargo();
                        break;
                    case 3:
                        searchCargo();
                        break;
                    case 4:
                        removeCargo();
                        break;
                    case 5:
                        portManager.inspectCargo(readrequiredText("Cargo ID:"));
                        break;
                    case 6:
                        portManager.getTotalWeight();
                        break;
                    case 7:
                        portManager.getTotalFees();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Choose a menu option from 0 to 7.");

                }
            }catch (NumberFormatException e){
                //Invalid menu input returns the user to the menu.
                System.out.println("Please enter a valid number.");
            }catch (CapacityException e){
                //The manager rejects the cargo before the collection is changed.
                System.out.println("Capacity error: " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Invalid Data: " + e.getMessage());
            }
        }
    }

}
