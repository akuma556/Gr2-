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
	background: linear-gradient(rgba(240, 240, 240, .7),
		rgba(240, 240, 240, .7)), url("images/participant.jpg");
		background-repeat: no-repeat;
		background-size: 108%;
}
td{
font-weight: bold;

}
</style>
<script src="css/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback Management System</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<div class="container">
	<div align="right">
	<button onclick="location.href='FeedbackLogin.obj'" class="btn btn-info">Log Out</button></div>
		<c:choose>
			<c:when test="${assignedCourses.size()>0}">
				<table border="1px" class="table table-striped">
					<tr>
						<th>Courses assigned to you are</th>
					</tr>
					<c:forEach items="${assignedCourses}" var="list">
						<tr>
							<td>${list}</td>
						</tr>

					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>No Courses has been assigned to you!!</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${noCourses }">No Course has been assigned to you</c:when>
			<c:when test="${feedbackSubmitted}">You have submitted feedback for all the courses assigned to you</c:when>
			<c:when test="${feedbackForm}">
				<h1>Feedback Form</h1>
				<c:choose>
					<c:when test="${status}">
						<p>Your feedback has been submitted</p>
					</c:when>
				</c:choose>
				<form:form action="submitFeedback.obj" modelAttribute="feedback"
					class="form-horizontal">
					<table class="table table-striped">
						<tr>
							<td>Participant Id is :</td>
							<td><form:input path="participantId"
									value="${participantId}" readonly="true"></form:input></td>
						</tr>
						<tr>
							<td>Select Training Code :</td>

							<td><form:select path="trainingCode">
									<form:options items="${feedbackrequired}"></form:options>
								</form:select></td>

						</tr>
						<tr>
							<td>Rate the Faculty on the basis of personal Communication</td>
							<td><form:select path="prsComm">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>

						<tr>
							<td>Rate the Faculty on the basis of doubt clarification</td>

							<td><form:select path="clrfyDbts">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>

						<tr>
							<td>Rate the Faculty on the basis of doubt time management</td>
							<td><form:select path="tm">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>

						<tr>
							<td>Rate the Faculty on the basis of handouts provided</td>
							<td><form:select path="hndOut">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>

						<tr>
							<td>Rate the Faculty on the basis of use of resources</td>
							<td><form:select path="hwSwNtwrk">
									<form:option value="1">1</form:option>
									<form:option value="2">2</form:option>
									<form:option value="3">3</form:option>
									<form:option value="4">4</form:option>
									<form:option value="5">5</form:option>
								</form:select></td>
						</tr>

						<tr>
							<td>Any Comments:</td>
							<td><form:textarea path="comments"></form:textarea></td>
						</tr>
						<tr>
							<td>Any Suggestions:</td>
							<td><form:textarea path="suggestions"></form:textarea></td>
						</tr>

					</table>
					<center><input type="Submit" value="Submit Feedback" class="btn btn-info"/></center>
				</form:form>
			</c:when>
		</c:choose>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>