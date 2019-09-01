package maven.webapp.badboyh2o.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener1
 *
 */
@WebListener
public class SessionListener1 implements HttpSessionListener {

    public SessionListener1() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println(" session create");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println(" session desdroy");
    }
	
}
