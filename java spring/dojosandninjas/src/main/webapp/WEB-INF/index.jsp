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
<h1>New Dojo</h1>
<form:form action = "/dojos/new" method = "POST" modelAttribute="dojo">
<p> <form:label path="name">Name</form:label>
    <form:errors path = "name"/>
    <form:input path="name"/>
</p>

<input type="submit" value = "Create">
</form:form>
</body>
</html>