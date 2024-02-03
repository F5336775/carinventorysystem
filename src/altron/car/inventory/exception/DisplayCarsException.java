package altron.car.inventory.exception;

public class DisplayCarsException extends RuntimeException {

    public DisplayCarsException() {
    }

    public DisplayCarsException(String message) {
        super(message);
    }

    public DisplayCarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DisplayCarsException(Throwable cause) {
        super(cause);
    }

    public DisplayCarsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
