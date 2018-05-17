package ${table.controllerPackageName};

/**
* Created by Administrator on ${now}
* ${table.desc}
*/
@RestController
@RequestMapping("/table.name")
public class ${table.controllerClassName} {

    @Autowired
    ${table.serviceClassName} service;

    /**
    *
    * 根据id查找
    */
    @GetMapping("/{id}")
    public Resp getById(@PathVariable ${table.primaryType} id){
        ${table.domainClassName} domain = service.findOneById(id);
        return Resp.succeed(domain);
    }

    /**
    *
    * 分页查找
    */
    @GetMapping
    public Resp getPage(){
        Page page = service.findPageByCondition(domain, extension);
        return Resp.paging(page);
    }

    /**
    *
    * 插入一条数据
    */
    @RequestMapping(value = "/insertOne", method=RequestMethod.GET)
    public Object insertOne(@RequestBody ${table.domainClassName} domain){
        TbUcpaasMenuDomain result = service.insert(domain);
        return result;
    }

    /**
    *
    * 根据id更新一条数据
    */
    @RequestMapping(value = "/getPage", method=RequestMethod.GET)
    public Object update(@RequestBody ${table.domainClassName} domain){
        int result = service.updateById(domain);
        return result;
    }

    /**
    *
    * 删除一条数据
    */
    @RequestMapping(value = "/deleteById/{id}", method=RequestMethod.GET)
    public Object deleteById(@PathVariable ${table.primaryType} id){
        int a = service.deleteById(id);
        return a;
    }

    /**
    *
    * 导出数据
    */
    @RequestMapping(value = "/deleteById/{id}", method=RequestMethod.GET)
    public void export(@RequestBody ${table.domainClassName} domain, HttpServletResponse response){
        String fileName = "";
        String title = "";
        initResponse(response);
        Extension extension = Extension.createWithPage();
        List<${table.domainClassName}> data = service.findAllByCondition(domain, extension);
        Excel excel = initExcelHeaders(title);
        excel.setData(data);
        try {
            ExcelUtils.exportExcel(excel, response.getOutputStream());
        }catch(IOException e){}
        finally{}
    }

    private void initResponse(HttpServletResponse response){
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO-8859-1"));
            response.setContentType("application/msexcel");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private Excel initExcelHeaders(String title){
        Excel excel = new Excel();
        excel.setTitle(title);
        <#list columns as column>
        excel.addHeader(30, "${column.comment}", "${column.field}");
        </#list>
        return excel;
    }


}