 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<h1>New License</h1>
<form:form action = "/licenses/new" method = "POST" modelAttribute="license">
<p> <form:label path="person">Person: </form:label>
	<form:errors path="person"/>
	<form:select path="person">
		<c:forEach items="${ persons }" var="p">
		<form:option value="${ p.id }">${ p.firstName } ${p.lastName } </form:option>
		</c:forEach>
	</form:select>
<p>  <form:label path="state">State:</form:label>
     <form:errors path= "state"/>
     <form:input path="state"/>
 </p>
 <p>  <form:label path="expirationDate">Expiration Date</form:label>
      <form:errors path = "expirationDate"/>
      <form:input type = "date" path="expirationDate"/>
      
</p>


<input type= "submit" value = "Add License">

     
</form:form>

</body>
</html>