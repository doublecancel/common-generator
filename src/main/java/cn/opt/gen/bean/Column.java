package cn.opt.gen.bean;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
public class Column {
    private String field;
    private String type;
    private Boolean NUll;
    private Boolean key;
    private String comment;
    private String setMethodName;
    private String getMethodName;

    public static Column create(){
        return new Column();
    }
}
