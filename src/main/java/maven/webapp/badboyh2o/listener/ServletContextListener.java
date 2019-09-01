package maven.webapp.badboyh2o.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListener
 *
 */
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {

    public ServletContextListener() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("servlet context desrtoy");
    }

    public void contextInitialized(ServletContextEvent sce)  {
        System.out.println("servlet context create");
    }
	
}
