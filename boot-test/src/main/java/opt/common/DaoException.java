package opt.common;

/**
 * Created by Administrator on 2017/12/25.
 */
public class DaoException extends BootException {

    public static DaoException create(){
        return new DaoException();
    }

    public static DaoException create(String message){
        return new DaoException(message);
    }

    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
