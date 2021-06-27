<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Top Ten Songs</h3>

<table>
    <thead>
        <tr>
            <th>Rating</th>
            <th>Title</th>
            <th>Artist</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.rate}"/></td>
            <td><a href="/songs/${song.id }"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.artist}"/></td>
           
           
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>