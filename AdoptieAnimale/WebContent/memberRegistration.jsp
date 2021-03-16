<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inregistrare</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="Register" method="post">
		<div class="login-box">
			<h1>Register</h1>
			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text" name="nume"
					placeholder="Nume">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text" name="prenume"
					placeholder="Prenume">
			</div>
			<div class="textbox">
				<i class="fas fa-user"></i> <input type="text" name="username"
					placeholder="Username">
			</div>

			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="password" name="password"
					placeholder="Parola">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text" name="adresa"
					placeholder="Adresa">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text" name="email"
					placeholder="Email">
			</div>
			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text" name="telefon"
					placeholder="Telefon">
			</div>

			<table>
				<tr>
					<td>Tip utilizator:</td>
					<td><input type="radio" name="tip" value="furnizor">
						Furnizor <input type="radio" name="tip" value="client">
						Client</td>
				</tr>
			</table>
			<input type="submit" class="btn" value="register">

		</div>
	</form>
</body>
</html>