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
<h1>All Drivers</h1>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>License</th>
            <th>State</th>
            <th>Expiration Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${drivers}" var="driver">
        <tr>
            <td><c:out value="${driver.firstName}"/></td>
            <td><c:out value="${driver.lastName}"/></td>
            <td><c:out value="${driver.license.number}"/></td>
            <td><c:out value="${driver.license.state}"/></td>
            <td><c:out value="${driver.license.expirationDate}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>