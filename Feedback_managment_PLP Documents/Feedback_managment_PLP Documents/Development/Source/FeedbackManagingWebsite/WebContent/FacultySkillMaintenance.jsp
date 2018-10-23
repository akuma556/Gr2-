<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-image: url("images/feedback.jpg");
}
</style>
<script src="css/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback Management System</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
	<h1 align="center">Welcome to Faculty Skill Maintenance</h1>
	<div align="right"><button onclick="location.href='AdminPage.jsp'"
			class="btn btn-info">HomePage</button>
		
		<button onclick="location.href='FeedbackLogin.obj'"
			class="btn btn-info">Log Out</button></div>
	<c:choose>
		<c:when test="${choice == 0}">
			<fieldset><legend>Click on a Faculty ID to update faculty details:</legend></fieldset>
			<table border="1px" class="table table-striped">
				<tr>
					<th>Faculty ID</th>
					<th>Faculty Skill Set</th>
				</tr>
				<c:forEach items="${facultylist}" var="faculty">
					<tr>
						<td><a href="facultyDetails.obj?id=${faculty.facultyId }">${faculty.facultyId}</a></td>
						<td>${faculty.skillSet }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${choice == 1}">
			<fieldset><legend>Here are the Faculty Details:</legend></fieldset>
			<form:form action="updateDetails.obj" modelAttribute="faculty">
				<table class="table table-striped">
					<tr>
						<td>Faculty ID:</td>
						<td><form:input path="facultyId" value="${faculty.facultyId}"
								readonly="true" class="form-control"/></td>
					</tr>
					<tr>
						<td>Skills:</td>
						<td><form:input path="skillSet" readonly="true"
								value="${faculty.skillSet }" class="form-control"/></td>
					</tr>
					<tr>
						<td>Enter any skill you may want to add:</td>
						<td><input type="text" name="skills" /> <c:choose>
								<c:when test="${error }">
									<span>Skills cannot be empty</span>
								</c:when>
							</c:choose></td>
					</tr>
				</table><br>
				<input type="submit" value="Update Skills" class="btn btn-primary" style="width: 180px"/>
			</form:form><br><br>
		</c:when>

		<c:when test="${choice == 2 }">
			<fieldset><legend>Click on a Faculty ID to update faculty details:</legend></fieldset>
			<h6>Faculty Updated</h6>
			<table border="1px" class="table table-striped">
				<tr>
					<th>Faculty ID</th>
					<th>Faculty Skill Set</th>
				</tr>
				<c:forEach items="${facultylist}" var="faculty">
					<tr>
						<td><a href="facultyDetails.obj?id=${faculty.facultyId }">${faculty.facultyId}</a></td>
						<td>${faculty.skillSet }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>

		<c:otherwise></c:otherwise>
	</c:choose>
	
	<div style="position: fixed; bottom: 0px;"><%@include file="footer.jsp"%></div>
	</div>
</body>
</html>