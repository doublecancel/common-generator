package opt.dao.handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class DateHandler2 extends BaseTypeHandler<LocalDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {

        ps.setTimestamp(i, Timestamp.valueOf(parameter));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {

        Timestamp date = rs.getTimestamp(columnName);
        if(date == null) return null;

        return date.toLocalDateTime();
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        Timestamp date = rs.getTimestamp(columnIndex);
        if(date == null) return null;

        return date.toLocalDateTime();
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        Timestamp date = cs.getTimestamp(columnIndex);
        if(date == null) return null;
        return date.toLocalDateTime();
    }
}
