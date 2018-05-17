package opt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/12/25.
 */
@RestController
public class CityController3 extends BaseController {


    @GetMapping("city3/date")
    public void date(@RequestParam  Integer id, @RequestParam LocalDateTime time){

        System.out.println("id:" + id);
        System.out.println("time:" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
    }




}
