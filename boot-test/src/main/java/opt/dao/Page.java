package opt.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public class Page<T> {


    public static Page EMPTY = new Page();

    public static <T> Page<T> create(){
        return new Page();
    }

    private List<T> data;

    private Integer totalPage;
    private Integer totalCount;
    private Integer currentPage;
    private Integer rowNum;


    public static Page getEMPTY() {
        return EMPTY;
    }

    public static void setEMPTY(Page EMPTY) {
        Page.EMPTY = EMPTY;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
