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




<p>Artist: <c:out value="${song.artist}"/></p>
<p>Title: <c:out value="${song.title}"/></p>
<p>Rating : <c:out value="${song.rate}"/></p>



<a href="/songs/${song.id}/delete">Delete Song </a>


</body>
</html>