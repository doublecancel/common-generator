package opt.controller;

import opt.config.DatetimeFormatter;
import opt.entity.TestFormatUser;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TestFormatterController extends BaseController{

    @PostMapping("/user/format/test")
    public String test(@RequestBody TestFormatUser user){
        System.out.println(user.toString());
        return "ok";
    }

    @GetMapping("/user/format/test2")
    public String test2(@RequestParam LocalDateTime date){
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        return "ok";
    }
}
