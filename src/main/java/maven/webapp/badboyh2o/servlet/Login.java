package maven.webapp.badboyh2o.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试 github授权登录 (授权码模式)
 * 
 * 1.用户登录，访问 /login.jsp; 
 * 2.login.jsp自动向github申请code;得到code后 github告诉浏览器要做一个重定向去获取token (code也写到重定向url了);
 * 2.浏览器开始重定向（这个地址是当前这个app的一个地址）;
 * 3.app后台接收到这个请求，取出query参数code, 还有配置文件的 client_secret client_id ；封装成json参数，向github申请token
 * 4.app后台把token写入到session(或者把token写入到response, 这样浏览器就可以拿到token);然后重定向到index.jsp
 * 
 * 
 * 
 * 
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        // 1.打印query code 参数
        String code = request.getParameter("code");
        System.out.println(code);
        
        
        // 服务端地址
        URL url = new URL("https://github.com/login/oauth/access_token");
        // 设定连接的相关参数
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);//允许读入
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.connect();
        
        // 2.向授权服务发送json参数
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        out.write("{\"client_id\": \"e3f32b268e0d406e7f60\",\"client_secret\": \"41aa9bfec7a79c78362353a25034ef2cb760c6c7\",\"code\": \"" + code + "\"}");
        out.flush();
        out.close();

        // 3.获取服务端的响应的token
        String strLine="";
        String strResponse ="";
        InputStream in =connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while((strLine =reader.readLine()) != null) {
            strResponse +=strLine +"\n";
        }
        System.out.print(strResponse);
        
        // 关闭连接
        connection.disconnect();
        
        
        // 将结果设置到 session
        HttpSession session = request.getSession();
        session.setAttribute("token", strResponse);
        
        // 4.转发到首页
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

}
