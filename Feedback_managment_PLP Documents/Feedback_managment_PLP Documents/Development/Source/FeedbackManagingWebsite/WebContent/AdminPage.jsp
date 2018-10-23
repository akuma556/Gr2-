<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1 class="container" style="text-align: center; padding-top: 20px">Welcome
		to Admin Page</h1>


	<div style="padding-top: 20px;" align="center">
		<button type="button" class="btn btn-info"
			onclick="location.href='facultySkill.obj'"
			style="width: 300px; height: 80px;">Faculty skill
			Maintenance</button>
		<br>
		<br>
		<br>
		<button type="button" class="btn btn-info"
			onclick="location.href='courseMaintenance.obj'"
			style="width: 300px; height: 80px;">Course Maintenance</button>
		<br>
		<br>
		<br>
		<button type="button" class="btn btn-info"
			onclick="location.href='feedbackReport.obj'"
			style="width: 300px; height: 80px">View Feedback Report</button>
		<br>
		<br>
		<br>
		<button onclick="location.href='FeedbackLogin.obj'"
			class="btn btn-primary">Log Out</button>
	</div>

	<div style="position: fixed; bottom: 0px;"><%@include
			file="footer.jsp"%></div>
</body>
</html>