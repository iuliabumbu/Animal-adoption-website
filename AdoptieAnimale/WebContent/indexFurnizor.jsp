<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style3.css">
</head>
<body>
	<% 
   String uname=request.getParameter("username"); 
   
   session.setAttribute("username",uname); 
   %>

	<header>
		<h1><i class='fas fa-paw' style='font-size:48px;color:white'></i>  Adoptie de animale</h1>
		<nav>
			<ul>
				<li><a href="adaugaAnunt.jsp">Adauga anunt</a></li>
				<li><a href="anunturiFurnizor.jsp">Anunturile mele</a></li>
				<li><a href="contFurnizor.jsp">Contul meu</a></li>
				<li><a href="login.jsp">Logout</a></li>
			</ul>
			</ul>
		</nav>
	</header>


	<div class="container">
		<img src="logo.png" alt="Norway" style="width: 100%;">
		<div class="text-block">
			<p>WELCOME <%=(String)session.getAttribute("username")%></p>
		</div>
	</div>



	<footer>
		<div class="footer"><marquee direction="right" behavior="alternate">Portal pentru adoptii de animale: pentru modificari ale profilului contactati administratorul la adresa admin_adoptii@yahoo.com</marquee></div>
	</footer>

</body>
</html>