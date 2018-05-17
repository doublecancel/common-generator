package opt.controller;

import opt.controller.editors.LocalDateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/12/26.
 */
public class BaseController {

    @Autowired
    LocalDateEditor localDateEditor;


    @InitBinder
    public void binder(WebDataBinder binder){

        System.out.println("binder-------------------------");
//        binder.registerCustomEditor(LocalDateTime.class, localDateEditor);
    }



}
