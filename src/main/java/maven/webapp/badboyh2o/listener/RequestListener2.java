package maven.webapp.badboyh2o.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *  监听作用域中个属性变化 
 *
 */

@WebListener
public class RequestListener2 implements ServletRequestAttributeListener {

    public RequestListener2() {
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    }
	
}
