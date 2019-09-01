<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>

<!-- 测试 转发 重定向 的路径 -->

<%-- <jsp:forward page="/index.jsp"></jsp:forward> --%>

<%--
// java 注释
    response.sendRedirect("https://github.com/login/oauth/authorize?client_id=e3f32b268e0d406e7f60&redirect_uri=http://47.106.95.111:8888/webapp/Login");
--%>

<a href="https://github.com/login/oauth/authorize?client_id=e3f32b268e0d406e7f60&redirect_uri=http://47.106.95.111:8888/webapp/Login">授权GitHub登录</a>

</body>
</html>
