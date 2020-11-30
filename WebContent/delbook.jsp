<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*"%> 
<html> 
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
<head> 
<title>删除图书</title>
</head> 
<body> 
<jsp:useBean id="db" class="model.DBBean" scope="page"/> 
<%request.setCharacterEncoding("gb2312"); 
String id=request.getParameter("id");
int i=db.executeUpdate("delete from bookinfo where id="+id); 
if(i==1) 
{
	out.println("<script language='javaScript'> alert('删除成功，点击确定后自 动跳到主页！');</script>");
	response.setHeader("refresh","1;url=index.jsp"); 
	}else{ 
		out.println("<script language='javaScript'> alert('删除失败，点击确定后自动 跳到主页！');</script>"); 
		response.setHeader("refresh","1;url=delbook.jsp");
		} 
db.close();
%> 
</body> 
</html>