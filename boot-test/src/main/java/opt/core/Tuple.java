package opt.core;

public class Tuple<T, V> {
    T t1;
    V t2;

    public Tuple(T t1, V t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
    public T _1(){
        return t1;
    }
    public V _2(){
        return t2;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public V getT2() {
        return t2;
    }

    public void setT2(V t2) {
        this.t2 = t2;
    }
}
