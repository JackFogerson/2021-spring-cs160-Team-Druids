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
	<form:form action = "${pageContext.request.contextPath}/saveUser" modelAttribute="user">
		First Name: <form:input path="firstName"/>										<!-- create a text box for the user's first name-->
		Last Name: <form:input path="lastName"/><br/>									<!-- create a text box for their last name -->
		Date of Birth: <form:input path="dateOfBirth" type = "date"/><br/>				<!-- create a date picker for their date of birth -->
		Email: <form:input path="email"/><br/>											<!-- create a text box for their email -->
		Password: <form:input path="password"/><br/>									<!-- create a text box for their password -->
		Location: <form:input path="location"/><br/>									<!-- create a text box for their location -->
		Budget: <form:radiobutton path= "budget" value = "Under $50"/>Under $50&nbsp;	<!-- create a radio button for the budget -->
				<form:radiobutton path="budget" value = "Under $100"/>Under $100&nbsp;
				<form:radiobutton path="budget" value = "Over $100"/>Over $100<br/>
		Favorite Cuisine: <form:select path="favoriteCuisine">							<!-- create a dropdown for their cuisine -->
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
		<form:hidden path = "id"/>							<!-- hide the id when submitting so the user can either be updated or added db -->
		<button type = "submit">Save Account</button>		<!-- create a button to submit the user-->
	</form:form>
	<!-- add a button that redirects you to the home page -->
	<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>