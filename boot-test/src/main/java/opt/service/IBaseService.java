package opt.service;



import opt.dao.Extension;
import opt.dao.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface IBaseService<T, PK extends Serializable> {

    T findOneById(PK id);

    Integer update(T t);

    Integer deleteById(PK id);

    Integer deleteByIds(List<PK> list);

    PK insert(T t);

    Integer batInsert(List<T> list);

    List<T> findAllByCondition(T t, Extension extension);

    Page<T> findPageByCondition(T t, Extension extension);

    Long countByCondition(T t, Extension extension);

    List<T> findListByIds(List<PK> list);



}
