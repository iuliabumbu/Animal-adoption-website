<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
				<li><a href="vizualizareAnimale.jsp">Vizualizare Animale</a></li>
				<li><a href="adoptiiClient.jsp">Adoptiile mele</a></li>
				<li><a href="contClient.jsp">Contul meu</a></li>
				<li><a href="veterinari.jsp">Lista veterinari</a></li>
				<li><a href="login.jsp">Logout</a></li>
			</ul>
			</ul>
		</nav>
	</header>
	  
	
	<div class="container">
	<div class="row">
 				<div class="col-md-4"><!-- left -->
 						<div class="list-group"><!-- products -->
						  <a href="ClientControl?page=all-animals" class="list-group-item" >Toate animalele </a>
						  <a href="ClientControl?page=caini" class="list-group-item">Caini</a>
						  <a href="ClientControl?page=pisici" class="list-group-item">Pisici</a>
						  <a href="ClientControl?page=papagali" class="list-group-item">Papagali</a>
						  <a href="ClientControl?page=hamsteri" class="list-group-item">Hamsteri</a>
						  <a href="ClientControl?page=iepuri" class="list-group-item" style="background: #ffd7b3;">Iepuri</a>
						  <a href="ClientControl?page=pesti" class="list-group-item">Pesti</a>
						</div> 
 				</div><!-- left -->

 				<div class="col-md-8"><!-- right -->
 					<h3 style="text-align: center;">Iepuri</h3><br>
 					
 					<h5 style="text-align: left;">Sortare dupa varsta:</h5>
					<form action="ClientControl" method="get" style="border: none;margin:0px;padding: 0px;margin-bottom: 20px;">
					<input type="hidden" name="page" value="age-sort">
					<input type="hidden" name="action" value="all-animals">
					<select name="sort">
					<option value="low-to-high">De la mic la mare</option>
					<option value="high-to-high">De la mare la mic</option>
					</select>
					<input type="submit" value="Go!">
					</form>
					
					<c:forEach items="${list }" var="animal">
					<c:if test="${animal.isAdoptat() == 'false' }">
						<c:if test="${animal.getTip() == 'iepure' }">

		 					<div class="col-md-4">
		 						<img src="${animal.getImagine() }" class="img-responsive" ><br>
		 						<div class="text-center"><a style="color: black;"><c:out value="${animal.getNume() }"></c:out></a></div>	
		 						<p style="text-align: center;"> IdAnimal: <c:out value="${ animal.getIdanimal()}"></c:out></p>
		 						<p style="text-align: center;"> Proprietar: <c:out value="${ animal.getProprietar() }"></c:out></p>
		 						<p style="text-align: center;"> Tip: <c:out value="${ animal.getTip() }"></c:out></p>
		 						<p style="text-align: center;"> Rasa: <c:out value="${ animal.getRasa() }"></c:out></p>
		 						<p style="text-align: center;"> Varsta: <c:out value="${ animal.getVarsta() }"></c:out></p>
		 						<p style="text-align: center;"> Gen: <c:out value="${ animal.getGen() }"></c:out></p>
		 						<div class="text-center">  <a class="btn btn-primary" href="ClientControl?page=efectueazaAdoptie&proprietar=<%=(String)session.getAttribute("username")%>&donator=<c:out value="${animal.getProprietar()}"/>&id=<c:out value="${animal.getIdanimal()}"/>">Adopta</a> </div><br>
		 					</div>	
		 				</c:if>	
		 				</c:if>		
 					</c:forEach>
 					
 				</div>
 			</div>
	
    </div>
	 <footer>
		<div class="footer"><marquee direction="right" behavior="alternate">Portal pentru adoptii de animale: pentru modificari ale profilului contactati administratorul la adresa admin_adoptii@yahoo.com</marquee></div>
	</footer>
	
</body>
</html>
	