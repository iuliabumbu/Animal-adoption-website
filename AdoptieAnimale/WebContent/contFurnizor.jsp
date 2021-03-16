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

    <sql:setDataSource user="root" password="rootpass" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/adoptieanimale" var="ds"/>
	 
	  <sql:query var="result" dataSource="${ds }">
 
		 select * from furnizor where userid='<%=(String)session.getAttribute("username")%>';
	 
	   </sql:query>
	   
	  
	
	<div class="container">
	<h2><span>Contul meu: </span></h2>
		 <table>
			<tr>
			<th>Nume</th>
			<th>Prenume</th>
			<th>UserId</th>
			<th>Parola</th>
			<th>Adresa</th>
			<th>Email</th>
			<th>Telefon</th>
		</tr>
	</table>
		
		 <c:forEach items="${result.rows }" var="row">
		  <table style="table-layout: fixed;width: 100%;">
		  	
				<tr>
					<td style="width: 100px;"><c:out value="${row.nume }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.prenume}"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.userid }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.parola }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.adresa }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.email }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.telefon}"/></td>
					
					
				</tr>
			</table>
		 </c:forEach>
		 </div>
   


	
	
	<footer>
		<div class="footer"><marquee direction="right" behavior="alternate">Portal pentru adoptii de animale: pentru modificari ale profilului contactati administratorul la adresa admin_adoptii@yahoo.com</marquee></div>
	</footer>
	
</body>
</html>