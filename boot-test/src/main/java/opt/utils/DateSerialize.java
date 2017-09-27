package opt.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class DateSerialize extends JsonSerializer<LocalDateTime> {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";


    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String date = value.format(DateTimeFormatter.ofPattern(pattern));
        gen.writeString(date);
    }
}
