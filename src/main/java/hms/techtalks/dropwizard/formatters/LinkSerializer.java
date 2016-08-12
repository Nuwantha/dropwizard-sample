

package hms.techtalks.dropwizard.formatters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.ws.rs.core.Link;
import java.io.IOException;


public class LinkSerializer extends JsonSerializer<Link> {
    @Override
    public void serialize(Link value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("rel", value.getRel());
        gen.writeStringField("href", value.getUri().toString());
        if(value.getType() != null && !value.getType().isEmpty()) {
            gen.writeStringField("method", value.getType());
        }
        gen.writeEndObject();
    }
}
