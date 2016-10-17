<%@ page language="java" import="java.util.*,
" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript">
    		function updateData(id){
    			window.location = '<%=path%>/authorServlet?method=toEdit&id='+id;
    		}
    		
    		function deleteData(id){
    			window.location = '<%=path%>/authorServlet?method=deleteAuthor&id='+id;
    		}
    		
    		function addData(){
    		    window.location = '<%=path%>/authorServlet?method=toAdd';
    		}
    
    </script>
  </head>
  
  <body>
    <div align="center">列表如下：</div><br/>
    <div align="center"><input type="button" value="新增" onclick="addData();"/></div><br/>
    <table align="center" border="1">
    	<thead style="background-color:green;">
    		<tr>
    		    <td>序号</td>
    			<td>id</td>
    			<td>姓名</td>
    			<td>国籍</td>
    			<td>年龄</td>
    			<td>操作</td>
    		</tr>
    	</thead>
    	<tbody>
    		<%
    			List<Author> stuList = (List<Author>)request.getAttribute("authorList");
    			if(stuList!=null &&stuList.size()>0){
    				for(int i=0;i<stuList.size();i++){
    					Author s = stuList.get(i);
   
    		 %>
    		 		<tr>
    		 			<td><%=i+1 %></td>
    		 			<td><%=s.getAuthorID()%></td>
    		 			<td><%=s.getName() %></td>
    		 			<td><%=s.getCountry%></td>
    		 			<td><%=s.getAge()%></td>
    		 			<td><input type="button" value="修改" onclick="updateData('<%=s.getId()%>')"/><input type="button" value="删除" onclick="deleteData('<%=s.getId()%>')"/></td>
    		 		</tr>
    		 <%}} %>
    	</tbody>
    </table>
  </body>
</html>
