<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create a course</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>

	<div class="container">
		<div class="notification">
			<h1 class="title">
				
				Create a new course
			</h1>
		</div>

		
		
		<section>
			<div class="columns">
				<div class="column">

					<form:form method="POST" action="/courses/new/" modelAttribute="course">
						<table>
							<tr>
								<td><form:label path="title">Name:</form:label></td>
								<td><form:input path="title" class="input" /></td>
								<td><form:errors path="title" /></td>
							</tr>
								
							<tr>
								<td><form:label path="firstName">Instructor:</form:label></td>
								<td><form:input path="firstName" class="input" /></td>
								<td><form:errors path="firstName" /></td>
							</tr>
							<tr>
								<td><form:label path="capacity">Capacity:</form:label></td>
								<td><form:input path="capacity" class="input" type="number"/></td>
								<td><form:errors path="capacity" /></td>
							</tr>
						</table>
						<div class="buttons has-addons">
							<input type="submit" value="Create" class="button is-dark" />
						</div>
					</form:form>
				

				</div>
				<div class="column"></div>
			</div>

		</section>
		
		
	</div>
</body>
</html>