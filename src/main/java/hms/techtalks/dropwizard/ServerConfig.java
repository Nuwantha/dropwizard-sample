package hms.techtalks.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServerConfig extends Configuration {

    @NotEmpty
    @JsonProperty
    private String version;

    public String getVersion() {
        return version;
    }
}
