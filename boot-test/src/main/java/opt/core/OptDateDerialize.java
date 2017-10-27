package opt.core;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.io.IOException;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class OptDateDerialize extends JsonDeserializer<OptLocalDateTime> {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";


    @Override
    public OptLocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String date = p.getValueAsString();
        if(!Strings.isNullOrEmpty(date)){
            return OptLocalDateTime.create(date);
        }
        JsonNode node = p.getCodec().readTree(p);
        JsonNode startNode = node.get("start");
        JsonNode endNode = node.get("end");
        Preconditions.checkNotNull(startNode, "start node must not be null");
        if(endNode == null){
            return OptLocalDateTime.create(startNode.asText());
        }
        return OptLocalDateTime.create(startNode.asText(), endNode.asText());

    }
}
