package opt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

/**
 * Created by Administrator on 2017/9/21.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class App {


    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }







}
