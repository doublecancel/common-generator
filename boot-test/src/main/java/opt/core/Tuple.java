package opt.core;

public class Tuple {
    String t1;
    Type t2;

    public Tuple(String t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
    public String _1(){
        return t1;
    }
    public Type _2(){
        return t2;
    }


    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public Type getT2() {
        return t2;
    }

    public void setT2(Type t2) {
        this.t2 = t2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof Tuple){
            Tuple a = (Tuple)o;
            if(this.t1.equals(a.t1) && this.t2.getKey() == a.t2.getKey()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = t1 != null ? t1.hashCode() : 0;
        result = 31 * result + (t2 != null ? t2.hashCode() : 0);
        return result;
    }
}
