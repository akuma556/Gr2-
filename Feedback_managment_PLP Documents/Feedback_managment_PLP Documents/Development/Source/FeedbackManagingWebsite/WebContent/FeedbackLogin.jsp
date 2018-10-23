<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
table {
	background-color: rgba(200, 200, 200, .6);
	border-radius: 15px;
}

body {
	background-image: url("images/feed.jpg");
	background-repeat: no-repeat;
	background-size: 128%;
}
</style>
<script src="css/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback Management System</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">


		<form:form action="Login.obj" modelAttribute="employee">
			<div align="center" style="padding-top: 100px">
				<table>
					<thead>
						<tr align="center">
							<th colspan="2" style="padding-bottom: 20px; font-size: 24px">Welcome
								to Login Page</th>
						</tr>
					</thead>
					<tr>
						<td style="padding-right: 15px;">Enter Your Employee ID:</td>
						<td style="padding-top: 10px"><form:input path="employeeId"
								class="form-control" style="width:100%;" /></td>
					</tr>
					<tr>
						<td style="padding-right: 15px;">Password:</td>
						<td style="padding-top: 10px;"><form:input type="password"
								class="form-control" path="password" style="width:100%;" />
								<form:errors path="password"/>
								
								</td>
					</tr>
					<tr>

						<td colspan="2px" style="padding-top: 10px"><input
							style="width: 400px;font-size:18px;" align="middle"
							class="btn btn-primary" type="Submit" value="LOGIN" /></td>
					</tr>
				</table>

			</div>
		</form:form><br>
		<c:choose>
			<c:when test="${invalid }">
				<center ><div style="  font-size: 160% ;text-align:center;background-color: rgba(240, 240, 240, .9);width:50%;">Invalid
					Credentials!! Please try again.</div></center>
			</c:when>
		</c:choose>
		<div style="position: fixed; bottom: 0px;"><%@include
				file="footer.jsp"%></div>
	</div>
</body>
</html>