package cn.opt.gen.utils;


import com.google.common.base.Preconditions;
import lombok.Data;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/9/20.
 */
public class ReadProp {

    public static JdbcProp jdbcProp = initJdbcProperties();
    public static Map<String, String> mapping = readMapping();
    public static ConfigProp configProp = initConfigProp();

    private static ConfigProp initConfigProp(){
        Properties p = commonRead("/config.properties");
        return ConfigProp.loadFromProp(p);
    }

    private static JdbcProp initJdbcProperties(){
        Properties p = commonRead("/jdbc.properties");
        return JdbcProp.initFromProp(p);
    }

    private static Map<String, String> readMapping(){
        Yaml yaml = new Yaml();

        Object o = yaml.load(ReadProp.class.getResourceAsStream("/mapping.yml"));
        // o 类型为linkedhashmap
        LinkedHashMap<String, LinkedHashMap<String, String>> map
                = (LinkedHashMap<String, LinkedHashMap<String, String>>)o;
        return map.get("mysqlTojava");
    }


    @Data
    public static class JdbcProp {
        private String url;
        private String username;
        private String password;
        private JdbcProp(){}

        public static JdbcProp initFromProp(Properties p){
            JdbcProp prop = new JdbcProp();
            String url = p.getProperty("url");
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            Preconditions.checkNotNull(url, "jdbc.properties url不能为空");
            Preconditions.checkNotNull(url, "jdbc.properties username不能为空");
            Preconditions.checkNotNull(url, "jdbc.properties password不能为空");

            prop.setPassword(password);
            prop.setUsername(username);
            prop.setUrl(url);
            return prop;
        }
    }

    @Data
    public static class ConfigProp{
        private String basepath;
        private String mapperpath;
        private String controllerpath;
        private String servicepath;
        private String serviceImplpath;
        private String daopath;
        private String domainpath;
        private String jsppath;

        private ConfigProp(){}

        public static ConfigProp loadFromProp(Properties p) {
            ConfigProp prop = new ConfigProp();
            prop.basepath = p.getProperty("basepath");
            prop.mapperpath = p.getProperty("mapperpath");
            prop.controllerpath = p.getProperty("controllerpath");
            prop.servicepath = p.getProperty("servicepath");
            prop.daopath = p.getProperty("daopath");
            prop.domainpath = p.getProperty("domainpath");
            prop.jsppath = p.getProperty("jsppath");
            prop.serviceImplpath = p.getProperty("serviceImplpath");
            return prop;

        }
    }


    private static Properties commonRead(String name){
        InputStream is = ReadProp.class.getResourceAsStream(name);
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

}
