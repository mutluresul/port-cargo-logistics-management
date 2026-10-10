import java.util.ArrayList;

public class PortManager {

    // Keep different cargo types in one polymorphic collection.
    private final ArrayList<Cargo> cargoList = new ArrayList<>();
    private final double maxCapacity;

    // Creates a port with a positive, finite capacity in kilogram.
    public PortManager(double maxCapacity) {
        if (maxCapacity <= 0 || !Double.isFinite(maxCapacity)) {
            throw new IllegalArgumentException("Capacity must be positive and finite...");
        }
    this.maxCapacity = maxCapacity;
    }

    // Adds cargo only after checking its data, ID.
    public void addCargo(Cargo cargo) {
        if (cargoList.contains(cargo)) {
            throw new IllegalArgumentException("Cargo already exists!");
        }
        if (cargo == null) {
            throw new IllegalArgumentException("Cargo cannot be null!");
        }
        if (cargo.getWeight() <= 0 || !Double.isFinite(cargo.getWeight())) {
            throw new IllegalArgumentException("Weight must be positive and finite...");
        }
        cargoList.add(cargo);
    }

    // Remove the cargo or return null
    public void removeCargo(Cargo cargo) {
        if (cargoList.contains(cargo)) {
            return cargoList.remove(cargo);
        }
        throw new IllegalArgumentException("Cargo does not exists!");
    }

    //Prints all cargos in port
    public void displayAllCargo() {
        if (cargoList.isEmpty()) {
            System.out.println("No Cargos!");
            return;
        }
        //Calls the method that display details.
        for (Cargo cargo : cargoList) {
            cargo.displayDetails();
        }
    }

    // Aggregates the weights of all cargo in the collection.
    public double getTotalWeight() {
        double total = 0;
        for (Cargo cargo : cargoList) {
            total += cargo.getWeight();
        }
        return total;
    }

    //Calculates the total fee of all cargo in the port.
    public double getTotalFees() {
        double total = 0;
        for (Cargo cargo : cargoList) {
            total += cargo.getWeight();
        }
        return total;
    }

}
