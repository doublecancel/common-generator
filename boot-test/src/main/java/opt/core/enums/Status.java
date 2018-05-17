package opt.core.enums;

/**
 * Created by Administrator on 2017/12/26.
 */
public enum Status {
    GOOD(1),
    BAD(0);
    int a;

    Status(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}
