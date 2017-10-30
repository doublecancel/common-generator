package opt.core;


import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ParamsMap extends HashMap<String , Object> {

    private static final String ATTACH = "attach";

    private ParamsMap(){}

    public static ParamsMap create(){
        return new ParamsMap();
    }

    public ParamsMap push(String key, String value, Type type){
        Preconditions.checkNotNull(key);
        Preconditions.checkArgument(key.equals(ATTACH));
        if(super.get(key) != null){
            Tuple tuple = new Tuple(value, type);
            ((List)super.get(key)).add(tuple);
        }else{
            Tuple tuple = new Tuple(value, type);
            List<Tuple> list = newArrayList(tuple);
            this.put(key, list);
        }
        return this;
    }

    public ParamsMap attach(String sql){
        super.put(ATTACH, sql);
        return this;
    }

}
