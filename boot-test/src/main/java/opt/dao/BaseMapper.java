package opt.dao;

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

    Integer deleteById(PK id);

    Integer deleteByIds(List<PK> list);

    void insert(@Param("domain") T t);

    Integer batInsert(@Param("list") List<T> list, @Param("domain") T t);

    List<T> findAllByCondition(@Param("domain") T domain, @Param("extension") Extension extension);

    Long countByCondition(@Param("domain") T domain, @Param("extension") Extension extension);

    List<T> findListByIds(List<PK> list);


}
