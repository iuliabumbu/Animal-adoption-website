<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdoptiiAnimale </title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<form action="login" method="post">
		<div class="login-box">
			<h2>Adoptii de animale</h2>
			<h1>Login</h1>
			<div class="textbox">
				<i class="fas fa-user"></i> <input type="text" name="username" placeholder="Username">
			</div>

			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="password" name="password" placeholder="Password">
			</div>

			<input type="submit" class="btn" value="Submit">
			
			<p class="textbox">Not a member yet?
			   <a href="memberRegistration.jsp" >Join us</a>
			</p>
			
			<i class='fas fa-user-cog' style='font-size:36px'></i>
			<p class="textbox">Switch on admin account?			
			   <a href="adminLogin.jsp" >Yes</a>
			</p>
		</div>

	</form>

</body>
</html>