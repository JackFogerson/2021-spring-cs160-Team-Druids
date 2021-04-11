<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodFinder</title>
</head>
<body>
	<div align="center">
		<h1>Welcome To FoodFinder</h1>
		<form action="${pageContext.request.contextPath}/searchRestaurant">
 			<input type="search" name="keyword" placeholder="Find a Restaurant..." size="100">
 		</form>
 		<br/>
 		<br/> 		
 		<!-- add a button that redirects you to the login page -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/login' ">Login</button>
		<br/>
		<br/>
		<!-- add a button that redirects you to the sign up page -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/registration' ">Sign Up</button>
 		<br/>
 		<br/>
 		<button onclick = "window.location.href = '${pageContext.request.contextPath}/users' ">Browse Users</button>
 		<br/>
 		<br/>
 		<button onclick = "window.location.href = '${pageContext.request.contextPath}/restaurants' ">Browse Restaurants</button>
	</div>
</body>
</html>