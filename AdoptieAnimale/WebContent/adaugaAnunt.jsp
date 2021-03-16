<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style3.css">
</head>
<body>
<%   
  
String name=(String)session.getAttribute("username");  
session.setAttribute("username",name); 
  
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
	
	<div class="signup-header">
	 	
	 </div>

	 <form method="post" action="furnizor">
	 
	 <input type="hidden" name="page" value="adauga_anunt">
     
	 	<div class="signup-group">
	 		<label>Nume</label>
	 		<input type="text" name="nume" placeholder="Animal's Name"  required>
	 	</div>
	 	 	<div class="signup-group">
	 	 	<label> Proprietar</label>
	 		<label for="proprietar"><%=(String)session.getAttribute("username")%></label>
            <input type="hidden" value="<%=(String)session.getAttribute("username")%>" name="proprietar">
	 	</div>
	 	<div class="signup-group">
	 		<label>Tip</label>
	 		<input type="text" name="tip" placeholder="caine/pisica/papagal/hamster/peste" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Rasa</label>
	 		<input type="text" name="rasa" placeholder="breed" required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Varsta</label>
	 		<input type="text" name="varsta" placeholder="age" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Gen</label>
	 		<input type="text" name="gen" placeholder="mascul/femela" required>
	 	</div>
	 	<div class="signup-group">
	 		 <label for="fileupload"> Select an image to upload</label>
	 		<input type="file" name="imagine" required><br>
	 	</div>
	
	 	<div class="signup-group">
			<input type="submit" value="Process">	 
		</div>
	 </form>

	
	<footer>
		<div class="footer"><marquee direction="right" behavior="alternate">Portal pentru adoptii de animale: pentru modificari ale profilului contactati administratorul la adresa admin_adoptii@yahoo.com</marquee></div>
	</footer>
	
</body>
</html>