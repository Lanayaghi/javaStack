<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New License</h1>
<form:form method="post" action = "/license/new" modelAttribute="license">
     <p>
     
      
   <form:label path= "driver">Driver</form:label>
   <form:select path = "driver">
   <form:errors path = "driver"/>
     <c:forEach items="${drivers}" var="driver">
          <c:if test="${driver.getLicense() == null }">
           <form:option value="${driver}" label="${driver.firstName } ${driver.lastName }"/>
          </c:if>
     </c:forEach>
   </form:select>
                
            
         </p>
     
     
           
          
         <p>
      <form:label path="state">State</form:label>
      <form:input path = "state"/>
      <form:errors path = "state"/>
         </p>
         <p>
      <form:label path="expirationDate">Expiration Date</form:label>
      <form:errors path = "expirationDate"/>
      <form:input type= "date" path = "expirationDate"/>
      </p>
      <button>Create License</button>
      
</form:form>
</body>
</html>