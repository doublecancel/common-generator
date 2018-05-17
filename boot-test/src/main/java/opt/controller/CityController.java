package opt.controller;

import opt.controller.editors.LocalDateEditor;
import opt.dao.CityMapper;
import opt.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/12/25.
 */
@RestController
public class CityController extends BaseController {

    @Autowired
    CityMapper cityMapper;


    @GetMapping("city/get/{id}")
    public Object get(@PathVariable Integer id){
        return cityMapper.selectByPrimaryKey(id);
    }


    @GetMapping("city/npe")
    public Object npe(Integer id){
        cityMapper.selectByPrimaryKey(-1).toString();
        return cityMapper.selectByPrimaryKey(id);
    }

    @GetMapping("city/support")
    public Object support(Integer id){
        throw new UnsupportedOperationException();
    }

    @GetMapping("city/date")
    public void date(@RequestParam  Integer id, @RequestParam LocalDateTime time){

        System.out.println("id:" + id);
        System.out.println("time:" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    @PostMapping("/city/save")
    public Object save(@RequestBody CityEntity entity){

        System.out.println(entity.toString());

        return 0;
    }



}
