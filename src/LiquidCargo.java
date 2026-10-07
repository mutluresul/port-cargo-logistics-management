/*
 * Represents liquid cargo ( oil, chemicals, water).
 * Extends the abstract Cargo class and implements the Inspectable interface.
 * Demonstrates Inheritance, Polymorphism, and Interface implementation.
 */
public class LiquidCargo extends Cargo implements Inspectable {

    // Volume of the liquid cargo in liters
    private double volume;

    // Flag indicating whether the liquid is hazardous (e.g., flammable/chemical)
    private boolean isHazardous;

    // Safety inspection status required by Inspectable interface
    private boolean inspected;


    // Constructor for LiquidCargo with validation.

    public LiquidCargo(String id, String description, double weight, String owner, double volume, boolean isHazardous) {
        super(id, description, weight, owner);

        if (volume <= 0) {
            throw new IllegalArgumentException("Liquid volume must be greater than zero.");
        }

        this.volume = volume;
        this.isHazardous = isHazardous;
        this.inspected = false; // Default inspection status is false until inspect() is called
    }


    //Calculates shipping fee based on weight, volume, and hazardous multiplier.
    @Override
    public double calculateFee() {
        double baseFee = getWeight() * 1.5 + volume * 0.8;
        if (isHazardous) {
            baseFee *= 1.25; // 25% hazard surcharge
        }
        return baseFee;
    }


    //Displays specific details of the liquid cargo.
    @Override
    public void displayDetails() {
        System.out.println("=== Liquid Cargo Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Description: " + getDescription());
        System.out.println("Owner: " + getOwner());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Volume: " + volume + " L");
        System.out.println("Is Hazardous: " + (isHazardous ? "Yes" : "No"));
        System.out.println("Inspection Status: " + (inspected ? "Passed" : "Pending"));
        System.out.println("Calculated Fee: $" + String.format("%.2f", calculateFee()));
    }

    // Inspectable Interface Methods
    @Override
    public void inspect() {
        this.inspected = true;
        System.out.println("Liquid cargo " + getId() + " has been inspected for leakages and safety standards.");
    }

    @Override
    public boolean isInspected() {
        return inspected;
    }

    // Getters and Setters
    public double getVolume() {
        return volume;
    }

    public boolean isHazardous() {
        return isHazardous;
    }
}