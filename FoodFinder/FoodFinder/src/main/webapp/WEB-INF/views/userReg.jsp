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
	<h1>Sign Up</h1>
	<form:form action = "${pageContext.request.contextPath}/save" modelAttribute="user">
		First Name: <form:input path="firstName"/>									<!-- create a text box for the user's first name-->
		Last Name: <form:input path="lastName"/><br/>								<!-- create a text box for their last name -->
		Date of Birth: <form:input path="dateOfBirth" type = "date"/><br/>			<!-- create a date picker for their date of birth -->
		Email: <form:input path="email"/><br/>										<!-- create a text box for their email -->
		Password: <form:input path="password"/><br/>								<!-- create a text box for their password -->
		Location: <form:input path="location"/><br/>									<!-- create a text box for their location -->
		Budget: <form:radiobutton path= "budget" value = "Under $50"/>Under $50&nbsp;			<!-- create a radio button for the budget -->
						<form:radiobutton path="budget" value = "Under $100"/>Under $100&nbsp;
						<form:radiobutton path="budget" value = "Over $100"/>Over $100<br/>
		Favorite Cuisine: <form:select path="favoriteCuisine">									<!-- create a dropdown for their cuisine -->
			<form:option value = "none">None</form:option>
			<form:option value = "Spanish Cuisine">Spanish Cuisine</form:option>
			<form:option value = "Mexican Cuisine">Mexican Cuisine</form:option>
			<form:option value = "Cajun Cuisine">Cajun Cuisine</form:option>
			<form:option value = "American Cuisine">American Cuisine</form:option>
			<form:option value = "German Cuisine">German Cuisine</form:option>
			<form:option value = "Soul Food">Soul Food</form:option>
			<form:option value = "Japanese Cuisine">Japanese Cuisine</form:option>
			<form:option value = "Caribbean Cuisine">Caribbean Cuisine</form:option>
			<form:option value = "Vietnamese Cuisine">Vietnamese Cuisine</form:option>
			<form:option value = "Chinese Cuisine">Chinese Cuisine</form:option>
			<form:option value = "French Cuisine">French Cuisine</form:option>
			<form:option value = "Thai Cuisine">Thai Cuisine</form:option>
			<form:option value = "Indian Cuisine">Indian Cuisine</form:option>
			<form:option value = "African Cuisine">African Cuisine</form:option>
			<form:option value = "Italian Cuisine">Italian Cuisine</form:option>
			<form:option value = "Greek Cuisine">Greek Cuisine</form:option>
			<form:option value = "Russian Cuisine">Russian Cuisine</form:option>
			<form:option value = "Brazilian Cuisine">Brazilian Cuisine</form:option>
			<form:option value = "Cuban Cuisine">Cuban Cuisine</form:option>
			<form:option value = "Portuguese Cuisine">Portuguese Cuisine</form:option>
			<form:option value = "Seafood">Seafood</form:option>
			<form:option value = "Turkish Cuisine">Turkish Cuisine</form:option>
			<form:option value = "Mediterranean Cuisine">Mediterranean Cuisine</form:option>
			<form:option value = "Korean Cuisine">Korean Cuisine</form:option>
		</form:select><br/>
		<form:hidden path = "id"/>							<!-- hide the id when submitting so the user can either be updated or added db -->
		<button type = "submit">Create Account</button>		<!-- create a button to submit the user-->
	</form:form>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>