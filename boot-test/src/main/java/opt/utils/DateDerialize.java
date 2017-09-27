package opt.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class DateDerialize extends JsonDeserializer<LocalDateTime> {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";


    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String date = p.getValueAsString();
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));

    }
}
