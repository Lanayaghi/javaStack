<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${ driver.firstName } ${ driver.lastName }</h1>
		<p><strong>License Number</strong> ${ driver.license.getNumberAsString() }</p>
		<p><strong>Expiration Date</strong> ${ driver.license.getExpirationDateFormatted() }</p>
</body>
</html>