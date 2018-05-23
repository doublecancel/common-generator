import com.google.common.base.CaseFormat
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import org.jooq.DSLContext
import org.jooq.impl.DSL
import java.io.File
import java.io.FileWriter
import java.sql.DriverManager
import java.util.*

fun main(args: Array<String>) {
    Generate().generate()
}


class Generate {

    val dbList = listOf("system", "user", "financing", "market", "transaction")

    init {
        val p = Properties()
        p.load(Generate :: class.java.getResourceAsStream("velocity.properties"))
        Velocity.init(p)

        arrayOf(path.controller, path.service, path.serviceImpl, path.dto, path.vo, path.mapper, path.javaMapper)
                .forEach {
                    a ->
                    dbList
                            .forEach {
                                val file = File("$a\\$it\\")
                                if(file.exists()) file.delete()
                                file.mkdirs()
                            }
                }
    }

    var parentPath : String = ""

    fun generate() {
        dbList
                .forEach {
                    parentPath = it
                    println ("start generate $it")
                    getTableDomainList(it).forEach{generateAllFile(it)}
                }
        println("finished...")
    }

    fun generateAllFile(it : TableDomain)  {
        generateController(it)
        generateService(it)
        generateServiceImpl(it)
        generateMapper(it)
        generateJavaMapper(it)
        generateVO(it)
        generateDto(it)
    }

    fun generateMapper(it : TableDomain){
        val domainFullName = it.domainFullName.format(if(parentPath == "system") "base" else parentPath )
        val mapperFullName = it.mapperFullName.format(if(parentPath == "system") "base" else parentPath )

        it.domainFullName = domainFullName
        it.mapperFullName = mapperFullName

        val fileName = "${path.mapper}\\$parentPath\\${it.tableName}ExtMapper.xml"
        generateCommon(it,  fileName, "mapper.vm")
    }

    fun generateJavaMapper(it : TableDomain){
        val fileName = "${path.javaMapper}\\$parentPath\\${it.tableName}ExtMapper.java"
        generateCommon(it,  fileName, "javaMapper.vm")
    }

    fun clearAndCreateFile(fileName : String){
        val file = File(fileName)
        if(file.exists()) file.delete()
        file.createNewFile()
    }

    fun generateService(domain : TableDomain){
        val fileName = "${path.service}\\$parentPath\\${domain.tableName}Service.java"
        generateCommon(domain,  fileName, "service.vm")
    }

    fun generateServiceImpl(domain : TableDomain){
        val fileName = "${path.serviceImpl}\\$parentPath\\${domain.tableName}ServiceImpl.java"
        generateCommon(domain,  fileName, "serviceImpl.vm")
    }

    fun generateDto(domain : TableDomain){
        val ingoreList = listOf<String>("createId", "createName", "updateId", "updateName", "status", "createDate", "updateDate")
        val fileName = "${path.dto}\\$parentPath\\${domain.tableName}Dto.java"
        //dto中过滤掉不需要的字段
        val list = domain.columns
                .filter { !ingoreList.contains(it.fieldName) }
                .toList()
        domain.columns = list
        generateCommon(domain,  fileName, "dto.vm")
    }

    fun generateVO(domain: TableDomain){
        val fileName = "${path.vo}\\$parentPath\\${domain.tableName}Vo.java"
        generateCommon(domain,  fileName, "vo.vm")
    }

    fun generateController (domain : TableDomain) {
        val fileName = "${path.controller}\\$parentPath\\${domain.tableName}Controller.java"
        generateCommon(domain,  fileName, "controller.vm")
    }

    fun generateCommon(domain : TableDomain,  fileName: String, templateName : String ){
        clearAndCreateFile(fileName)
        val context = VelocityContext()
        context.put("domain", domain)
        val writer = FileWriter(fileName)
        val template = Velocity.getTemplate(templateName, charset)

        template.merge(context, writer)
        writer.flush()
        writer.close()
    }

    data class TableDomain(val tableName : String,
                           val tableDesc : String,
                           val url : String,
                           val apiDesc : String,
                           val notes : String,
                           var columns : List<Column>,
                           var domainFullName : String,
                           var mapperFullName : String,
                           val dbTableName : String)

    class Path {
        lateinit var controller : String
        lateinit var service : String
        lateinit var serviceImpl : String
        lateinit var vo : String
        lateinit var dto : String
        lateinit var mapper : String
        lateinit var javaMapper : String
    }



    data class Column(val fieldName:String,
                      val fieldType:String,
                      val primary:Boolean,
                      val setMethod:String,
                      val getMethod:String,
                      val canBenNull : Boolean,
                      val length:Int,
                      val comment : String,
                      val dbType : String,
                      val columnName : String)


    companion object {
        val charset = "UTF-8"
        val path = Path().apply {
            controller = get("controller.path")
            serviceImpl = get("serviceImpl.path")
            service =get("service.path")
            vo = get("vo.path")
            dto = get("dto.path")
            mapper = get("mapper.path")
            javaMapper = get("javaMapper.path")
        }
        private val url = "jdbc:mysql://192.168.1.230:3307/system?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=false&serverTimezone=UTC"
        private val username = "root"
        private val password = "123456"

        private fun getConnection() : DSLContext {
            return DSL.using(DriverManager.getConnection(url, username, password))
        }

        fun getTableDomainList(db : String) : List<TableDomain> {
            val context = getConnection()
            val sql = "select * from information_schema.TABLES where table_schema = '$db'"
            return context.fetch(sql)
                    .map { it.get("TABLE_NAME") as String to it.get("TABLE_COMMENT") as String }
                    .map { getTableDomain(it, db) }
        }

        fun getTableDomain(pair : Pair<String, String>, db : String) : TableDomain {
            val tableName = pair.first
            val tableDesc = pair.second.replace("表", "")

            return  TableDomain(transTableName(tableName),
                    tableDesc,
                    "",
                    "${findTagFromTable(tableDesc)}相关接口",
                    "刘祥雷",
                    getColumnInfo(tableName, db),
                    getDomainFullName(tableName),
                    getMapperFullName(tableName),
                    tableName)

        }

        fun getDomainFullName(tableName : String) : String{
            val name = transTableName(tableName)
            return "com.mchain.bourse.service.%s.entity.$name"
        }

        fun getMapperFullName(tableName : String) : String {
            val name = transTableName(tableName)
            return "com.mchain.bourse.service.%s.dao.ext.${name}ExtMapper"
        }

        fun getColumnInfo(tableName : String, db : String) : List<Column>{
            val sql = "show full fields from `$db`.$tableName"
            val list =  getConnection().fetch(sql)
                    .map{
                        Column(
                                transFieldName(it.get("Field") as String),
                                transFieldTypeName(it.get("Type") as String),
                                isPrimary(it.get("Key") as String),
                                setMethod(it.get("Field") as String),
                                getMethod(it.get("Field") as String),
                                canBeNull(it.get("Null") as String),
                                getLength(it.get("Type") as String),
                                getComment(it.get("Comment") as String, it.get("Field") as String),
                                getDbType(it.get("Type") as String),
                                it.get("Field") as String

                        )
                    }
            return list
        }

        val dbTypeMap = mapOf(
                "INT" to "INTEGER",
                "DATETIME" to "TIMESTAMP",
                "TEXT" to "LONGVARCHAR")

        fun getDbType(fieldName : String) : String{
            val f = if(!fieldName.contains("(")) fieldName.toUpperCase()
                    else fieldName.substring(0, fieldName.indexOf("(")).toUpperCase()
            return dbTypeMap.getOrDefault(f, f)
        }

        val commentMap = mapOf(
                "create_id" to "创建人id",
                "update_id" to "更新人id",
                "create_name" to "创建人名称",
                "update_name" to "更新人名称",
                "create_date" to "创建时间",
                "update_date" to "更新时间",
                "id" to "主键id",
               "status" to "状态（0无效1有效）")

        fun getComment(comment : String, fieldName: String) : String{

            if(comment.isNullOrBlank()) return commentMap.getOrDefault(fieldName, "")
            return comment
        }

        fun getLength(type : String):Int {
            if(!type.contains("(") || !type.contains(")") || type.contains(".") || type.contains(",")) return 0
            val s = type.substring(type.indexOf("(") + 1, type.indexOf(")"))
            return s.toInt()
        }

        fun canBeNull(name : String) = !name.contains("YES")

        fun getMethod (name1 : String) : String{
            val name = transFieldName(name1)
            var cs = name.toCharArray()
            cs[0] = Character.toUpperCase(cs[0])
            return "get${String(cs)}"
        }

        fun setMethod (name1 : String) : String{
            val name = transFieldName(name1)
            var cs = name.toCharArray()
            cs[0] = Character.toUpperCase(cs[0])
            return "set${String(cs)}"
        }

        fun isPrimary(key : String) = key.contains("PRI")

        fun transFieldName(name : String) = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name)

        fun transFieldTypeName(name : String) : String {
            if(!name.contains("(")) return transDbTypeToJava(name)
            val dbType = name.substring(0, name.indexOf("("))
            return transDbTypeToJava(dbType)
        }

        fun transDbTypeToJava(name : String) : String {
            val amap =  mapOf(
                    "varchar" to "String",
                    "int" to "Integer",
                    "text" to "String",
                    "tinyint" to "Integer",
                    "decimal" to "BigDecimal",
                    "datetime" to "LocalDateTime",
                    "timestamp" to "LocalDateTime",
                    "bigint" to "Long"
            )
            if(!amap.containsKey(name)) throw RuntimeException("找不到类型$name")
            return amap.getValue(name)
        }

        fun transTableName(tableName : String) = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName)

        fun findTagFromTable(tableDesc: String) = tableDesc.replace("表", "")

        private fun read() : Properties {
            val p = Properties()
            p.load(Generate::class.java.getResourceAsStream("/config.properties"))
            return p
        }

        private fun get(key : String) = "${read().getProperty("base.path")}\\${read().getProperty(key)}"

    }

}

