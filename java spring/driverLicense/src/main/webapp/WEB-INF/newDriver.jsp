<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New driver</h1>
  <p>
  <form:form method = "post" action = "/driver/new" modelAttribute="driver">
  
  <p>
      <form:label path="firstName">First Name</form:label>
      <form:input path="firstName"/>

  </p>
  <p>
       <form:label path="lastName">Last Name</form:label>
      <form:input path="lastName"/>
     
  </p> 
      <button>Create Driver</button>
    </form:form>

</body>
</html>