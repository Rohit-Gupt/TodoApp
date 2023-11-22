<%@page import="com.mydata.dao.TodoDalmpl"%>
<%@page import="com.mydata.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String t = request.getParameter("title");
TodoDao td = new TodoDalmpl();
String res = td.deleteTodo(t);
if(res!=null){
%>
<jsp:forward page="TodoList.jsp"></jsp:forward>
<%
}
  else
  {
%>
<jsp:include page="TodoList.jsp"></jsp:include>
<%} %>
</body>
</html>
