
/*
 * Interface defining safety inspection behavior.
 * Applied to cargo types that require mandatory safety checks before loading.
 */
public interface Inspectable {

    //Performs a safety inspection on the cargo.
    void inspect();

    //Returns the current safety inspection status.
    // @return true if the cargo passed inspection, false otherwise.
    boolean isInspected();
}
