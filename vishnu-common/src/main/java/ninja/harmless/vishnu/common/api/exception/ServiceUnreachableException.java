package ninja.harmless.vishnu.common.api.exception;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class ServiceUnreachableException extends RuntimeException {
    public ServiceUnreachableException() {
    }

    public ServiceUnreachableException(String message) {
        super(message);
    }

    public ServiceUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUnreachableException(Throwable cause) {
        super(cause);
    }

    public ServiceUnreachableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
