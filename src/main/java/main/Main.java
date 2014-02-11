package main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.log4j.BasicConfigurator;
import services.Services;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @author Ion Olaru
 *         Date: 2014/02/07 - 22:53
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        BasicConfigurator.configure();
        Services.init();
        addShutDownHook();
        m.startTomcat();
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

    public static void addShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Shutting down...");
                Services.shutDown();
            }
        });
    }

}
