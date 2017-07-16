package ninja.harmless.vishnu.common.exception;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class RequestParameterNotFoundException extends RuntimeException {
    public RequestParameterNotFoundException() {
    }

    public RequestParameterNotFoundException(String message) {
        super(message);
    }

    public RequestParameterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestParameterNotFoundException(Throwable cause) {
        super(cause);
    }

    public RequestParameterNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
