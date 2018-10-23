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
		<h1 style="text-align: center">Feedback Page</h1>
		<div>
			<button type="button" class="btn btn-info"
				onclick="location.href='allFeedbacks.obj'">View All
				Feedback Report</button>
			<button type="button" class="btn btn-info"
				onclick="location.href='feedbackByFacultyID.obj'">View
				Feedback Report by Faculty</button>
			<button type="button" class="btn btn-info"
				onclick="location.href='feedbackDefaulters.obj'">Defaulter
				Feedback Table</button>

		</div>
		<div align="right">
			<button onclick="location.href='FeedbackLogin.obj'"
				class="btn btn-info">Log Out</button>
		</div>
		<div>
			<c:choose>
				<c:when test="${feedbackFaculty}">Click on the Faculty ID to view their average feedback
			<table border="1px" class="table table-striped">
						<tr>
							<th>Faculty Id</th>
							<th>Faculty Name</th>
						</tr>
						<c:forEach items="${facultyList}" var="faculty">
							<tr>
								<td><a
									href="getFacultyFeedback.obj?id=${faculty.employeeId }">${faculty.employeeId }</a></td>
								<td>${faculty.employeeName }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
			</c:choose>
			<br> <br>
			<c:choose>
				<c:when test="${ feedbackReport.size()>0}">
					<table border="1px" class="table table-striped">
						<caption>Average Feedback Report for all Training
							Programs</caption>
						<tr>
							<th>Training Code</th>
							<th>Faculty Name</th>
							<th>Personal Communication</th>
							<th>Clarify Doubts</th>
							<th>Time Management</th>
							<th>Hands Outs Provided</th>
							<th>HW SW NTWRK</th>
						</tr>
						<c:forEach items="${feedbackReport }" var="feedbacks">
							<tr>
								<td>${feedbacks.trainingCode }</td>
								<td>${feedbacks.facultyName }</td>
								<td>${feedbacks.avgPrsComm }</td>
								<td>${feedbacks.avgClrfyDbts }</td>
								<td>${feedbacks.avgTm }</td>
								<td>${feedbacks.avgHndOut }</td>
								<td>${feedbacks.avgHwSwNtwrk }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${feedback==1}">No feedback has been given for any training program</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${feedbackFacultyList.size()>0}">
					<table border="1px" class="table table-striped">
						<tr>
							<th>Training Code</th>
							<th>Personal Communication</th>
							<th>Clarify Doubts</th>
							<th>Time Management</th>
							<th>Hands Out Provided</th>
							<th>HW SW NTWRK</th>
						</tr>
						<c:forEach items="${feedbackFacultyList }" var="feedbackFac">
							<tr>
								<td>${feedbackFac.trainingCode }</td>
								<td>${feedbackFac.avgPrsComm }</td>
								<td>${feedbackFac.avgClrfyDbts }</td>
								<td>${feedbackFac.avgTm }</td>
								<td>${feedbackFac.avgHndOut }</td>
								<td>${feedbackFac.avgHwSwNtwrk }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${feedback==2}">No Feedback for particular faculty of the respective training code has been provided</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${report.size()>0}">
					<table border="1px" class="table table-striped">
						<tr>
							<th>Participant ID</th>
							<th>Training Code</th>
						</tr>
						<c:forEach items="${report }" var="report">
							<tr>
								<td>${report.participantId }</td>
								<td>${report.trainingCode }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${feedback==3}">Feedback for each training program has been filled</c:when>
			</c:choose>
		</div>
	</div>
	<div style="position: fixed; bottom: 0px;"><%@include
			file="footer.jsp"%></div>
</body>
</html>