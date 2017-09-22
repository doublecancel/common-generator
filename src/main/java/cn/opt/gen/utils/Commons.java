package cn.opt.gen.utils;

import com.google.common.collect.Maps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */
public final class Commons {

    private Commons(){}

    public static <K, V> Map<K, V> newHashMap(K k1, V v1){
        Map<K, V> map = Maps.newHashMap();
        map.put(k1, v1);
        return map;
    }
    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2){
        Map<K, V> map = newHashMap(k1, v1);
        map.put(k2, v2);
        return map;
    }
    public static <K, V> Map<K, V> newHashMap(K k1, V v1, K k2, V v2, K k3, V v3){
        Map<K, V> map = newHashMap(k1, v1, k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static String nowAsString(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


}
