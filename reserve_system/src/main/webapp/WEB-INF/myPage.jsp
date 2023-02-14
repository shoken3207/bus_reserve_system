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
<title>マイページ</title>
<link rel="stylesheet" href="css/myPage.css">
<link rel="icon" href="img/ico.png">
</head>
<body>
	<div class="container">
      <div class="header">
        <div class="logo">My Page</div>
      </div>
      <ul class="info">
        <li>名前: <%=user.getName() %></li>
        <li>電話番号: <%=user.getPhone() %></li>
        <li>Eメール: <%= user.getEmail() %></li>
      </ul>
      <div class="btn-group">
        <a href="/reserve_system/ResreveServlet" class="btn reserve">予約</a>
        <a href="/reserve_system/ReserveListServlet" class="btn reserved">予約したバス一覧</a>
        <a href="/reserve_system/editUser" class="btn profile">プロフィール編集</a>
        <a href="/reserve_system/logout" class="btn logout">ログアウト</a>
      </div>
    </div>
</body>
</html>