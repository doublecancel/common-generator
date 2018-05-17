package opt.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/12/26.
 */
public class ObjectmapperTest {



    @Test
    public void testMapper() throws JsonProcessingException {

        User user = new User();
        user.setCreate_date(LocalDateTime.now());
        user.setEmail("liuxianglei@ucpaas.com");

        user.setUsername("liuxianglei");
        user.setId(20001L);
        user.setLast_login__date(LocalDateTime.now());

        user.setMobile("13120971538");
        user.setPassword("liuxianglei");

        user.setPic("/usr/local/pics/liuxianglei.pic");

        user.setStatus(1);
        user.setVersion(1);


        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String result  = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(result);



    }


}
