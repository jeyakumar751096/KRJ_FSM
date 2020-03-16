<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <B> Welcome Jeyakumar Your project successfull login.</B>
   <input type="hidden" id="current_user_id" value="${ userId }">
    <input type="hidden" id="current_username" value="${ currentUser }">
     <div>
          <h1>Welcome ${currentUser} to Feedback Management System ${currentRole} </h1>
          
          <a href="${pageContext.request.contextPath}/admin">Admin Page</a><br>
          <a href="${pageContext.request.contextPath}/pmo">PMO</a><br>
          <a href="${pageContext.request.contextPath}/poc">POC</a>
	</div>
	<form:form action="doLogout" method="get">
		<input type="submit" value="Logout"/>
	</form:form>
 <!--  <div class="form-group">
                       <a href="welcomeadmin.jsp">Admin</a>
                       <a href="welcomepmo.jsp">PMO</a>
                       <a href="welcomepoc">POC</a>
                       <a href="logout">LogOut</a>
                       </div> -->
</body>
</html>