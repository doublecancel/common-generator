package opt.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class OptDateSerialize extends JsonSerializer<OptLocalDateTime> {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";


    @Override
    public void serialize(OptLocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        String date = value.getStart().format(DateTimeFormatter.ofPattern(pattern));
        gen.writeString(date);
    }
}
