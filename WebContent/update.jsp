<%@ page language="java" contentType="text/html; charset=gb2312" import="java.sql.*" errorPage="error.jsp"%> 
<html> 
<head> 
<title>修改完成</title> 
</head> 
<body> 
<jsp:useBean id="db" class="model.DBBean" scope="page"/> 
<%request.setCharacterEncoding("gb2312"); 
String bookname=request.getParameter("bookname"); 
String author=request.getParameter("author"); 
String price=request.getParameter("price"); 
String id=request.getParameter("id"); 
String sql="update bookinfo set bookname='"+bookname+"',author='"+author+"',price="+price+" where id="+id; 
int i=db.executeUpdate(sql); 
if(i==1) 
{
	out.println("<script language='javaScript'> alert('修改成功，点击确定后自动跳 到主页。');</script>"); 
	response.setHeader("refresh","1;url=index.jsp");
} 
db.close(); 
%> 
</body> 
</html>