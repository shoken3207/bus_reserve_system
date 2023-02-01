<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" >
		
		<title>	TOP</title>
	</head>
	
	<body>
		
		<header>
		
			<div class = "h1_div_out">
				<div class = "h1_div_into">
					<h1>ログイン画面</h1>
				</div>
			</div>
			
		</header>
		
		<main>
		
			<form  action="login" method="post">
			  
			  <input placeholder="E-mail" type="text" name="email"/>
			  <input placeholder="Password" type="password" name="password"/>
			  <input class = main_sub type="submit" value="ログイン">
			  
			</form>

		</main>
		
		<footer></footer>
		
	
	</body>
	
</html>