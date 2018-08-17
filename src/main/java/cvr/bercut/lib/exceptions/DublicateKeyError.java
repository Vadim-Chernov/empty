package cvr.bercut.lib.exceptions;

public class DublicateKeyError extends RuntimeException {
    public DublicateKeyError() {
    }

    public DublicateKeyError(String message) {
        super(message);
    }

    public DublicateKeyError(String message, Throwable cause) {
        super(message, cause);
    }

    public DublicateKeyError(Throwable cause) {
        super(cause);
    }

    public DublicateKeyError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
