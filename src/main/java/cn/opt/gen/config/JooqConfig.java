package cn.opt.gen.config;

import cn.opt.gen.utils.ReadProp;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/9/20.
 */
public class JooqConfig {


    private static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    ReadProp.jdbcProp.getUrl(),
                    ReadProp.jdbcProp.getUsername(),
                    ReadProp.jdbcProp.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DSLContext getContext(){
        DSLContext context = DSL.using(getConnection(), SQLDialect.MYSQL);
        return context;
    }



}
