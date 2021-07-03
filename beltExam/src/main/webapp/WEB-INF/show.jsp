   
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
<meta charset="ISO-8859-1">
<title>Belt Exam</title>
</head>
<body>
<body>
<h1>Hello <c:out value="${user.name}"/></h1>
<table class="table table-hover">

    <thead>
        <tr>
            <th>Course</th>
            <th>Instructor</th>
            <th>SignUps</th>
             <th>Action</th>
         
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${courses}" var="courses">
        <tr>
            
            <td><a href="/courses/${courses.id}">${courses.title}</a></td>
            <td><c:out value="${courses.firstName} "/></td>
            					<td>${courses.joining.size()} / ${courses.capacity}</td>
					<td>
					<c:choose>
						<c:when test="${courses.joining.indexOf(user)!= -1}">
							Already Added
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${courses.joining.size() == courses.capacity}">
									Full
								</c:when>
								<c:otherwise>
									<a href="/courses/add/${courses.id}">Add</a>
								</c:otherwise>
							</c:choose>	
						</c:otherwise>
					</c:choose>
         
        </tr>
        </c:forEach>
    </tbody>
    
    

</table>

<a href="/courses/new">Add a Course</a>

</body>
</html>