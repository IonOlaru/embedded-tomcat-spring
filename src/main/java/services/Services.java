package services;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ion Olaru
 *         Date: 2014/02/10 - 22:00
 */
public class Services {
    private static ConfigurableApplicationContext ctx;

    public static void init() {
        System.out.println("Initializing Spring context...");
        ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        // ctx.registerShutdownHook();
        System.out.println("Spring context initialized.");
    }

    public static TMService getTMService() {
        return ctx.getBean(TMService.class);
    }

    public static void shutDown() {
        System.out.println("Closing Spring context...");
        ctx.close();
        System.out.println("Spring context closed.");
    }
}
