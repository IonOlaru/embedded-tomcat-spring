import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @author Ion Olaru
 *         Date: 2014/02/07 - 22:53
 */
public class TomcatMain {
    public static void main(String[] args) throws ServletException, LifecycleException {
        String webAppDirLocation = "./src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());
        System.out.println("Configuring app with basedir: " + new File("./" + webAppDirLocation).getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}
