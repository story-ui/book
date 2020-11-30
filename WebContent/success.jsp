<%@ page  pageEncoding="UTF-8"%>
<html>
   <head><title>显示结果页面</title></head>  
   <body> 
    <%=request.getAttribute("outputMessage") %>
<form action="success.action" method="post">
<table>
<tr><td align="center"><input type="button" onclick="javascript:window.location.href='index.jsp'" value="图书管理" />
</table>
 </form>
   </body>
</html>
