package opt.dao.handlers;

import opt.core.enums.Status;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/26.
 */
public class StatusHandler extends BaseTypeHandler<Status> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Status parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getA());
    }

    @Override
    public Status getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int a = rs.getInt(columnName);
        return Arrays.stream(Status.values()).filter(b -> b.getA() == a).findFirst().orElse(null);
    }

    @Override
    public Status getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int a = rs.getInt(columnIndex);
        return Arrays.stream(Status.values()).filter(b -> b.getA() == a).findFirst().orElse(null);
    }

    @Override
    public Status getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int a = cs.getInt(columnIndex);
        return Arrays.stream(Status.values()).filter(b -> b.getA() == a).findFirst().orElse(null);
    }
}
