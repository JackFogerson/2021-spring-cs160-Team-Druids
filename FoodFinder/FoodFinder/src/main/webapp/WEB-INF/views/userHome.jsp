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
	<h1>Welcome</h1>	
		<!-- add a button that redirects you to the login page -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/home' ">Log Out</button>
		<br>
</body>
</html>