package opt.dao;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Data
public class Page<T> {

    public static final Integer pageSize = 15;
    public static final Integer pageNo = 1;
    public static Page EMPTY = new Page();

    public static <T> Page<T> create(){
        return new Page();
    }

    private List<T> data;

    private Integer totalPage;
    private Long totalCount;
    private Integer currentPage;
    private Integer rowNum;


}
