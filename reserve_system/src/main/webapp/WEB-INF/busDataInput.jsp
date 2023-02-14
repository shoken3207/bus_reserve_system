<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String) session.getAttribute("result");
	String data = (String) session.getAttribute("data");
	if (data == null) data = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>バスデータ入力</title>
<link rel="stylesheet" href="css/insert.css">
<link rel="icon" href="img/ico.png">
</head>
<body>
	<div class="error">
	<%--
		<p class="errorMessage"><%= result %></p>
	--%>
	</div>
	<form action="upload" method="POST">
		<div class="inputText">
			<textarea class="data" name="data" placeholder="write json"><%= data %></textarea>
		</div>
		<input type="submit" value="送信">
	</form>
</body>
</html>