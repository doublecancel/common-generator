package opt.common;

/**
 * Created by Administrator on 2017/12/25.
 */
public class BootException extends RuntimeException {


    public BootException() {
    }

    public BootException(String message) {
        super(message);
    }

    public BootException(String message, Throwable cause) {
        super(message, cause);
    }

    public BootException(Throwable cause) {
        super(cause);
    }

    public BootException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
