<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	

	 <form method="post" action="admin">
	 
	 <input type="hidden" name="page" value="delete_client">
     
			<p class="textbox">Are you sure you want to delete client with userid: </p>
			<input type="text" name="id" value =<%=request.getParameter("id")%> />
			<div class="signup-group">
			<input type="submit" value="Yes">	 
		    </div>
	
	 <footer style="position: absolute;left: 0;bottom: 0;width: 100%;">
		<div class="footer"> Portal pentru adoptii de animale
	    </div>
	</footer>
</body>
</html>