package opt.controller;

import opt.entity.TestFormatUser;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TestFormatterController2 {

//    @PostMapping("/user/format/test")
//    public String test(@RequestBody TestFormatUser user){
//        System.out.println(user.toString());
//        return "ok";
//    }

    @GetMapping("/user/format2/test2")
    public String test2(@RequestParam LocalDateTime date){
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        return "ok";
    }
}
