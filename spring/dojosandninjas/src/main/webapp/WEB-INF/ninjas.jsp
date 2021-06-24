<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action = "/ninjas/new" method = "POST" modelAttribute="ninja">
<p> <form:label path="dojo">Select Dojo: </form:label>
	<form:errors path="dojo"/>
	<form:select path="dojo">
		<c:forEach items="${ dojos }" var="dojo">
		<option value="${ dojo.id }"><c:out value="${ dojo.name }"></c:out></option>
		</c:forEach>
	</form:select>
<p>  <form:label path="firstName">First Name:</form:label>
     <form:errors path= "firstName"/>
     <form:input path="firstName"/>
 </p>
 <p>  <form:label path="lastName">LastName</form:label>
      <form:errors path = "lastName"/>
      <form:input path="lastName"/>
      
</p>

<p>   <form:label path="age">Age</form:label>
      <form:errors path = "age"/>
      <form:input path="age"/>
</p>
<input type= "submit" value = "create">

     
</form:form>
</body>
</html>