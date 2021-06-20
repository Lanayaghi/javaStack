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

<h1>Your gold:<c:out value="${gold}"></c:out> </h1>
<div class = "container">

<div>
<h2>Farm</h2>
<p> (earns 10-20 gold)</p>
<form method = "POST"  action = "/gold">
<input type="hidden" name="building" value="farm">
<input type ="submit" value = "Find Gold!">

</form>
</div>


<div>
<h2>Cave</h2>
<p> (earns 5-10 gold)</p>
<form method ="POST" action = "/gold">
<input type="hidden" name="building" value="cave">
<input type ="submit" value = "Find Gold!">
</form>
</div>


<div>
<h2>House</h2>
<p> (earns 2-5 gold)</p>
<form method = "POSt" action = "/gold">
<input type="hidden" name="building" value="house">
<input type ="submit" value = "Find Gold!">
</form>
</div>


<div>
<h2>Casino</h2>
<p> (earns/takes 0-50 gold)</p>
<form method = "POST" action = "/gold">
<input type="hidden" name="building" value="casino">
<input type ="submit" value = "Find Gold!">
</form>
</div>
</div>

<div>
<h1>Activities:</h1>
<c:forEach var="activity" items ="${activities }">
<c:choose>
<c:when test="${activity.charAt(0) eq 'y'.charAt(0) }">
<p style="color:green;"> <c:out value="${activity }"></c:out></p>
</c:when>
<c:otherwise>
<p style="color:red;"> <c:out value="${activity }"></c:out></p>
</c:otherwise>
</c:choose>

</c:forEach>
</div>

</body>
</html>