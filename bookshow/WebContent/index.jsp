<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSP学习</title>
  </head>
  <body>
     <script type="text/javascript">
  		window.location = "<%=path%>/authorServlet?method=getAuthorList";
  	</script>
  </body>
</html>
