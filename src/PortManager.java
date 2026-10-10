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



}
