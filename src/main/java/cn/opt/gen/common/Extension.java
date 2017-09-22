package cn.opt.gen.common;

import com.google.common.base.Preconditions;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Data
public final class Extension {

    private Extension(){}

    private boolean markLike = false;
    List<String> like = new ArrayList<>();
    private String groupBy;
    private String orderBy;
    private String orderType;
    private Integer offset;
    private Integer rowNum;
    private String attach; //自定义语句，直接拼接到mapper中，有依赖注入的风险

    public static Extension create(){
        return new Extension();
    }

    public Extension AndLike(String fieldName){
        markLike = true;
        Preconditions.checkNotNull(fieldName);
        like.add(fieldName);
        return this;
    }

    public Extension GroupBy(String fieldName){
        Preconditions.checkNotNull(fieldName);
        this.groupBy = fieldName;
        return this;
    }

    public Extension OrderBy(String fieldName){
        Preconditions.checkNotNull(fieldName);
        this.orderBy = fieldName;
        this.orderType = "DESC";//默认降序
        return this;
    }

    public Extension asc(){
        Preconditions.checkNotNull(orderBy, "请先设置排序字段");
        this.orderType = "ASC";
        return this;
    }
    public Extension desc(){
        Preconditions.checkNotNull(orderBy, "请先设置排序字段");
        this.orderType = "DESC";
        return this;
    }

    public Extension limit(Integer offset, int rowNum){
        Preconditions.checkArgument(offset >= 0);
        Preconditions.checkArgument(rowNum >= 0);
        this.offset = offset;
        this.rowNum = rowNum;
        return this;
    }

    public Extension attach(String attach){
        this.attach = attach;
        return this;
    }



}
