package by.tms.springtest2.exceptions;

public class UserDoesntExistServiceException extends Exception {
    public UserDoesntExistServiceException() {
    }

    public UserDoesntExistServiceException(String message) {
        super(message);
    }

    public UserDoesntExistServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesntExistServiceException(Throwable cause) {
        super(cause);
    }

    public UserDoesntExistServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
