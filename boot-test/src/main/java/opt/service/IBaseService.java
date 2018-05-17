package opt.service;


import opt.core.ParamsMap;
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
     * 批量插入
     * list中需要更新字段必须相同
     * @param list
     * @return
     */
    Integer batInsert(List<T> list);

    /**
     *  无限制的批量插入
     * @param list
     * @return
     */
    List<T> batInsertWithoutLimit(List<T> list);

    /**
     * 根据条件查找所有
     * 控制数量控制在2000内，否则报错
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
     * 普通分页查找
     * @param t
     * @param extension
     * @return
     */
    Page<T> findPageByCondition(ParamsMap map, int pageSize, int pageNum);

    /**
     * 根据条件查找数量
     * @param map
     * @return
     */
    Long countByCondition(ParamsMap map);

    /**
     * 查找列表
     * @param list
     * @return
     */
    List<T> findListByIds(List<PK> list);

    /**
     * 根据条件更新
     * @param ma
     * @return
     */
    Integer updateByCondition(T domain, ParamsMap ma);

    /**
     * 根据条件批量删除
     * @param ma
     * @return
     */
    Integer deleteByCondition(ParamsMap ma);

}
