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
	<h1>Login</h1>
	<form:form action = "${pageContext.request.contextPath}/loginUser" modelAttribute="user">
		Email: <form:input path="email"/><br/>										<!-- create a text box for their email -->
		Password: <form:input path="password"/><br/>								<!-- create a text box for their password -->
		<form:hidden path = "id"/>							<!-- hide the id when submitting so the user can either be updated or added db -->
		<button type = "submit">Login</button>				<!-- create a button to login the user-->
	</form:form>	
		<!-- add a button that redirects you to the home page -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to homepage</button>
</body>
</html>