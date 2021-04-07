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
	<form:form method="POST" action = "${pageContext.request.contextPath}/login-user" modelAttribute="user">
		Email: <form:input path="email" name = "email"/><br/>										<!-- create a text box for their email -->
		Password: <form:input path="password" name = "password"/><br/>								<!-- create a text box for their password -->
		<button type = "submit">Login</button>				<!-- create a button to login the user-->
	</form:form>	
		<!-- add a button that redirects you to the home page -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Return to Homepage</button>
</body>
</html>