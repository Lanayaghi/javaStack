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
<h1> <c:out value="${category.name }"></c:out></h1>
 <h2>Products</h2>
 <ul>
<c:forEach items = "${category.products}" var = "product">
 <Li>${product.name }</li>
 </c:forEach>
 </ul>
 
  <h3>Add Category</h3>
 <form method = "post" action ="/addProduct/${category.id }">

 <select name = "product">
 <c:forEach items = "${unlisted }" var ="pro">
 <option value = "${pro.id }">${pro.name }</option>
 </c:forEach>
 
 </select>
 <input type = "submit" value = "Add"/>
 </form>
</body>
</html>