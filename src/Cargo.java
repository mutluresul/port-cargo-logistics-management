
/*
 * Abstract superclass representing a general Cargo item in the port system.
 * Serves as the foundation for specific cargo types (LiquidCargo, BulkCargo,).
 * Demonstrates Abstraction and Encapsulation principles.
 */

public abstract class Cargo {

    // Unique identifier for the cargo
    private String id;

    // Detailed description of the cargo contents
    private String description;

    // Weight of the cargo in kg
    private double weight;

    // Owner or shipping company name
    private String owner;

    /*
     * Constructor for Cargo with strict input validation.
     * Throws IllegalArgumentException if any parameter violates domain constraints.
     */
    public Cargo(String id, String description, double weight, String owner) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(" Cargo ID cannot be empty");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException(" Weight must be greater than zero");
        }
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.owner = owner;
    }
    // Abstract method to calculate shipping fee.
    public abstract double calculateFee();

    // Abstract method to display specific cargo details
    public abstract void displayDetails();

    // Getters and Setters
    public String getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getWeight() {
        return weight;
    }
    public String getOwner() {
        return owner;

    }
}