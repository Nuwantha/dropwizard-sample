package hms.techtalks.dropwizard;


import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import hms.techtalks.dropwizard.error.CustomExceptionErrorMapper;
import hms.techtalks.dropwizard.formatters.LinkSerializer;
import hms.techtalks.dropwizard.resources.UserStoreApiResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;

import javax.ws.rs.core.Link;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;


public class UserStoreServerApp extends Application<ServerConfig> {

    private UserStoreApiResource apiResource;

    public void init() throws Exception {
        String[] cmdArgs = new String[]{"server", "/home/sandarenu/projects/drop-wizard-template/dropwizard-sample/src/main/resources/server-config.yml"};
        run(cmdArgs);
    }

    @Override
    public void initialize(Bootstrap<ServerConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ServerConfig config, Environment env) {

        env.jersey().register(apiResource);

        env.jersey().getResourceConfig()
                .packages(getClass().getPackage().getName())
                .register(DeclarativeLinkingFeature.class)
                .register(CustomExceptionErrorMapper.class);

        SimpleModule customSerializers = new SimpleModule();
        customSerializers.addSerializer(BigDecimal.class, new ToStringSerializer());
        customSerializers.addSerializer(Link.class, new LinkSerializer());
        env.getObjectMapper().registerModule(customSerializers);
        env.getObjectMapper().setDateFormat(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));

    }

    public void setApiResource(UserStoreApiResource apiResource) {
        this.apiResource = apiResource;
    }

}


