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
		<br>
		<div align="right">
			<button onclick="location.href='AdminPage.jsp'" class="btn btn-info">HomePage</button>

			<button onclick="location.href='FeedbackLogin.obj'"
				class="btn btn-info">Log Out</button>
		</div>
		<button onclick="location.href='addCourse.obj'"
			class="btn btn-primary">Add New Course</button>
		<button onclick="location.href='courseMaintenance.obj'"
			class="btn btn-primary">View All Courses</button>
		<br> <br> <br>
		<div class="container mt-3">
			<c:choose>
				<c:when test="${choice == 0 }">
					<c:choose>
						<c:when test="${updated }">
							<h4>Updated Table</h4>
						</c:when>
					</c:choose>
					<center><fieldset><legend>List of Available Courses</legend></fieldset></center>
					<br>
					<table border="1px" class="table table-striped">
						<tr>
							<th>Course ID</th>
							<th>Course Name</th>
							<th>Course Duration</th>
							<th>Update Course</th>
							<th>Delete Course</th>
						</tr>
						<c:forEach items="${courselist}" var="course">
							<tr>
								<td>${course.courseId}</td>
								<td>${course.courseName}</td>
								<td>${course.noOfDays}</td>
								<td><a href="getCourse.obj?id=${course.courseId}">Update</a></td>
								<td><a href="deleteCourse.obj?id=${course.courseId}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${choice == 1}">
					<form:form action="newCourse.obj" modelAttribute="course">
						<table class="table table-striped">
							<tr>
								<td>Course Name</td>
								<td><form:input path="courseName" class="form-control" />
									<form:errors path="courseName" /></td>
							</tr>
							<tr>
								<td>No Of Days</td>
								<td><form:input path="noOfDays" class="form-control" /> <form:errors
										path="noOfDays" /></td>
							</tr>
						</table>
						<input type="submit" value="Add Course" class="btn btn-primary" />
					</form:form>
				</c:when>
				<c:when test="${choice == 2}">
					<h4>Course added to Database</h4>
					<center><fieldset><legend >List of Available Courses</legend></fieldset></center>
					<table border="1px">
						
						<tr>
							<th>Course ID</th>
							<th>Course Name</th>
							<th>Course Duration</th>
						</tr>
						<c:forEach items="${courselist}" var="course">
							<tr>
								<td>${course.courseId}</td>
								<td>${course.courseName}</td>
								<td>${course.noOfDays}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:when test="${choice == 3 }">
				<center><fieldset><legend >Update Course Details</legend></fieldset></center>
					<form:form action="updateCourse.obj" modelAttribute="course"
						class="form-group">
						<table border="1px" class="table table-striped">
							
							<tr>
								<td>Course ID:</td>
								<td><form:input path="courseId" value="${course.courseId }"
										readonly="true" class="form-control"/></td>
							</tr>
							<tr>
								<td>Course Name:</td>
								<td><form:input path="courseName"
										value="${course.courseName }" readonly="true" class="form-control"/></td>
							</tr>
							<tr>
								<td>Course Duration:</td>
								<td><form:input path="noOfDays" value="${course.noOfDays }" class="form-control"/></td>
							</tr>
						</table>
						<input type="submit" value="Update Course" />
					</form:form>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>


		<%@include file="footer.jsp"%>
	</div>
</body>
</html>