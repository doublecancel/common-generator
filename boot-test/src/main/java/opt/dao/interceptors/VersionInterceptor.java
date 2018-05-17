package opt.dao.interceptors;

import opt.core.annotation.Version;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by Administrator on 2017/10/21.
 * 版本控制，防止更新丢失
 */
@Intercepts({
        @Signature(type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class})
})
public class VersionInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object[] os = invocation.getArgs();
        MappedStatement mst = (MappedStatement)os[0];

        if(!(SqlCommandType.UPDATE == mst.getSqlCommandType())){
            return invocation.proceed();
        }
        MapperMethod.ParamMap map = (MapperMethod.ParamMap)os[1];
        Object obj = map.get("domain");
        changeClazz(obj);
        return invocation.proceed();
    }

    private void changeClazz(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fs = clazz.getDeclaredFields();
        Field.setAccessible(fs, true);
        Optional<Field> optional = Arrays.stream(fs)
                .filter(a -> a.isAnnotationPresent(Version.class))
                .filter(a -> checkType(a))
                .filter(a -> getVersionField(obj, a) != null)
                .findFirst();//多个version字段，只会有第一个生效
        optional.map(a -> setVersionField(obj, a));
    }

    /**
     * version注解的字段必须为Integer或者是Long类型
     * @param a
     * @return
     */
    private boolean checkType(Object a){
        Field f = (Field)a;
        Class<?> clazz = f.getType();
        return (clazz.equals(int.class))
                || (clazz.equals(long.class))
                || (clazz.equals(Integer.class))
                || (clazz.equals(Long.class));
    }

    /**
     * 在更新条件中显示的设置该字段的值
     * @param obj
     * @param f
     * @return
     */
    private Object getVersionField(Object obj, Field f){
        try {
            System.out.println(f.getName() + ":" + f.get(obj));
            return f.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Object setVersionField(Object obj, Field f){
        try {
            f.set(obj, ((Long)getVersionField(obj, f)) + 1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }



    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
