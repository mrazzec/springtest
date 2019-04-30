package by.tms.springtest2.exceptions;

public class UserFindServiceException extends Exception {

    public UserFindServiceException() {
    }

    public UserFindServiceException(String message) {
        super(message);
    }

    public UserFindServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserFindServiceException(Throwable cause) {
        super(cause);
    }

    public UserFindServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
