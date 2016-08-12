package hms.techtalks.dropwizard.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserStoreServerAppStarter {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStoreServerAppStarter.class);
    private AbstractApplicationContext applicationContext;

    public static void main(String[] args) {
        new UserStoreServerAppStarter().start();
    }


    public void start() {
        applicationContext = new ClassPathXmlApplicationContext("server-spring-context.xml");
        applicationContext.registerShutdownHook();
        applicationContext.start();
    }


}
