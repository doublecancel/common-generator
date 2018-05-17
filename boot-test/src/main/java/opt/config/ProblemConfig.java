package opt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

/**
 * Created by Administrator on 2017/12/26.
 */
@Configuration
public class ProblemConfig {


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper()
                .registerModule(new ProblemModule())
                .registerModule(new ConstraintViolationProblemModule());
    }

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//        return  new MappingJackson2HttpMessageConverter(objectMapper());
//    }


}
