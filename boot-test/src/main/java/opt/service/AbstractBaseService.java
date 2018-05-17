package opt.service;

import com.google.common.base.Preconditions;
import opt.core.PageComponent;
import opt.core.ParamsMap;
import opt.dao.BaseMapper;
import opt.dao.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.io.Serializable;
import java.util.List;

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


    /**
     * 根据条件查询所有
     * @param map
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
    public Page<T> findPageByCondition(ParamsMap map, int pageSize, int pageNum) {
        Page<T> page = Page.create();
        page.setCurrentPage(pageNum);
        page.setRowNum(pageSize);
        Long count = countByCondition(map);
        if(count < 1){
            return Page.EMPTY;
        }
        pageNum = pageNum == 0 ? Page.pageNo : pageNum;
        pageSize = pageSize == 0 ? Page.pageSize : pageSize;
        page.setTotalCount(count);
        Long limit = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        List<T> data = baseMapper.findListByCondition(map, String.format(" limit %s, %s", limit, pageSize));
        page.setData(data);
        return page;
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


    @Override
    public Integer updateByCondition(T domain, ParamsMap ma) {
        return baseMapper.updateByCondition(domain, ma);
    }

    @Override
    public Integer deleteByCondition(ParamsMap ma) {
        return baseMapper.deleteByCondition(ma);
    }


    @Override
    public List<T> batInsertWithoutLimit(List<T> list) {
        for (T t : list){
            insert(t);
        }
        return list;
    }
}
