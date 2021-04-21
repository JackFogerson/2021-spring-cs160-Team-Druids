<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Search Results for: '${keyword}'</h2>
		<br/>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Cuisine</th>
				<th>Budget</th>
			</tr>
			<c:forEach items="${restaurantSearchResult}" var="restaurant">
				<tr>
					<td>${restaurant.restaurantName}</td>
					<td>${restaurant.street}</td>
					<td>${restaurant.city}</td>
					<td>${restaurant.state}</td>
					<td>${restaurant.cuisine}</td>
					<td>${restaurant.budget}</td>	
				</tr>
			</c:forEach>
		</table>
	</div> <br/>
	
	<h3>The Filter Features are Currently Under Development</h3>
	
	<form action="${pageContext.request.contextPath}/filterRestaurantSearch/${keyword}"> 	<!-- ?keyword=${keyword}, Filter By Location,  filterRestaurantByLocation -->
 		Filter By Location:
 		<input type="search" name="location" placeholder="City or State..." size="50">
 	</form> <br/>
		
	<form action="${pageContext.request.contextPath}/filterRestaurantSearch/${keyword}/${selectedBudgets}/${selectedCuisines}">		<!-- filterRestaurantByBudget <form:checkboxes items="${budgetList}" path="selectedBudgets"/> -->
		Filter By Budget: <form:checkboxes items="${budgetList}" path="selectedBudgets"/>
		<!-- 
		<form:checkbox path="selectedBudgets" value="Under $50" />Under $50&nbsp;
        <form:checkbox path="selectedBudgets" value="Under $100" />Under $100&nbsp; 
        <form:checkbox path="selectedBudgets" value="Over $100" />Over $100&nbsp; 
         -->
        <button type = "submit">Update Search Results</button>
	</form> <br/>
		
	<form action="${pageContext.request.contextPath}/filterRestaurantSearch/${keyword}">	<!-- filterRestaurantByCuisine <form:checkboxes items="${cuisineList}" path="selectedCuisines"/> -->
		Filter By Cuisine: <br/> <form:checkboxes items="${cuisineList}" path="selectedCuisines"/>
		<!-- 
		<form:checkbox path="selectedCuisines" value="African" />African&nbsp;
        <form:checkbox path="selectedCuisines" value="American" />American&nbsp; 
        <form:checkbox path="selectedCuisines" value="Brazilian" />Brazilian&nbsp;
        <form:checkbox path="selectedCuisines" value="Cajun" />Cajun&nbsp;&nbsp;
        <form:checkbox path="selectedCuisines" value="Caribbean" />Caribbean&nbsp; 
        <form:checkbox path="selectedCuisines" value="Chinese" />Chinese&nbsp; <br/>
        <form:checkbox path="selectedCuisines" value="Cuban" />Cuban&nbsp;
        <form:checkbox path="selectedCuisines" value="French" />French&nbsp; 
        <form:checkbox path="selectedCuisines" value="German" />German&nbsp;
        <form:checkbox path="selectedCuisines" value="Greek" />Greek&nbsp;
        <form:checkbox path="selectedCuisines" value="Indian" />Indian&nbsp; 
        <form:checkbox path="selectedCuisines" value="Italian" />Italian&nbsp; <br/>
        <form:checkbox path="selectedCuisines" value="Japanese" />Japanese&nbsp;
        <form:checkbox path="selectedCuisines" value="Korean" />Korean&nbsp; 
        <form:checkbox path="selectedCuisines" value="Mediterranean" />Mediterranean&nbsp;
        <form:checkbox path="selectedCuisines" value="Portuguese" />Portuguese&nbsp;
        <form:checkbox path="selectedCuisines" value="Russian" />Russian&nbsp; 
        <form:checkbox path="selectedCuisines" value="Seafood" />Seafood&nbsp; <br/>    
        <form:checkbox path="selectedCuisines" value="Soul Food" />Soul Food&nbsp; 
        <form:checkbox path="selectedCuisines" value="Spanish" />Spanish&nbsp
        <form:checkbox path="selectedCuisines" value="Thai" />Thai&nbsp;
        <form:checkbox path="selectedCuisines" value="Turkish" />Turkish&nbsp; 
        <form:checkbox path="selectedCuisines" value="Vietnamese" />Vietnamese&nbsp;  
         -->
        <button type = "submit">Update Search Results</button>
	</form>
	<br/>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to Homepage</button>
</body>
</html>