package opt.controller.advice;

import opt.common.BootException;
import opt.common.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/12/25.
 */
//@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(ControllerException.class)
    @ResponseBody
    public String exceptionRunntimeException(HttpServletRequest request, ControllerException e){
        return e.getMessage();
    }

    @ExceptionHandler(BootException.class)
    @ResponseBody
    public String BootException(HttpServletRequest request, BootException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String NOT_FOUND(HttpServletRequest request, Throwable e){
        return "空指针";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String INTERNAL_SERVER_ERROR(HttpServletRequest request, RuntimeException e){

        e.printStackTrace();

        return "服务端错误信息";
    }


}
