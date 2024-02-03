package altron.car.inventory.exception;

public class SearchCarStrategyException extends RuntimeException{
    public SearchCarStrategyException() {
    }

    public SearchCarStrategyException(String message) {
        super(message);
    }

    public SearchCarStrategyException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchCarStrategyException(Throwable cause) {
        super(cause);
    }

    public SearchCarStrategyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
