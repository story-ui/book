<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*"%> 
<html> 
<head> 
<title>���ͼ����Ϣ</title> 
</head> 
<body> 
<form action="addbook.jsp" method="post"> 
<table width="50%" border="1" align="center"> 
<CAPTION>���ͼ����Ϣ</CAPTION> 
<tr><th width="30%">������</th> 
<td width="70%"><input name="bookname" type="text"></td> 
</tr> 
<tr>
<th>���ߣ�</th> 
<td>
<input name="author" type="text"></td> 
</tr> 
<tr>
<th>�۸�
</th> 
<td>
<input name="price" type="text">Ԫ</td>
</tr> 
<tr><th colspan="2"> 
<input type="submit" name="submit" value="���"> 
<input type="reset" value="����"> 
</th> 
</tr> 
</table> 
</form> 
<jsp:useBean id="db" class="model.DBBean" scope="page"/> 
<%request.setCharacterEncoding("gb2312"); 
String submit=request.getParameter("submit"); 
if(submit!=null&&!submit.equals("")) 
{ 
	String bookname=request.getParameter("bookname"); 
	String author=request.getParameter("author"); 
	String price=request.getParameter("price"); 
	String sql="insert into bookinfo(bookname,author,price) values('"+bookname+"','"+author+"',"+price+")"; 
	int i=db.executeUpdate(sql); 
	if(i==1) 
	{
		out.println("<script language='javaScript'> alert('��ӳɹ�,���ȷ����ת���� ҳ!');</script>"); 
		response.setHeader("refresh","1;url=index.jsp"); 
		}else{ 
			out.println("<script language='javaScript'> alert('���ʧ�ܣ����ȷ���������ҳ �棡');</script>"); 
			response.setHeader("refresh","1;url=addbook.jsp"); 
			}db.close(); 
			}
%>
</body> 
</html>