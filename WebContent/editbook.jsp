<%@ page import="java.sql.*" pageEncoding="gb2312" errorPage="error.jsp"%> 
<html> 
<head> 
<title>�޸�ͼ����Ϣ</title> 
</head> <body> 
<jsp:useBean id="db" class="model.DBBean" scope="page"/> 
<%
request.setCharacterEncoding("gb2312"); 
String id=request.getParameter("id"); 
ResultSet rs=db.executeQuery("select * from bookinfo where id="+id); 
rs.next(); 
%>
<form action="update.jsp" method="post"> 
<table width="50%" border="1" align="center"> 
<CAPTION>�޸�ͼ����Ϣ</CAPTION> 
<tr> 
<th width="30%">������</th> 
<td width="70%"> 
<input name="bookname" type="text" value="<%=rs.getString(2)%>"></td> 
</tr>
<tr><th>���ߣ�</th> 
<td><input name="author" type="text" value="<%=rs.getString(3)%>"></td> 
</tr> <tr><th>�۸�</th> 
<td><input name="price" type="text" value="<%=rs.getString(4)%>">Ԫ</td>
</tr> <tr><th colspan="2"> 
<input type="hidden" name="id" value="<%=id%>"> 
<input type="submit" value="�޸�"> 
<input type="reset" value="����"> 
</th> 
</tr> 
</table> 
</form> 
<%db.close(); %> 
</body> 
</html>