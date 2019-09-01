package maven.webapp.badboyh2o.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 测试 /conf/context.xml jndi
	    // <Environment name="testjndiname" value="123" type="java.lang.String" />
	    try {
            Context c = new InitialContext();
            System.out.println(c.lookup("java:comp/env/testjndiname"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
	    
	    
	    
	    //测试 getContextPath
	    System.out.println(request.getContextPath());
	    
	    // 测试 转发、重定向 路径
	    //response.sendRedirect(request.getContextPath()+"/TestServlet/Test");
	    request.getRequestDispatcher("/TestServlet/Test").forward(request, response);
	    

	    //request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	    //response.sendRedirect("/webapp-servlet/jsp/index.jsp");
	    
	    
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
