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
<h1> <c:out value="${product.name }"></c:out></h1>
 <h2>Categories</h2>
 <ul>
<c:forEach items = "${product.categories}" var = "category">
 <Li>${category.name }</li>
 </c:forEach>
 </ul>
 
 <h3>Add Category</h3>
 <form method = "post" action ="/addCategory/${product.id }">

 <select name = "category">
 <c:forEach items = "${unlisted }" var ="cate">
 <option value = "${cate.id }">${cate.name }</option>
 </c:forEach>
 
 </select>
 <input type = "submit" value = "Add"/>
 </form>
</body>
</html>