<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = (String) request.getAttribute("email");
	email = email != null ? email : "";
%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login_expand.css" >
		<link rel="icon" href="img/ico.png">
		<title>ログイン</title>
	</head>
	<body>
		<main>
			<div class="form_div">
				<div class = "h1_div_out">
					<div class = "h1_div_into">
						<h1>Ex<span class="under_ber">_</span>BUS</h1>
					</div>
				</div>

				<form  action="login" method="post">
					<p class="form_in_p">E-mail Address <span class="ast">*</span></p><br>
					<input class="text_inp" placeholder="E-mail" type="text" name="email" value="<%= email %>" required/><br><br>

					<p class="form_in_p">Password <span class="ast">*</span></p><br>
					<input class="text_inp" placeholder="Password" type="password" name="password" required/><br>

					<input class="main_sub" type="submit" value="LOGIN">

				</form>
			</div>
		</main>
	</body>
</html>