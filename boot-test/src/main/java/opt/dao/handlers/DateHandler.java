package opt.dao.handlers;

import opt.utils.OptLocalDateTime;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class DateHandler extends BaseTypeHandler<OptLocalDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OptLocalDateTime parameter, JdbcType jdbcType) throws SQLException {

        ps.setObject(i, parameter);
    }

    @Override
    public OptLocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {

        Timestamp date = rs.getTimestamp(columnName);
        if(date == null) return null;

        return OptLocalDateTime.create(date.toLocalDateTime());
    }

    @Override
    public OptLocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        Timestamp date = rs.getTimestamp(columnIndex);
        if(date == null) return null;

        return OptLocalDateTime.create(date.toLocalDateTime());
    }

    @Override
    public OptLocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        Timestamp date = cs.getTimestamp(columnIndex);
        if(date == null) return null;
        return OptLocalDateTime.create(date.toLocalDateTime());
    }
}
