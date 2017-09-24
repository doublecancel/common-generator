package opt.service;

import opt.dao.BaseMapper;
import opt.dao.Extension;
import opt.dao.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public abstract class AbstractBaseService<T, PK extends Serializable> implements IBaseService<T, PK> {

    @Autowired
    BaseMapper<T, PK> baseMapper;

    @Override
    public T findOneById(PK id) {
        return baseMapper.findOneById(id);
    }

    @Override
    public Integer update(T t) {
        return baseMapper.update(t);
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
    public PK insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public Integer batInsert(List<T> list) {
        return baseMapper.batInsert(list);
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
