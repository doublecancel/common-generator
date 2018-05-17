package opt.core.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import opt.core.enums.Status;

import java.io.IOException;

/**
 * Created by Administrator on 2017/12/26.
 */
public class StatusSerialize extends JsonSerializer<Status> {
    @Override
    public void serialize(Status value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeNumber(value.getA());
    }
}
