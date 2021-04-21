<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Restaurant</h1>
	<form:form action="${pageContext.request.contextPath}/saveRestaurant" modelAttribute="restaurant">
		Name: <form:input path="restaurantName"/><br/>
		Street: <form:input path="street"/><br/>
		City: <form:input path="city"/><br/>
		State: <form:input path="state"/><br/>
		Type of Cuisine: <form:select path="cuisine">								<!-- create a dropdown for their cuisine -->
			<form:option value = "none">None</form:option>
			<form:option value = "Spanish">Spanish</form:option>
			<form:option value = "Mexican">Mexican</form:option>
			<form:option value = "Cajun">Cajun</form:option>
			<form:option value = "American">American</form:option>
			<form:option value = "German">German</form:option>
			<form:option value = "Soul Food">Soul Food</form:option>
			<form:option value = "Japanese">Japanese</form:option>
			<form:option value = "Caribbean">Caribbean</form:option>
			<form:option value = "Vietnamese">Vietnamese</form:option>
			<form:option value = "Chinese">Chinese</form:option>
			<form:option value = "French">French</form:option>
			<form:option value = "Thai">Thai</form:option>
			<form:option value = "Indian">Indian</form:option>
			<form:option value = "African">African</form:option>
			<form:option value = "Italian">Italian</form:option>
			<form:option value = "Greek">Greek</form:option>
			<form:option value = "Russian">Russian</form:option>
			<form:option value = "Brazilian">Brazilian</form:option>
			<form:option value = "Cuban">Cuban</form:option>
			<form:option value = "Portuguese">Portuguese</form:option>
			<form:option value = "Seafood">Seafood</form:option>
			<form:option value = "Turkish">Turkish</form:option>
			<form:option value = "Mediterranean">Mediterranean</form:option>
			<form:option value = "Korean">Korean</form:option>
		</form:select><br/>
		Budget: <form:radiobutton path="budget" value = "Under $50"/>Under $50&nbsp;	<!-- create a radio button for the budget (&nbsp places a space after the button) --> 
				<form:radiobutton path="budget" value = "Under $100"/>Under $100&nbsp;
				<form:radiobutton path="budget" value = "Over $100"/>Over $100<br/>
		<form:hidden path = "id"/>							<!-- hide the id when submitting so the restaurant can either be updated or added db -->
		<button type = "submit">Save Restaurant</button>	<!-- create a button to submit the restaurant-->
	</form:form>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>