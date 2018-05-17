package opt.controller;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import opt.core.ParamsMap;
import opt.core.Type;
import opt.dao.Page;
import opt.entity.TbUcpaasUserDomain;
import opt.entity.UserDomain;
import opt.service.TbUcpaasUserService;
import opt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/10/31.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TbUcpaasUserService ucpaasUserService;

    @Autowired
    UserService userService;

    //findById
    @RequestMapping("/findById/{id}")
    public Object findById(@PathVariable String id){
        TbUcpaasUserDomain domain = ucpaasUserService.findOneById(id);
        return domain;
    }
    //findByIds
    @RequestMapping("/findByIds/{ids}")
    public Object findByIds(@PathVariable String ids){
        List<String> iidds = Arrays.stream(ids.split(","))
                .filter(a -> !a.equals(""))
                .collect(Collectors.toList());
        List<TbUcpaasUserDomain> domains = ucpaasUserService.findListByIds(iidds);
        return domains;
    }

    //findAllByCondition
    @RequestMapping("/findAllByCondition")
    public Object findAllByCondition(){
        List<String> ids = IntStream.range(80, 100)
                .mapToObj(a -> a + "")
                .collect(Collectors.toList());
//        ParamsMap map = ParamsMap.create()
//                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2014-10-12", Type.GT)
//                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2018-10-12", Type.LT)
//                .push(TbUcpaasUserDomain.Field.STATUS, "1", Type.EQ)
//                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LIKE)
//                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LEFT_LIKE)
//                .pushIN(TbUcpaasUserDomain.Field.ID, ids)
//                .pushIN(TbUcpaasUserDomain.Field.IS_CONTRACT, ids);

//        List<TbUcpaasUserDomain> domains = ucpaasUserService.findAllByCondition(map);


        ParamsMap map = ParamsMap.create()
                .in(UserDomain.Field.ID, ids)
                .eq(UserDomain.Field.USERNAME, "lxl")
                .in(UserDomain.Field.USERNAME, ids)
                .like(UserDomain.Field.STATUS, "1");


        userService.findAllByCondition(map);
        return null;
    }
    //findPageByCondition
    @RequestMapping("/findPageByCondition")
    public Object findPageByCondition(){

        ParamsMap map = ParamsMap.create()
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2014-10-12", Type.GT)
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2018-10-12", Type.LT)
                .push(TbUcpaasUserDomain.Field.STATUS, "1", Type.EQ)
                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LIKE)
                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LEFT_LIKE);

        Page<TbUcpaasUserDomain> page = ucpaasUserService.findPageByCondition(map, 3, 20);
        return page;
    }

    @RequestMapping("/findLocalPageByCondition")
    public Object findLocalPageByCondition(){

        ParamsMap map = ParamsMap.create()
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2014-10-12", Type.GT)
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2018-10-12", Type.LT);
//                .push(TbUcpaasUserDomain.Field.STATUS, "1", Type.EQ)
//                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LIKE)
//                .push(TbUcpaasUserDomain.Field.USERNAME, "刘", Type.LEFT_LIKE);

        Page<TbUcpaasUserDomain> page = ucpaasUserService.findLocalPageByCondition(map);
        return page;
    }

    //updateById
    @PostMapping("/updateById")
    public Object updateById(@RequestBody TbUcpaasUserDomain domain){
        Preconditions.checkNotNull(domain.getId());
        int a = ucpaasUserService.updateById(domain);
        return a;
    }

    //updateByIds
    @PostMapping("/updateByIds")
    public Object updateByIds(@RequestBody TbUcpaasUserDomain domain){
        int a = ucpaasUserService.updateByIds(domain,
                Lists.newArrayList("000e65df74aa8d0e1676047a50b7152f",
                        "000eb2534798cae8fadaed3aef8557ea"));
        return a;
    }
    //updateByCondition
    @PostMapping("/updateByCondition")
    public Object updateByCondition(@RequestBody TbUcpaasUserDomain domain){
        ParamsMap map = ParamsMap.create()
                .push(TbUcpaasUserDomain.Field.USERNAME, "lxfdsafdsa", Type.EQ);
        int a = ucpaasUserService.updateByCondition(domain, map);
        return a;
    }

    //insertOne
    @PostMapping("/insertOne")
    public Object insertOne(@RequestBody TbUcpaasUserDomain domain){
        TbUcpaasUserDomain a = ucpaasUserService.insert(domain);
        return a;
    }
    //batInsert
    @PostMapping("/batInsert")
    public Object batInsert(@RequestBody TbUcpaasUserDomain domain){
        List<TbUcpaasUserDomain> domains = Lists.newArrayList();
        domains.add(domain);
        domains.add(domain);
        domains.add(domain);
        domains.add(domain);
        domains.add(domain);
        domains.add(domain);
        Integer a = ucpaasUserService.batInsert(domains);
        return a;
    }

    //deleteById
    @PostMapping("/deleteById/{id}")
    public Object deleteById(@PathVariable String id){
        Integer a = ucpaasUserService.deleteById(id);
        return a;
    }
    //deleteByCondition
    @PostMapping("/deleteByIds/{ids}")
    public Object deleteByIds(@PathVariable String ids){
        List<String> iidds = Arrays.stream(ids.split(","))
                .filter(a -> !a.equals(""))
                .collect(Collectors.toList());
        Integer a = ucpaasUserService.deleteByIds(iidds);
        return a;
    }

    @PostMapping("/deleteByCondition/{ids}")
    public Object deleteByCondition(@PathVariable String ids){
        ParamsMap map = ParamsMap.create()
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2014-10-12", Type.GT)
                .push(TbUcpaasUserDomain.Field.CREATE_DATE, "2018-10-12", Type.LT)
                .push(TbUcpaasUserDomain.Field.USERNAME, "lxfdsafdsa123", Type.EQ);
        Integer a = ucpaasUserService.deleteByCondition(map);
        return a;
    }



}
