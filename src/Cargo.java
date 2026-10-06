public abstract class Cargo {
    private String id;
    private String description;
    private double weight;
    private String owner;

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

    public abstract double calculateFee();
    public abstract void displayDetails();
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