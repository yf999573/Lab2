<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript">
    	function checkValid(){
    		var AuthorID = document.getElementById('AuthorID').value;
    		var name = document.getElementById('Name').value;
    		var Country = document.getElementById('Country').value;
    		var age = document.getElementById('age').value;
    		
    		if(AuthorID==''){
    			alert('请输入作者id！');
    		}else if(name==''){
    			alert('请输入姓名！');
    		}else if(Country==''){
    			alert('请输入国籍！');
    		}else if(age==''){
    			alert('请输入年龄！');
    		}else{
    			document.sform.submit();
    		}
    	}
    
    </script>
  </head>
  
  <body>
    <div align="center">增加新作者信息：</div><br/>
    <div align="center">
    	<form action="<%=path%>/authorServlet?method=saveAuthor" method="post" name="sform">
	    	<table border="1">
	    		<tr>
	    			<td>ID</td>
	    			<td><input type="text" name="AuthorID" id="AuthorID" maxlength="10"/></td>
	    		</tr>
	    		<tr>
	    			<td>姓名</td>
	    			<td><input type="text" name="name" id="Name" maxlength="20"/></td>
	    		</tr>
	    		<tr>
	    			<td>国籍</td>
	    			<td>
	    				
	    				<input type="text" name="Country" id="Country" maxlength="10"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>年龄</td>
	    			<td><input type="text" name="age" id="age" maxlength="3" onkeyup="value=value.replace(/[^\d]/g,'')"/></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2"><input type="button" value="提交" onclick="checkValid();"/></td>
	    		</tr>
	    	</table>
    	</form>
    </div>
  </body>
</html>
