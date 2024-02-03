package altron.car.inventory.exception;

public class SortingStrategyException extends RuntimeException{
    public SortingStrategyException() {
    }

    public SortingStrategyException(String message) {
        super(message);
    }

    public SortingStrategyException(String message, Throwable cause) {
        super(message, cause);
    }

    public SortingStrategyException(Throwable cause) {
        super(cause);
    }

    public SortingStrategyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
