package opt.config;

import opt.handlers.DateHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/18.
 */
@Configuration
public class MybatisConfig {

    @Resource
    DataSource pool;

    @Value("${mybatis.mappingLocation}")
    private String mappingLocation;

    @Value("${mybatis.handlers}")
    private String handlers;


    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(pool);
        bean.setMapperLocations(resolver.getResources(mappingLocation));
        TypeHandler[] ts = new TypeHandler[1];
        ts[0] = new DateHandler();
        bean.setTypeHandlers(ts);


        bean.setTypeHandlersPackage("opt.handlers.*");

        return bean.getObject();
    }



}
