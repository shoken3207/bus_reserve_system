<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.UserBean" %>

<%
	UserBean loginUser = (UserBean) session.getAttribute("user");
%>    

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>ログイン結果</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css" >
		<link rel="icon" href="img/ico.png">
	</head>
	
	<body>
	
		<div class = "h1_div_out">
			<div class = "h1_div_into">
				<h1>ログイン結果表示画面</h1>
			</div>
		</div>
		
		<% if(loginUser != null) { %>
			<p>ログイン成功</p>
			<p>ようこそ<%= loginUser.getName() %>さん</p>
		<% } else { %>
			<p>ログイン失敗</p>
			<a href="/Ex_bus/">TOPへ</a>
		<% } %>

	</body>
	
</html>