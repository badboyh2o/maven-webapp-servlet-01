<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>


<!-- 测试 转发 重定向 的路径 -->

<%-- <jsp:forward page="/index.jsp"></jsp:forward> --%>

<%
// java 注释
    response.sendRedirect(request.getContextPath()+"/index.jsp");
%>>

</body>
</html>
