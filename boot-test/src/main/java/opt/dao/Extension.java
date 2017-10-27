package opt.dao;

import com.google.common.base.Preconditions;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Data
public final class Extension {

    public Extension(){}

    private boolean markLike = false;
    List<String> like = new ArrayList<>();
    private String groupBy;
    private String orderBy;
    private String orderType;
    private Integer offset;
    private Integer rowNum;//每页显示的条数
    private Integer totalCount;
    private Integer pageNo;//当前页码
    private Integer totalPage;//总页码
    private String attach; //自定义语句，直接拼接到mapper中，有依赖注入的风险

    public static Extension createWithPage(){
        Extension extension = new Extension();
        //默认创建时间降序排列
//        extension.orderBy = "create_date";
//        extension.orderType = "desc";
        extension.rowNum = 30;
        extension.pageNo = 1;
        return extension;
    }

    public static Extension createWithoutPage(){
        Extension extension = new Extension();
        //默认创建时间降序排列
//        extension.orderBy = "create_date";
//        extension.orderType = "desc";
        return extension;
    }

    public Extension AndLike(boolean markLike){
        this.markLike = markLike;
//        Preconditions.checkNotNull(fieldName);
//        like.add("`"+fieldName+"`");
        return this;
    }

    public Extension GroupBy(String fieldName){
        Preconditions.checkNotNull(fieldName);
        this.groupBy = "`"+fieldName+"`";
        return this;
    }

    public Extension OrderBy(String fieldName){
        Preconditions.checkNotNull(fieldName);
        this.orderBy = "`"+fieldName+"`";
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

    public Extension page(Integer pageNo, int rowNum){
        Preconditions.checkArgument(pageNo > 0);
        Preconditions.checkArgument(rowNum > 0);
        this.pageNo = pageNo;
        this.rowNum = rowNum;
        return this;
    }

    public Extension totalCount(Integer totalCount){
        Preconditions.checkArgument(totalCount > 0);
        this.totalCount = totalCount;
        this.offset = computeOffset();
        return this;
    }

    private Integer computeOffset(){
        int a = totalCount % rowNum == 0 ? totalCount / rowNum : (totalCount / rowNum + 1);
        this.totalPage = a;
        if(pageNo > totalPage) this.pageNo = this.totalPage;
        if(pageNo < 1) this.pageNo = 1;
        return (pageNo - 1) * rowNum;
    }

    public Extension attach(String attach){
        this.attach = attach;
        return this;
    }



}
