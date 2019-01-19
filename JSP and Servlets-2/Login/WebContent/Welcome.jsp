<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="index.css">
	<meta charset="ISO-8859-1">
	<title>Login page</title>
</head>
<body>
	<form action="Updation" method="post">  
	<input class="un" type="text" name="user" value=<%=(String)request.getAttribute("user") %> onclick="this.value=''"/><br/>  
	<input class="pass" type="password" name="pwd"  value=<%=(String)request.getAttribute("pwd") %> onclick="this.value=''"/><br/>  
	<input class="un" type="text" name="nick"  value=<%=(String)request.getAttribute("nick") %> onclick="this.value=''"/><br/> 
	<input class="un" type="text" name="city"  value=<%=(String)request.getAttribute("city") %> onclick="this.value=''"/><br/>  
	<input class="submit" type="submit" value="update"/>  
	</form>  
	<br>
	<br>
	<form action="LogoutRedirect" method="post">
	<input class="submit" type="submit" value="logout"/>
	</form>
	
	
</body>
</html>
