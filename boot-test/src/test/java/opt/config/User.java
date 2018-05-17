package opt.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import opt.core.serialize.DateDerialize;
import opt.core.serialize.DateSerialize;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/12/26.
 */
@Data
public class User {


    private Long id;
    private String username;
    private String mobile;
    private String email;
    private String login_name;
    private String password;
    private String pic;

    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime create_date;
    private LocalDateTime modify_date;
    private LocalDateTime last_login__date;

    private Integer status;

    private Integer version;

}
