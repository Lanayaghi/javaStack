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
<a href="/songs/new">Add New</a>  <a href="/Search/topten">Top Songs</a>  <form action="/songs/search"><input type ="text" name="artist"> <input type = "submit" value = "Search Artist"/></form> 
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="songs">
        <tr>
            <td><a href="/songs/${songs.id }"><c:out value="${songs.title}"/></a></td>
            <td><c:out value="${songs.rate}"/></td>
            <td><a href="songs/${songs.id }/delete">Delete</a></td>
           
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>