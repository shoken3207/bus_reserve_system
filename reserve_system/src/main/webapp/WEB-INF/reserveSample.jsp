<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] startList = (String[]) request.getAttribute("startList");
	String[] endList   = (String[]) request.getAttribute("endList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	startList: 
	<% for (String str: startList) { %>
		<%= str %>
	<% } %>
	<br>
	endList: 
	<% for (String str: endList) { %>
		<%= str %>
	<% } %>
</body>
</html>