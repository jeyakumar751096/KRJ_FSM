<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Access Denied Page..!</title>
</head>
<body>
	<h2>Access Denied - You are not authorized to access this resource</h2>
	<!-- <a href="${pageContext.request.contextPath}/">Back</a> -->
	<form:form action="/postLogin" method="post">
		<input type="submit" value="Back" /> 
	</form:form>
</body>
</html>