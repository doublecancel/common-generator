package opt.dao.interceptors;

import opt.dao.Page;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/10/24.
 * 分页插件
 */


@Intercepts({
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class})
})
public class PageInterceptor implements Interceptor {

    private static String c_sql = "select count(*) from (%s) count_temp ";
    private static String l_sql = "%s limit %s, %s ";


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) getReadObject(invocation.getTarget());
        MetaObject data = SystemMetaObject.forObject(statementHandler);

        Object[] os = invocation.getArgs();

        MappedStatement mst = (MappedStatement) data.getValue("delegate.mappedStatement");

        if (noPage(mst)) {
            return invocation.proceed();
        }

        CachingExecutor executor = (CachingExecutor) data.getValue("delegate.executor");
        BoundSql boundSql = (BoundSql) data.getValue("boundSql");
        DefaultParameterHandler dph = (DefaultParameterHandler) data.getValue("parameterHandler");
        Connection connection = (Connection) os[0];
        Page page = initPage(executeCountSql(connection, dph, String.format(c_sql, boundSql.getSql())));
        String limitSql = String.format(l_sql, boundSql.getSql(), getStart(page), page.getRowNum());

        //--------------------------------------------------------
        data.setValue("delegate.boundSql.sql", limitSql);
        data.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
        data.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

        return invocation.proceed();
    }

    private int getStart(Page page){
        int b = page.getRowNum();
        int a = page.getCurrentPage();
        int start = (a - 1) * b;
        return start;
    }

    private Page initPage(Integer count){
        Page page = LocalPage.get();
        page.setTotalCount(count.longValue());
        int totalPage = count % page.getRowNum() == 0 ? count / page.getRowNum() : count / page.getRowNum() + 1;
        page.setTotalPage(totalPage);
        return page;
    }

    private Integer executeCountSql(Connection connection,
                                    DefaultParameterHandler dph,
                                    String sql) {
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            dph.setParameters(ps);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                result = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean noPage(MappedStatement mst) {
        return !mst.getSqlCommandType().equals(SqlCommandType.SELECT) || LocalPage.get() == null;
    }

    private Object getReadObject(Object obj) {
        if (Proxy.isProxyClass(obj.getClass())) {
            MetaObject object = SystemMetaObject.forObject(obj);
            return getReadObject(object);
        }
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
