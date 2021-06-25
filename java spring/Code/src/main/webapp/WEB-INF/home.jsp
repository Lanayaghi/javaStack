<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>
<p><c:out value="${error}"/></p>
<p>What is the code?</p>
<form method="POST" action="/code">
      <br>
  <input type="text" name="code">
      <br>
 <button>Try Code</button>
</form>

</body>

</html>