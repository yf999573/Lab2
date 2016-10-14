<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="Action.showbook"%>
<%@ page import="library.book"%>
<%@ page import="library.author" %>
<%@ page import="library.all" %>
<%@ page import="utill.DBHelper" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
</head>
<body>
    <table align="center" width="600" border="1">
		<tr>
			<td align="center" colspan="9">
				<h1>图书详细信息展示</h1>
			</td>
		</tr>
		<tr align="center">
			<td><b>ISBN</b></td>
			<td><b>Title</b></td>
			<td><b>Publisher</b></td>
			<td><b>PublishDate</b></td>
			<td><b>Price</b></td>
			<td><b>Name</b></td>
			<td><b>Age</b></td>
			<td><b>Country</b></td>
			<td><b>Operate</b></td>
		</tr>
		<s:iterator value="#request.list" var="all">
		<tr align="center">
			<td><s:property value="#all.ISBN"></s:property></td>
			<td><s:property value="#all.Title"></s:property></td>
			<td><s:property value="#all.Publisher"></s:property></td>
			<td><s:property value="#all.PublishDate"></s:property></td>
			<td><s:property value="#all.Price"></s:property></td>
			<td><s:property value="#all.Name"></s:property></td>
			<td><s:property value="#all.Age"></s:property></td>
			<td><s:property value="#all.Country"></s:property></td>
			<td>
			    <a href="<s:url action="deletebook.action">
			    <s:param name="ISBN" value="#all.ISBN"/>
			    </s:url>">删除</a>
			</td>
		</tr>
		</s:iterator>
	</table>   
</body>
</html>