<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="library.all" %>
<%@ page import="Action.showtitle" %>
<%@ page import="library.book"%>
<%@ page import="library.author" %>
<%@ page import="utill.DBHelper" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
</head>
<body>
    <table align="center" width="300" border="1">
		<tr>
			<td align="center" colspan="1">
				<h4>查询到的该作者相关书籍</h4>
			</td>
		</tr>
		<tr align="center">
			<td><b>Author:<s:property value="Name"/></b></td>
		</tr>
		<s:iterator value="#request.list" var="item">
			<tr align="center">
			<td>
			    <a href="<s:url action="showbook.action">
			    <s:param name="Title" value="#item"/>
			    </s:url>">
			    <s:property value="item"/>
			    </a>
			</td>
		    </tr>
		</s:iterator>
	</table>   
</body>
</html>