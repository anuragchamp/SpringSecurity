<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Hello world : ${username}</h1>
  <h2>Roles are : ${roles}</h2>
  <sec:authorize access="hasAuthority('admin')">
    <a href="/springsecuritylearning/admin">Show Admin Page</a>
</sec:authorize>

  <sec:authorize access="hasAuthority('user')">
    <a href="/springsecuritylearning/admin">Show user Page</a>
</sec:authorize>
  
  <form:form action="logout" method="post">
    <input type="submit" value="logout" />
  </form:form>
  
</body>
</html>