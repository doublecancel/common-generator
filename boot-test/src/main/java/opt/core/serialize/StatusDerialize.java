package opt.core.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import opt.core.enums.Status;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/12/26.
 */
public class StatusDerialize extends JsonDeserializer<Status> {
    @Override
    public Status deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        int a = p.getValueAsInt();
        return Arrays.stream(Status.values()).filter(b -> b.getA() == a).findFirst().orElse(null);
    }
}
