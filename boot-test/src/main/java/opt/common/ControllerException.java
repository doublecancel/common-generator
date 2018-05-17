package opt.common;

/**
 * Created by Administrator on 2017/12/25.
 */
public class ControllerException extends BootException {


    public static ControllerException create(){
        return new ControllerException();
    }

    public static ControllerException create(String message){
        return new ControllerException(message);
    }

    public ControllerException() {
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
