package opt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2017/9/19.
 */
@ConfigurationProperties(prefix = "datasource")
@Data
public class DataSourceProp {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

}
