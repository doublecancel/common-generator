package opt.dao;

import opt.core.ParamsMap;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface BaseMapper<T, PK extends Serializable> {

    T findOneById(PK id);

    Integer updateById(@Param("domain") T domain);

    Integer updateByIds(@Param("domain") T domain, @Param("list") List<PK> list);

    Integer updateByCondition(@Param("domain")T domain, @Param("map") ParamsMap map);
    Integer deleteByCondition(@Param("map") ParamsMap map);
    List<T> findAllByCondition(@Param("map") ParamsMap map);
    Long countByCondition(@Param("map") ParamsMap map);


    Integer deleteById(PK id);

    Integer deleteByIds(List<PK> list);

    void insert(@Param("domain") T t);

    Integer batInsert(@Param("list") List<T> list, @Param("domain") T t);


    List<T> findListByIds(List<PK> list);


    List<T> findListByCondition(@Param("map")ParamsMap map, @Param("attach")String attach);
}
