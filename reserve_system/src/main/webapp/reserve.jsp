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
			
			<form action="login" method="post">
			<div class="form_table">
				<table width="400" height="50" border="2">
					<tr>
						<td width="250">
							<div class="form_div">
								Eメール：<input type="text" name="email"><br>
								パスワード：<input type="password" name="password"><br>
							</div>
						</td>
						<td><input class = main_sub type="submit" value="ログイン"></td>
					</tr>
				</table>
			</div>
				
			</form>
		</main>
		
		<footer></footer>
		
	
	</body>
	
</html>