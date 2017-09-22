package opt.controller;

import com.google.common.base.Predicates;
import opt.dao.Extension;
import opt.entity.TbUcpaasUser;
import opt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/21.
 */
@RestController
public class UserController {


    @Autowired
    IUserService userService;

    @RequestMapping("/test")
    public String save(){
        return "HelloWorld";
    }

    @RequestMapping("/findById/{id}")
    public Object findById(@PathVariable String id){
        return userService.findOneById(id);
    }

    //findListByIds

    @RequestMapping("/findListByIds/{ids}")
    public Object findListByIds(@PathVariable String ids){

        List<String> idList = Arrays.stream(ids.split(","))
                .filter(Predicates.notNull())
                .collect(Collectors.toList());

        return userService.findListByIds(idList);
    }

    //findAllByCondition
    @PostMapping("/findAllByCondition")
    public Object findAllByCondition(@RequestBody TbUcpaasUser ucpaasUser){
        Extension extension = Extension.create();
        return userService.findAllByCondition(ucpaasUser, extension);
    }
}
