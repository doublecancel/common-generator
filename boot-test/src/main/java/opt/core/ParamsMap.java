package opt.core;


import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class ParamsMap extends HashMap<String , Object> {

    private static final String ATTACH = "attach";
    private static final String IN = "IN";

    private ParamsMap(){}

    public static ParamsMap create(){
        return new ParamsMap();
    }

    public ParamsMap push(String key, Object value, Type type){
        Preconditions.checkNotNull(key);
        Preconditions.checkArgument(!key.equals(ATTACH));
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


    public ParamsMap eq(String key, String value){
        return push(key, value, Type.EQ);
    }
    public ParamsMap like(String key, String value){
        return push(key, value, Type.LIKE);
    }
    public ParamsMap gte(String key, String value){
        return push(key, value, Type.GT);
    }
    public ParamsMap lte(String key, String value){
        return push(key, value, Type.LT);
    }


    //Key:[ids, Type]
    public ParamsMap in(String key, List<String> ids) {
        List<Tuple> list = new ArrayList<>();
        Tuple tuple = new Tuple(ids, Type.IN);
        list.add(tuple);
        super.put(key, list);
        return this;
    }

}
