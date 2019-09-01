package maven.webapp.badboyh2o.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听 作用域对象的生命周期
 *
 */

// 监听器注解

/*
 * web.xml
 * 
 *  <listener>
        <listener-class>maven.webapp.badboyh2o.listener.TestListener1</listener-class>
    </listener>
 *
 */

@WebListener
public class RequestListener1 implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener1() {
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("request desdroyed");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("request create");
    }
	
}
