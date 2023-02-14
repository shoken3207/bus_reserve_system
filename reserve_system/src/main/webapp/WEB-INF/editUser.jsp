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
<title>ユーザー情報編集</title>
<link rel="stylesheet" href="css/register.css">
</head>
<body>
	<div class="container">
		<form action="editUser" method="post" class="form">
			<h1>ユーザー情報編集</h1>
			<div class="inputWrapper">
				<div class="inputArea">
					<label for="username">名前</label>
					<input value="<%= user.getName() %>" name="name" id="username" placeholder="名前を入力してください" required />
				</div>
				<div class="inputArea">
					<label for="phone">電話番号</label>
					<input type="tel" value="<%= user.getPhone() %>"
					pattern="[0-9]{6,11}" name="phone" id="phone" placeholder="電話番号を入力してください" required />
				</div>
				<div class="inputArea">
					<label for="email">メールアドレス</label>
					<input value="<%= user.getEmail() %>" name="email" type="email" id="email" placeholder="メールアドレスを入力してください"  required/>
				</div>
			</div>
			<input class="submitBtn" type="submit">
		</form>
	</div>
</body>
</html>