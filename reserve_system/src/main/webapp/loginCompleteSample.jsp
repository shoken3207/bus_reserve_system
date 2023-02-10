<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.UserBean" %>
<%
	UserBean user = (UserBean) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="img/ico.png">
</head>
<body>
	こんにちは、<%= user.getName() %>さん。
</body>
</html>