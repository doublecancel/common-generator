package opt.core;


import java.util.HashMap;

public class ParamsMap extends HashMap<String , Tuple> {

    private ParamsMap(){}

    public static ParamsMap create(){
        return new ParamsMap();
    }

    public ParamsMap push(String key, String value, Type type){
        Tuple tuple = new Tuple(value, type);
        this.put(key, tuple);
        return this;
    }

}
