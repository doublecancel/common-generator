package ${table.testPackageName};

/**
* Created by Administrator on ${now}
* ${table.desc}
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${table.testClassName} {

    @Autowired
    ${table.serviceClassName} service;

    @Test
    public void findOneById() {
        ${table.domainClassName} domain = service.findOneById(1L);
        System.out.println(new Gson().toJson(domain));
    }

    @Test
    public void updateById() {
        ${table.domainClassName} domain = new ${table.domainClassName}();
        <#list columns as column>
        domain.${column.setMethodName}(${column.type});
        </#list>
        ${table.domainClassName} result = service.updateById(domain);
        System.out.println(new Gson().toJson(result));
    }

    @Test
    public void updateByIds() {
        service.updateByIds(null);
    }

    @Test
    public void deleteById() {
        int a = service.deleteById();
        Assert.assertEquals(a, 1);
    }

    @Test
    public void deleteByIds() {
        service.deleteByIds(null);
    }

    @Test
    public void insert() {
        ${table.domainClassName} domain = new ${table.domainClassName}();
        <#list columns as column>
        domain.${column.setMethodName}(${column.type} ${column.field})
        </#list>
        service.insert(domain);
    }


    @Test
    public void batInsert() {
        service.batInsert(null);
    }

    @Test
    public void batInsertGetIds(){
        service.batInsertGetIds(null);
    }


    @Test
    public void batInsertWithTrans(){
        service.batInsertWithTrans(null);
    }


    @Test
    public void batInsertWithTransGetIds(){
        service.batInsertWithTransGetIds(null);
    }


    /**
    * 根据条件查询所有
    * @param map
    * @return
    */
    @Test
    public void findAllByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        List<${table.domainClassName}> domains = service.findAllByCondition(map);
    }

    @Test
    public void findLocalPageByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        service.findLocalPageByCondition(map);
    }

    @Test
    public void findPageByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        service.findPageByCondition(map);
    }

    @Test
    public void countByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        Long count = service.countByCondition(map);
        Assert.assertEquals(count, 10L);
    }

    @Test
    public void findListByIds() {
        List<${table.primaryType}> ids = new ArrayList();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        service.findListByIds(ids);
    }


    @Test
    public Integer updateByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        service.updateByCondition(map);
    }

    @Test
    public void deleteByCondition() {
        ParamsMap map = ParamsMap.push("", "", Type.EQ)
        .push("", "", Type.LIKE)
        .push("", "", Type.GT)
        .push("", "", Type.LT);
        service.deleteByCondition(map);
    }

}