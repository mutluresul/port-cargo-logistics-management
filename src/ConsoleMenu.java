import java.util.NoSuchElementException;
import java.util.Scanner;

//Handles console interaction.
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

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();

            try {
                int choice = Integer.parseInt(readLine("Choose an option: "));
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
                        portManager.inspectCargo(readRequiredText("Cargo ID:"));
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

    // Collects cargo-specific input and delegates registration to the manager.
    private void addCargo() throws CapacityException {
        System.out.println("1. Container  2. Bulk  3. Liquid");
        int type = Integer.parseInt(readLine("Cargo type: "));
        if (type < 1 || type > 3) {
            throw new IllegalArgumentException("Choose cargo type 1, 2, or 3.");
        }

        String id = readRequiredText("ID: ");
        String description = readRequiredText("Description: ");
        double weight = readPositiveNumber("Weight in kg: ");
        String owner = readRequiredText("Owner: ");
        Cargo cargo;

        switch (type) {
            case 1:
                String number = readRequiredText("Container number: ");
                cargo = new ContainerCargo(id, description, weight, owner, number);
                break;
            case 2:
                boolean dryStorage = readYesNo("Requires dry storage? (yes/no): ");
                cargo = new BulkCargo(id, description, weight, owner, dryStorage);
                break;
            case 3:
                double volume = readPositiveNumber("Volume in liters: ");
                boolean hazardous = readYesNo("Hazardous? (yes/no): ");
                cargo = new LiquidCargo(id, description, weight, owner, volume, hazardous);
                break;
            default:
                throw new IllegalArgumentException("Unsupported cargo type.");
        }
        portManager.addCargo(cargo);
        System.out.println("Cargo added successfully.");
    }

    // Displays cargo details if found; otherwise shows a message.
    private void searchCargo() {
        Cargo cargo = portManager.findCargoById(readRequiredText("Cargo ID: "));
        if (cargo == null) {
            System.out.println("Cargo not found.");
        } else {
            cargo.displayDetails();
        }
    }
    // Reads a cargo ID, attempts removal and displays the result.
    private void removeCargo() {
        boolean removed = portManager.removeCargo(readRequiredText("Cargo ID: "));
        System.out.println(removed ? "Cargo removed." : "Cargo not found.");
    }

    // Reads complete lines to avoid Scanner's nextInt/nextLine newline issue.
    private String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            throw new NoSuchElementException("Input closed.");
        }
        return scanner.nextLine().trim();
    }

    // Repeats the prompt until the user provides nonempty text.
    private String readRequiredText(String prompt) {
        while (true) {
            String value = readLine(prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    // Handles invalid numeric input locally, keeping the current add operation.
    private double readPositiveNumber(String prompt) {
        while (true) {
            try {
                double value = Double.parseDouble(readLine(prompt));
                if (Double.isFinite(value) && value > 0) {
                    return value;
                }
                System.out.println("Enter a positive, finite number.");
            } catch (NumberFormatException e) {
                System.out.println("Enter a number, such as 1500 or 12.5.");
            }
        }
    }

    // Accepts explicit yes/no responses instead of silently assuming false.
    private boolean readYesNo(String prompt) {
        while (true) {
            String value = readLine(prompt);
            if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("y")) {
                return true;
            }
            if (value.equalsIgnoreCase("no") || value.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Enter yes or no.");
        }
    }


}
