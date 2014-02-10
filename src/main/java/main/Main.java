package main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.TMService;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @author Ion Olaru
 *         Date: 2014/02/07 - 22:53
 */
public class Main {

    private static ApplicationContext ctx;
    private static TMService tmService;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.init();
        m.loadBeans();
        m.startTomcat();
    }

    public void init() {
        System.out.println("Initializing...");
        ctx = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
    }

    public void loadBeans() {
        tmService = ctx.getBean(TMService.class);
    }

    public void run() {
        tmService.loadAll();
    }

    public void startTomcat() throws ServletException, LifecycleException {
        String webAppDirLocation = "./src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());
        System.out.println("Configuring app with basedir: " + new File("./" + webAppDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }

    public static TMService getTMService() {
        return tmService;
    }
}
