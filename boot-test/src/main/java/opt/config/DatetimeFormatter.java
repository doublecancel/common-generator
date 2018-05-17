package opt.config;

import com.google.common.collect.Sets;
import opt.core.annotation.LocalDate;
import opt.entity.TestFormatUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

@Configuration
public class DatetimeFormatter extends WebMvcConfigurerAdapter{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MyFormatter());
        registry.addFormatterForFieldAnnotation(new AnnotationFormatterFactory<LocalDate>() {
            @Override
            public Set<Class<?>> getFieldTypes() {
                return Sets.newHashSet(String.class);
            }

            @Override
            public Printer<?> getPrinter( LocalDate annotation, Class<?> fieldType) {
                String pattern = annotation.pattern();
                return null;
            }

            @Override
            public Parser<?> getParser(LocalDate annotation, Class<?> fieldType) {
                return null;
            }
        });
    }

    public static class MyFormatter implements Formatter<LocalDateTime>{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        @Override
        public  LocalDateTime parse(String text, Locale locale) throws ParseException {
            return LocalDateTime.parse(text, formatter);
        }

        @Override
        public String   print( LocalDateTime  object, Locale locale) {
            return object.format(formatter);
        }
    }
}
