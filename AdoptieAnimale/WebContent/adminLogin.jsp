<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>


<form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="admin-login-form">
	 
	 		<div class="login-box">
			<h1>Admin Login</h1>
			<div class="textbox">
				<i class="fas fa-user-cog"></i> <input type="text" name="username" placeholder="Username">
			</div>

			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="password" name="password" placeholder="Password">
			</div>

		<button type="submit" name="login" class="btn">Log in</button>
		
		</div>
	 </form>
</body>
</html>