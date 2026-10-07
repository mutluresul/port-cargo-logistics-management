
// Represents container cargo in the port system.
// Inherits shared cargo information from Cargo.
public class ContainerCargo extends Cargo {

    // Stores the container number. It cannot be reassigned after construction.
    private final String containerNumber;

    // New cargo starts uninspected.
    private boolean inspected;

    // Creates container cargo with its shared and specific information.
    public ContainerCargo(
            String id,
            String description,
            double weight,
            String owner,
            String containerNumber) {

        // Calls the Cargo constructor to initialize.
        super(id, description, weight, owner);

        // Rejects null, empty, or whitespace-only container numbers.
        if (containerNumber == null || containerNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Container number cannot be empty.");
        }

        // Removes leading and trailing spaces before storing the number.
        this.containerNumber = containerNumber.trim();
        this.inspected = false;
    }

    // Calculates the fee using a rate of $2 per kilogram.
    @Override
    public double calculateFee() {
        return getWeight() * 2.0;
    }

        // Displays shared cargo information and the container number.
    @Override
    public void displayDetails() {
        System.out.println("***** Container Cargo Details *****");

        // Uses inherited getters to access Cargo's private fields.
        System.out.println("ID: " + getId());
        System.out.println("Description: " + getDescription());
        System.out.println("Owner: " + getOwner());
        System.out.println("Weight: " + getWeight() + " kg");

        System.out.println("Container Number: " + containerNumber);

        // Prints the fee with two decimal places.
        System.out.printf("Calculated Fee: $%.2f%n", calculateFee());
    }

    // Inspectable Interface Methods - Simulates a successful inspection and records the result.
    @Override
    public void inspect() {
        this.inspected = true;
        System.out.println(
                "Container cargo " + getId() + " has passed inspection.");
    }

    // Returns true if the cargo has been inspected.
    @Override
    public boolean isInspected() {
        return inspected;
    }

    // Provides read access to the private container number.
    public String getContainerNumber() {
        return containerNumber;
    }
}