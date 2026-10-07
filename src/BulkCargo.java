
/*
 * Represents bulk cargo ( grain, coal, sand, ore).
 * Extends Cargo and implements Inspectable interface.
 */
public class BulkCargo extends Cargo implements Inspectable {

    // Indicates if the bulk cargo requires moisture-controlled dry storage
    private boolean requiresDryStorage;

    // Safety inspection status required by Inspectable interface
    private boolean inspected;

    //Constructor for BulkCargo.
    public BulkCargo(String id, String description, double weight, String owner, boolean requiresDryStorage) {
        super(id, description, weight, owner);
        this.requiresDryStorage = requiresDryStorage;
        this.inspected = false;
    }

    //Calculates shipping fee based on weight and dry storage requirements.
    @Override
    public double calculateFee() {
        double baseFee = getWeight() * 1.2;
        if (requiresDryStorage) {
            baseFee += 150.0; // Flat fee surcharge for dry storage handling
        }
        return baseFee;
    }

     //Displays specific details of the bulk cargo.
    @Override
    public void displayDetails() {
        System.out.println("=== Bulk Cargo Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Description: " + getDescription());
        System.out.println("Owner: " + getOwner());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Requires Dry Storage: " + (requiresDryStorage ? "Yes" : "No"));
        System.out.println("Inspection Status: " + (inspected ? "Passed" : "Pending"));
        System.out.printf("Calculated Fee: $%.2f%n", calculateFee());
    }

    // Inspectable Interface Methods
    @Override
    public void inspect() {
        this.inspected = true;
        System.out.println("Bulk cargo " + getId() + " has been checked for moisture and contamination.");
    }

    @Override
    public boolean isInspected() {
        return inspected;
    }

    // Getter
    public boolean isRequiresDryStorage() {
        return requiresDryStorage;
    }
}