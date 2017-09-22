package ${table.domainPackageName};

/**
* Created by Administrator on ${now}
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* ${table.desc}
*/
public class ${table.domainClassName} {

    <#list columns as column>
    private ${column.type} ${column.field};//${column.comment}
    </#list>


    <#list columns as column>
    public void ${column.setMethodName}(${column.type} ${column.field}){
        this.${column.field} = ${column.field};
    }
    public ${column.type} ${column.getMethodName}(){
        return this.${column.field};
    }
    </#list>



}