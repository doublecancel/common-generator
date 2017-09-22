package opt.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/9/19.
 */
@Configuration
@EnableConfigurationProperties({DataSourceProp.class})
public class DatasourceConfig {


    @Autowired
    DataSourceProp prop;

    @Bean
    public DataSource pool(){
        PooledDataSource pool = new PooledDataSource();
        pool.setDriver(prop.getDriverClassName());
        pool.setUrl(prop.getUrl());
        pool.setUsername(prop.getUsername());
        pool.setPassword(prop.getPassword());
        pool.setPoolMaximumActiveConnections(5);
        return pool;
    }


}
