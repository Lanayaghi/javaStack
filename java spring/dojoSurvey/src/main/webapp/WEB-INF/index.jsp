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
<div>
<form method="POST" action="/result">
    <label>Your name: <input type="text" name="name"></label>
    <br>
    <label>Dojo Location:  <select name="location" id="locate">
    
            <option>Select location:</option>
            <option>nablus</option>
            <option>yafa</option>
            <option>tel alrabee</option>

        </select>
        </label>
        <br>
    <label>Favorite Language: <select name="fave" id="fave">

            <option>Select language:</option>
            <option>Python</option>
            <option>Java</option>
            <option>Php</option>

        </select>
        </label>
        <br>
     <label>Comment: <textarea name = "comment" rows="2" cols="10"></textarea></label>
     <br>
   <input type="submit" value="button">
</form>
</div>
</body>
</html>