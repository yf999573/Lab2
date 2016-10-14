<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
<head>
<style type="text/css">
    *{
        margin:auto;
        padding: 0;
    }
    .search{
        margin:auto;
		margin-top:150px;
        width: 520px;
        height:50px;
        border:1px solid silver ;
    }
    .search_key{
        width: 440px;
        height: 44px;
        border: none;
        margin-top: 3px; 
        margin-left: 5px;     
    }
    .submit_posi{
	    position:relative;
        right:450px 
    }
	.submit_css{
	    width:58px;
        height: 40px;
	}
	.tablecss{
	    magin:auto;
		margin-top:100px
	}
    </style>
</head>
<body>
<table class="tablecss" align="center" width="300px" border="1">
		<tr>
			<td align="center">
				<h1>图书搜索界面</h1>
			</td>
		</tr>
</table>
<form action="/library/showtitle.action" method="post">
    <div class="search">
        <input name="Name" type="text" class="search_key" value="输入作者名搜索" />
        <input type="submit" class="submit_css" class="submit_posi" value="查询">
    </div>
</form>
</body>
</html>