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
		<div align="right">
			<button type="button" class="btn btn-info"
				onclick="location.href='FeedbackLogin.obj'">Log Out</button>
		</div>
		<div>
			<button type="button" class="btn btn-info"
				onclick="location.href='trainingProgramMaintenance.obj'">Training
				Program Maintenance</button>
			<button type="button" class="btn btn-info"
				onclick="location.href='participantEnrollment.obj'">Participant
				Enrollment</button>
			<button type="button" class="btn btn-info"
				onclick="location.href='feedbackReport.obj'">View Feedback
				Report</button>

		</div>



		<!-- TRAINING PROGRAM MAINTENANCE WHICH INCLUDES ADDING OF NEW 
		 PROGRAM, UPDATING THE EXIXTING PROGRAM, DELETING THE PROGRAM -->


		<div>
			<c:choose>
				<c:when test="${updated}">Training Program with ${program.trainingCode} UPDATED</c:when>
			</c:choose>

		</div>
		<br> <br>
		<div>
			<c:choose>
				<c:when test="${viewProgram }">
			WANT TO ADD NEW PROGRAM? <a href="addProgram.obj">Click Here</a>
					<br>
					<br>
					<c:choose>
						<c:when test="${programList.size() >0}">
							<table border="1px" class="table table-striped">
								<tr>
									<th>Training Code</th>
									<th>Course Code</th>
									<th>Faculty Code</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Update</th>
									<th>Delete</th>
								</tr>
								<c:forEach items="${programList}" var="program">
									<tr>
										<td>${program.trainingCode}</td>
										<td>${program.courseCode }</td>
										<td>${program.facultyCode }</td>
										<td>${program.startDate }</td>
										<td>${program.endDate }</td>
										<td><button type="button" class="btn btn-info"
												onclick="location.href='getTrainingProgram.obj?id=${program.trainingCode}'">Update</button></td>
										<td><button type="button" class="btn btn-info"
												onclick="location.href='deleteTrainingProgram.obj?id=${program.trainingCode}'">Delete</button>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:when>
						<c:otherwise>
							<h3>No Training Programs available yet. Click above to add a
								training program!</h3>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:when test="${add }">
					<h3>Click on the course code you want to enroll in:</h3>
					<table border="1px" class="table table-striped">
						<tr>
							<th>Course Code</th>
							<th>Course Name</th>
						</tr>
						<c:forEach items="${ courseCodes}" var="course">
							<tr>
								<td><a href="getFacultyCodes.obj?id=${course.courseId }">${course.courseId }</a></td>
								<td>${course.courseName }</td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<br>
					<c:choose>
						<c:when test="${isFacultyAvailable}">
							<form:form action="addNewProgram.obj" modelAttribute="program"
								class="form-horizontal">
								<table border="1px" class="table table-striped">
									<tr>
										<td>Course Code</td>
										<td><form:input path="courseCode" readonly="true"
												value="${courseCode}" class="form-control" /></td>
									</tr>
									<tr>
										<td>Enter faculty Code</td>
										<td><form:select path="facultyCode"
												value="${facultyCode}" class="form-control">
												<form:option value="0">SELECT</form:option>
												<c:forEach items="${ facultyCodes}" var="code">
													<form:option value="${code }">${code} </form:option>
												</c:forEach>
											</form:select> <c:choose>
												<c:when test="${selectFaculty}">
													<span>Please Select Faculty Code</span>
												</c:when>
											</c:choose></td>
									</tr>
									<tr>
										<td>Enter Start Date</td>
										<td><form:input type="date" path="startDate"
												class="form-control" /> <c:choose>
												<c:when test="${selectDate}">
													<span>Please Enter Start Date</span>
												</c:when>
											</c:choose></td>
									</tr>
								</table>
								<input type="Submit" value="Add Program" />
							</form:form>
						</c:when>
						<c:when test="${isFacultyNotAvailable}">SORRY!!! NO FACULTY AVAILABLE FOR THE ABOVE SELECTED COURSE</c:when>
					</c:choose>
				</c:when>
			</c:choose>
		</div>
		<div>
			<c:choose>
				<c:when test="${wantToUpdate}">
					<h3>Update Training Program</h3>
					<form:form action="updateProgram.obj" modelAttribute="program"
						class="form-horizontal">
						<table class="table table-striped">
							<tr>
								<td>Training Code</td>
								<td><form:input path="trainingCode" readonly="true"
										class="form-control" /></td>
							</tr>
							<tr>
								<td>Course Code</td>
								<td><form:input path="courseCode" readonly="true"
										class="form-control" /></td>
							</tr>
							<tr>
								<td>Enter new faculty Code</td>
								<td><form:select path="facultyCode" value="${facultyCode}"
										class="form-control">
										<form:option value="0">SELECT</form:option>
										<c:forEach items="${ facultyCodes}" var="code">
											<form:option value="${code }">${code} </form:option>
										</c:forEach>
									</form:select> <c:choose>
										<c:when test="${facultySelect}">
											<span>Please Select Faculty Code</span>
										</c:when>
									</c:choose></td>
							</tr>
							<tr>
								<td>Enter new Start Date</td>
								<td><form:input type="date" path="startDate"
										class="form-control" /></td>
							</tr>
						</table>
						<input type="Submit" value="Update Program" class="btn btn-info" />
					</form:form>
				</c:when>
			</c:choose>
		</div>

		<!--PARTICIPANT ENROLLMENT WHICH INCLUDES ENROLLING 
		THE PARICIPANT WITH EXIXTING ONE OF TRAINING PROGRAM -->
		<c:choose>
			<c:when test="${alreadyEnrolled }">
				<h5>Participant Already Enrolled. Please Have a Look at the
					Enrolled Participant</h5>
			</c:when>
		</c:choose>
		<div>
			<c:choose>
				<c:when test="${participantList.size()>0}">
					<h6>LIST OF ENROLLED PARTICIPANTS WITH RESPECTIVE CODE</h6>
					<table border="1px" class="table table-striped">
						<tr>
							<th>Enrollment ID</th>
							<th>Training Code</th>
							<th>Participant Id</th>
						</tr>
						<c:forEach items="${participantList}" var="participant">
							<tr>
								<td>${participant.enrollmentId}</td>
								<td>${participant.trainingCode}</td>
								<td>${participant.participantId}</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
			</c:choose>
		</div>


		<div>
			<c:choose>
				<c:when test="${enroll}">
					<h5>Click on Training Code in which You want to enroll
						Participant</h5>
					<table border="1px" class="table table-striped">
						<tr>
							<th>Training Code</th>
							<th>Course Code</th>
							<th>Faculty Code</th>
							<th>Start Date</th>
							<th>End Date</th>
						</tr>
						<c:forEach items="${programList}" var="program">
							<tr>
								<td><a
									href="getParticipantId.obj?id=${program.trainingCode}">${program.trainingCode}</a></td>
								<td>${program.courseCode }</td>
								<td>${program.facultyCode }</td>
								<td>${program.startDate }</td>
								<td>${program.endDate }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
			</c:choose>
		</div>
		<br>
		<div>
			<c:choose>
				<c:when test="${enrolling}">

					<form:form action="enrollParticipant.obj"
						modelAttribute="participant" class="form-horizontal">
						<fieldset>
							<legend>ENROLLMENT OF PROGRAMS TO PARTICIPANT</legend>
							<table border="1px" class="table table-striped">
								<tr>
									<td>Training Code</td>
									<td><form:input path="trainingCode" readonly="true"
											class="form-control" /></td>
								</tr>
								<tr>
									<td>Choose Participant Id</td>
									<td><form:select path="participantId" class="form-control">
											<form:option value="0">SELECT</form:option>
											<c:forEach items="${ participantCodes}" var="code">
												<form:option value="${code }">${code} </form:option>
											</c:forEach>
										</form:select> <c:choose>
											<c:when test="${select}">
												<span>Please Select Participant ID</span>
											</c:when>
										</c:choose></td>
								</tr>
							</table>
							<input type="Submit" value="ENROLL NOW" class="btn btn-info" />
						</fieldset>
					</form:form>

				</c:when>
			</c:choose>
		</div>
	</div>
	<div style="bottom: 0px;"><%@include file="footer.jsp"%></div>
</body>
</html>

