package opt.service;



import opt.dao.Extension;
import opt.dao.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface IBaseService<T, PK extends Serializable> {

    /**
     * 根据id查询一个
     * @param id
     * @return
     */
    T findOneById(PK id);

    /**
     * 根据id更新
     * @param t
     * @return
     */
    Integer updateById(T t);

    /**
     * 根据id列表更新
     * @param t
     * @param list
     * @return
     */
    Integer updateByIds(T t, List<PK> list);

    Integer deleteById(PK id);

    Integer deleteByIds(List<PK> list);

    /**
     * 插入，并且返回带有主键的实体类
     * @param t
     * @return
     */
    T insert(T t);

    /**
     * 批量插入，返回插入的条数
     * 确保list中的属性相同
     * 1.无事物控制
     * @param list
     * @return
     */
    Integer batInsert(List<T> list);

    /**
     * 非事务的方式批量插入数据，并且返回主键集合
     * @param list
     * @return
     */
    List<PK> batInsertGetIds(List<T> list);

    /**
     * 事务的方式批量插入数据
     * @param list
     * @return
     */
    Integer batInsertWithTrans(List<T> list);

    /**
     * 事务的方式批量插入数据并且返回主键集合
     * @param list
     * @return
     */
    List<PK> batInsertWithTransGetIds(List<T> list);

    List<T> findAllByCondition(T t, Extension extension);

    Page<T> findPageByCondition(T t, Extension extension);

    Long countByCondition(T t, Extension extension);

    List<T> findListByIds(List<PK> list);



}
