package by.tms.springtest2.exceptions;

public class UserAuthorizationServiceException extends Exception {

    public UserAuthorizationServiceException() {
    }

    public UserAuthorizationServiceException(String message) {
        super(message);
    }

    public UserAuthorizationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAuthorizationServiceException(Throwable cause) {
        super(cause);
    }

    public UserAuthorizationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
