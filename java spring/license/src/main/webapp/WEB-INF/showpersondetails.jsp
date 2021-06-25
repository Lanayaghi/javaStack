<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${person.firstName} ${person.lastName }"></c:out></h1>

<p> License Number: <c:out value="${license.state}"></c:out> </p>
<p> State: </p>
<p>Expiration Date: </p>
</body>
</html>