<%@ page import="java.sql.Statement" %>
<%@ page import=" java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%> 
<html> 
<head> <title>图书管理系统</title> </head>
<body> 
<center><a href=addbook.jsp>增加图书信息</a></center><p> 
<table align=center width=500 border=1> 
<tr><td>书名<td>作者<td>价格<td>管理 
<jsp:useBean id="db" class="model.DBBean" scope="page"/> 
<%
String s="select * from bookinfo"; 
ResultSet rs=db.executeQuery(s); 
while(rs.next()) 
{
	int id=rs.getInt(1); 
	out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td><a href='delbook.jsp?id="+id+"'>删除</a>&nbsp;<a href='editbook.jsp?id="+id+"'>修改</a></td></tr>"); 
	}
rs.close(); 
db.close(); 
%>
</table> 
</body> 
</html>