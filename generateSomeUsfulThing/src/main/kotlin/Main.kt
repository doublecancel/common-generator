import com.google.common.base.CaseFormat
import com.google.common.base.Joiner
import java.io.File
import java.nio.charset.Charset

fun main(args: Array<String>) {


    val list = readFile(fileName = "classes\\UserAccountVo.java")
    val packageName = list.find { it.startsWith("package") }?. drop(8)?.dropLast(1)
    val className = list.find { it.startsWith("public class") }?.drop(13)?.dropLast(1)

    val fieldList = list.filter { it.trim().startsWith("private") }
            .map {
                val cs = it.replace(";", "").split(" ")
                val name = cs.last()
                val type = cs[cs.lastIndex - 1]
                type to name
            }

    val start = "<resultMap id=\"BaseResultMap\" type=\"$packageName.$className\">\n"
    val res = fieldList.map {
        printSome(it.first, it.second)
    }
    val end = "</resultMap>\n"

    val resultmapXml = "$start${Joiner.on("").join(res)}$end"
    println(resultmapXml)



}


fun printSome(type : String, name : String) = when {
    name == "id" -> "  <id column=\"id\" jdbcType=\"INTEGER\" property=\"id\" /> \n"
    type == "Integer" -> "  <result column=\"${name.toLowerUnderScore()}\" jdbcType=\"${type.getType()}\" property=\"$name\" />\n"
    type == "String" -> "  <result column=\"${name.toLowerUnderScore()}\" jdbcType=\"${type.getType()}\" property=\"$name\" />\n"
    type == "LocalDateTime" -> "  <result column=\"${name.toLowerUnderScore()}\" jdbcType=\"${type.getType()}\" property=\"$name\" />\n"
    else -> throw RuntimeException()
}

fun String.toLowerUnderScore() : String{
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, this  )
}

fun String.getType() : String = when {
    this == "LocalDateTime" -> "TIMESTAMP"
    this == "String" -> "VARCHAR"
    this == "Integer" -> "INTEGER"
    else -> ""
}

fun readFile(projectName : String = "generateSomeUsfulThing", fileName : String) : List<String> {

    val path = "${System.getProperty("user.dir")}\\$projectName\\src\\main\\resources\\$fileName"
    val content = File(path).readLines(Charset.forName("UTF-8"))
    return content


}







