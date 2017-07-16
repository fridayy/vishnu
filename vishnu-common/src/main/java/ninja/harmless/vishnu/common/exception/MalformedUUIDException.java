package ninja.harmless.vishnu.common.exception;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public class MalformedUUIDException extends RuntimeException {
    public MalformedUUIDException() {
    }

    public MalformedUUIDException(String message) {
        super(message);
    }

    public MalformedUUIDException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedUUIDException(Throwable cause) {
        super(cause);
    }

    public MalformedUUIDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
