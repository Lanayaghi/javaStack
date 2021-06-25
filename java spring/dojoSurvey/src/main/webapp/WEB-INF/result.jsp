<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>Submitted Info</h1>
Name : <c:out value="${name}"></c:out>
<br>
Dojo Location : <c:out value="${location}"></c:out>
<br>
Favorite Language : <c:out value="${fave}"></c:out>
<br>
Comment :<c:out value="${comment}"></c:out>
</div>
</body>
</html>