package opt.service;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import lombok.Data;
import opt.core.PageComponent;
import opt.dao.BaseMapper;
import opt.dao.Extension;
import opt.dao.Page;
import opt.dao.interceptors.LocalPage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
        baseMapper.insert(t);
        return t;
    }


    @Override
    public Integer batInsert(List<T> list) {
        Preconditions.checkNotNull(list, "批量插入的数据为空");
        Preconditions.checkArgument(list.size() > 0, "批量插入的数据为空");
        return baseMapper.batInsert(list, list.get(0));
    }

    @Override
    public List<PK> batInsertGetIds(List<T> list){
        return null;
    }


    @Override
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
    public List<T> findAllByCondition(T t, Extension extension) {
        return baseMapper.findAllByCondition(t, extension);
    }

    @Override
    public Page<T> findLocalPageByCondition(T t, Extension extension) {

        pageComponent.setPage();
        List<T> list = baseMapper.findAllByCondition(t, extension);
        return pageComponent.getPage(list);
    }



    @Override
    public Page<T> findPageByCondition(T t, Extension extension) {

        Long count = baseMapper.countByCondition(t, extension);
        if(count < 1) return Page.EMPTY;
        extension.totalCount(count.intValue());
        List<T> list = baseMapper.findAllByCondition(t, extension);
        Page<T> page = Page.create();
        page.setCurrentPage(extension.getPageNo());
        page.setData(list);
        page.setRowNum(extension.getRowNum());
        page.setTotalCount(count.intValue());
        page.setTotalPage(extension.getTotalPage());
        return page;
    }

    @Override
    public Long countByCondition(T t, Extension extension) {
        return baseMapper.countByCondition(t, extension);
    }

    @Override
    public List<T> findListByIds(List<PK> list) {
        return baseMapper.findListByIds(list);
    }


}
