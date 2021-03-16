<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 
<link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
	<header>
		<h1>
			Administrator's Menu
		</h1>
		<h>
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="addClient.jsp">Add Client</a></li>
				<li><a href="addFurnizor.jsp">Add Furnizor</a></li>
				<li><a href="addAnimal.jsp">Add Animal</a></li>
				<li><a href="addVeterinar.jsp">Add Veterinar</a></li>
			    <li><a href="viewClient.jsp">View Client</a></li>
				<li><a href="viewFurnizor.jsp">View Furnizor</a></li>
				<li><a href="viewAnimal.jsp">View Animal</a></li>
				<li><a href="viewVeterinar.jsp">View Veterinar</a></li>
				<li><a href="login.jsp">Logout</a></li>
				
			</ul>
		</nav>
		</h>
	</header>
	
	 <sql:setDataSource user="root" password="rootpass" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/adoptieanimale" var="ds"/>
	 
	  <sql:query var="result" dataSource="${ds }">
 
		 select * from furnizor
		 
	   </sql:query>
	   
	  
	
	<div class="container">
	<h2>Lista Furnizori:</h2>
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
			       <td style="width: 100px;"><a href="editFurnizor.jsp?nume=${row.nume }&prenume=${row.prenume}&id=${row.userid}&parola=${row.parola}
					&adresa=${row.adresa}&email=${row.email}&telefon=${row.telefon}" style="color: #6bb1f8;">edit</a> ||
					<a href="deleteFurnizor.jsp?id=${row.userid}" style="color:#6bb1f8;">delete</a></td>
					
					
				</tr>
			</table>
		 </c:forEach>
		 </div>
	 <footer>
		<div class="footer"> Portal pentru adoptii de animale
	    </div>
	</footer>
	
</body>
</html>