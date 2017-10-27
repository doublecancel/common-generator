package opt.core;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import opt.dao.Page;
import opt.dao.interceptors.LocalPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static opt.constant.GlobalConstant.CURRENTPAGE;
import static opt.constant.GlobalConstant.ROWNUM;

/**
 * Created by Administrator on 2017/10/27.
 */
@Component
public class PageComponent<T> {


    @Autowired
    HttpServletRequest request;




    public void setPage(){
        String rownum =  request.getParameter(ROWNUM);
        String currentPage =  request.getParameter(CURRENTPAGE);
        Page page = Page.create();
        if(Strings.isNullOrEmpty(rownum)){
            InputStream in = null;
            try {
                in = request.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStreamReader reader = new InputStreamReader(in);
            page = new Gson().fromJson(reader, Page.class);
        } else {
            page.setRowNum(Integer.parseInt(rownum));//每一页显示的数量
            page.setCurrentPage(Integer.parseInt(currentPage));//设置当前页
        }
        if(page != null){
            LocalPage.set(page);
        }
    }

    public Page<T> getPage(List<T> list){
        Page<T> page = LocalPage.getAndRemove();
        page.setData(list);
        return page;
    }
}
