package opt.service;



import opt.core.ParamsMap;
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

    /**
     * 删除，物理删除
     * @param id
     * @return
     */
    Integer deleteById(PK id);

    /**
     * 批量物理删除
     * @param list
     * @return
     */
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
     * 非事务的方式批量插入数据，并且返回带有主键的实体类集合
     * @param list
     * @return
     */
    List<T> batInsertGetIds(List<T> list);

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

    /**
     * 根据条件查找
     * @param map
     * @return
     */
    List<T> findAllByCondition(ParamsMap map);

    /**
     * 自带分页的查找
     * 只支持form表单提交的方式
     * @param map
     * @return
     */
    Page<T> findLocalPageByCondition(ParamsMap map);

    /**
     * 带分页的查找
     * @param t
     * @param extension
     * @return
     */
    Page<T> findPageByCondition(ParamsMap map);

    /**
     * 根据条件查找数量
     * @param t
     * @param extension
     * @return
     */
    Long countByCondition(ParamsMap map);

    /**
     * 查找列表
     * @param list
     * @return
     */
    List<T> findListByIds(List<PK> list);



}
