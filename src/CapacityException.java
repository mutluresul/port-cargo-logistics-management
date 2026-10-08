
//Thrown when adding cargo would exceed thw port's maximum weight capacity.
public class CapacityException extends Exception{

    //Passes the error message to the parent Exception class.
    public CapacityException(String message) {
        super(message);
    }

}
