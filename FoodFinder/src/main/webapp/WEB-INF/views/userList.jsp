<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registered Users</h1>
	<table border = "1">
		<tr>											<!-- create a table -->
			<th>First Name</th>       					<!-- define the headers of the table -->
			<th>Last Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Location</th>
			<th>Budget</th>
			<th>Date of Birth</th>
			<th>Favorite Cuisine</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${userList}" var="user">		<!-- for every user in the list -->
			<tr>										<!-- create a row in the table -->
				<td>${user.firstName}</td>				<!-- define the data in the row -->
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td>${user.location}</td>
				<td>${user.budget}</td>
				<td>${user.dateOfBirth}</td>
				<td>${user.favoriteCuisine}</td>
				
				<!-- create links to the Edit and Delete buttons. prefix the root name of the url -->
				<td><a href = "${pageContext.request.contextPath}/users/${user.id }">Edit</a> | <a href = "${pageContext.request.contextPath}/deleteUser/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table><br/>
	
	<!-- add a button that redirects you to the sign up page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/showUserForm' ">Sign Up</button>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>