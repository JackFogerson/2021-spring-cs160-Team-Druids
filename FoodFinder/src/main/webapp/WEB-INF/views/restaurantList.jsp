<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Restaurants</title>
</head>
<body>
	<div align="center">
		<h1> Restaurants List</h1>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Cuisine</th>
				<th>Budget</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${restaurantList}" var="restaurant">
				<tr>
					<td>${restaurant.restaurantName}</td>
					<td>${restaurant.street}</td>
					<td>${restaurant.city}</td>
					<td>${restaurant.state}</td>
					<td>${restaurant.cuisine}</td>
					<td>${restaurant.budget}</td>
					
					<!-- create links to the Edit and Delete buttons. prefix the root name of the url -->
					<td><a href = "${pageContext.request.contextPath}/restaurants/${restaurant.id }">Edit</a> | <a href = "${pageContext.request.contextPath}/deleteRestaurant/${restaurant.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- add a button that redirects you to the restaurant adding page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/showRestaurantForm' ">Add Restaurant</button>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>