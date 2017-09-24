package opt.controller;

import com.google.common.base.Predicates;
import javafx.application.Application;
import opt.dao.Extension;
import opt.entity.TbUcpaasUser;
import opt.entity.UserDomain;
import opt.service.IUserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

    @Autowired
    ApplicationContext context;

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
    public Object findAllByCondition(@RequestBody UserDomain userDomain){
        Extension extension = Extension.create();

        extension.GroupBy("id");
//        extension.OrderBy("age").desc();
        extension.attach(" order by create_date desc");

        extension.AndLike(false);


        return userService.findAllByCondition(userDomain, extension);
    }


    @PostMapping("/findPageByCondition")
    public Object findPageByCondition(@RequestBody UserDomain userDomain){
        Extension extension = Extension.create();

//        extension.GroupBy("id");
//        extension.OrderBy("age").desc();
//        extension.attach(" order by create_date desc");

        extension.limit(2, 20);

        extension.AndLike(false);

        return userService.findPageByCondition(userDomain, extension);
    }




}
