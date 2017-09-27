package opt.controller;

import com.google.common.base.Predicates;
import javafx.application.Application;
import opt.dao.Extension;
import opt.entity.TbUcpaasMenuDomain;
import opt.entity.TbUcpaasUser;
import opt.entity.TbUcpaasUserDomain;
import opt.entity.UserDomain;
import opt.service.IUserService;
import opt.service.TbUcpaasMenuService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public Object findAllByCondition(@RequestBody TbUcpaasUserDomain userDomain){
        Extension extension = Extension.createWithoutPage();

        extension.GroupBy("id");
        extension.OrderBy("channel_id").asc();
//        extension.attach(" order by channel_id desc");

        extension.AndLike(true);

        return userService.findAllByCondition(userDomain, extension);
    }


    @PostMapping("/findPageByCondition")
    public Object findPageByCondition(@RequestBody TbUcpaasUserDomain userDomain){
        Extension extension = Extension.createWithPage();

//        extension.GroupBy("id");
//        extension.OrderBy("age").desc();
//        extension.attach(" order by create_date desc");

        extension.page(2, 20);
        extension.AndLike(true);
        return userService.findPageByCondition(userDomain, extension);
    }

    @PostMapping("/updateById")
    public Object updateById(@RequestBody TbUcpaasUserDomain userDomain){
        int result = userService.updateById(userDomain);
        return result;
    }

    @PostMapping("/updateByIds/{ids}")
    public Object updateByIds(@RequestBody TbUcpaasUserDomain userDomain, @PathVariable String ids){
        int result = userService.updateByIds(userDomain, Arrays.asList(ids.split(",")));
        return result;
    }


    @Autowired
    TbUcpaasMenuService ucpaasMenuService;


    @PostMapping("/insert")
    public Object insert(@RequestBody TbUcpaasMenuDomain userDomain){
        TbUcpaasMenuDomain result = ucpaasMenuService.insert(userDomain);
        return result.getMenu_id();
    }
    @GetMapping("/batInsert")
    public Object batInsert(){
        List<TbUcpaasMenuDomain> data = new ArrayList<>();
        IntStream.range(1, 10).forEach(a -> {
            TbUcpaasMenuDomain t = new TbUcpaasMenuDomain();
            t.setMenu_name("测试" + a);
            data.add(t);
        });
        int result = ucpaasMenuService.batInsert(data);
        return result;
    }
    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id){
        int a = ucpaasMenuService.deleteById(id);
        return a;
    }

    @GetMapping("/deleteByIds/{ids}")
    public Object deleteByIds(@PathVariable String ids){
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(a -> Integer.parseInt(a))
                        .collect(Collectors.toList());
        int a = ucpaasMenuService.deleteByIds(idList);
        return a;
    }




}
