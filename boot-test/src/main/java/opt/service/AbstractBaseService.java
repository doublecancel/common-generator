package opt.service;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import lombok.Data;
import opt.core.PageComponent;
import opt.core.ParamsMap;
import opt.dao.BaseMapper;
import opt.dao.Extension;
import opt.dao.Page;
import opt.dao.interceptors.LocalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static opt.constant.GlobalConstant.*;

/**
 * Created by Administrator on 2017/9/21.
 */
public abstract class AbstractBaseService<T, PK extends Serializable> implements IBaseService<T, PK> {

    @Autowired
    BaseMapper<T, PK> baseMapper;

    @Autowired
    PageComponent pageComponent;

    @Override
    public T findOneById(PK id) {
        return baseMapper.findOneById(id);
    }

    @Override
    public Integer updateById(T t) {
        return baseMapper.updateById(t);
    }

    @Override
    public Integer updateByIds(T t, List<PK> list) {
        return baseMapper.updateByIds(t, list);
    }

    @Override
    public Integer deleteById(PK id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer deleteByIds(List<PK> list) {
        return baseMapper.deleteByIds(list);
    }

    @Override
    public T insert(T t) {
        try {
            baseMapper.insert(t);
        }catch (DuplicateKeyException e){
            System.err.print("主键冲突");
        }
        return t;
    }


    @Override
    public Integer batInsert(List<T> list) {
        Preconditions.checkNotNull(list, "批量插入的数据为空");
        Preconditions.checkArgument(list.size() > 0, "批量插入的数据为空");
        return baseMapper.batInsert(list, list.get(0));
    }

    @Override
    public List<T> batInsertGetIds(List<T> list){
        for (T t : list){
            baseMapper.insert(t);
        }
        return list;
    }


    @Override
    @Transactional
    public Integer batInsertWithTrans(List<T> list){
        return 0;
    }


    @Override
    public List<PK> batInsertWithTransGetIds(List<T> list){
        return null;
    }


    /**
     * 根据条件查询所有
     * @param t
     * @param extension
     * @return
     */
    @Override
    public List<T> findAllByCondition(ParamsMap map) {
        Long count = baseMapper.countByCondition(map);
        Preconditions.checkArgument(count <= 2000, "数据量过多，请使用分页接口");
        return baseMapper.findAllByCondition(map);
    }

    @Override
    public Page<T> findLocalPageByCondition(ParamsMap map) {
        pageComponent.setPage();
        List<T> list = baseMapper.findAllByCondition(map);
        return pageComponent.getPage(list);
    }



    @Override
    public Page<T> findPageByCondition(ParamsMap map) {
        return findLocalPageByCondition(map);
    }

    @Override
    public Long countByCondition(ParamsMap map) {
        return baseMapper.countByCondition(map);
    }

    @Override
    public List<T> findListByIds(List<PK> list) {
        Preconditions.checkArgument(list.size() <= 1000, "最多一次返回1000条数据");
        return baseMapper.findListByIds(list);
    }


}
