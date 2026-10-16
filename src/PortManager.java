import java.util.ArrayList;

//Manages cargo och enforces the port's weight capacity.
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
    public void addCargo(Cargo cargo) throws CapacityException {
        if (cargo == null) {
            throw new IllegalArgumentException("Cargo cannot be null.");
        }
        if (!Double.isFinite(cargo.getWeight()) || cargo.getWeight() <= 0) {
            throw new IllegalArgumentException("Cargo weight must be positive and finite.");
        }
        if (findCargoById(cargo.getId()) != null) {
            throw new IllegalArgumentException("Cargo ID already exists: " + cargo.getId());
        }
        if (cargo.getWeight() > getRemainingCapacity()) {
            throw new CapacityException("Port capacity exceeded. Remaining capacity: "
                    + getRemainingCapacity() + " ton.");
        }
        cargoList.add(cargo);
    }

    // Returns true if cargo was removed, or false if no matching ID exists.
    public boolean removeCargo(String id) {
        Cargo cargo = findCargoById(id);
        if (cargo == null) {
            return false;
        }
        return cargoList.remove(cargo);
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
            total += cargo.calculateFee();
        }
        return total;
    }

    //Performs inspection through an interface reference.
    public void inspectCargo(String id) {
        Cargo cargo = findCargoById(id);
        if (!cargoList.contains(cargo)) {
            throw new IllegalArgumentException("Cargo does not exists!");
        }
        if (!(cargo instanceof Inspectable)) {
            throw new IllegalArgumentException("Cargo is not Inspectable!");
        }
        Inspectable inspectable = (Inspectable) cargo;
        inspectable.inspect();
    }

    //Returns matching cargo or null
    public Cargo findCargoById(String id) {
        for (Cargo cargo : cargoList) {
            if (cargo.getId().equals(id)) {
                return cargo;
            }
        }
        return null;
    }

    //Returns the maximum capacity.
    public double getMaxCapacity() {
        return maxCapacity;
    }

    // Calculates the free capacity in the port.
    public double getRemainingCapacity() {
        return maxCapacity - getTotalWeight();
    }
}
