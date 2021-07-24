<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
   <div class="container text-center">
       <h1>My Custom login page</h1>
       <c:if test="${param.error != null}">
       <p class="text-danger"> Invalid user name and password</p>
       </c:if>
       
        <c:if test="${param.logout != null}">
       <p class="text-danger"> You have logout from the site</p>
       </c:if>
       <form:form>
         Username <input type="text" name="username" /> <br />
         Password <input type="password" name="password" /> <br/>
         
         <button class="btn btn-outline-primary">Login</button>
       </form:form>
   </div>
   
</body>
</html>