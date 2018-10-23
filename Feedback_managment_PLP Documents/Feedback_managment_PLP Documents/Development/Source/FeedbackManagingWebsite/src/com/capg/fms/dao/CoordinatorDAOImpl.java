package com.capg.fms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.bean.FeedbackReportDTO;
import com.capg.fms.bean.ParticipantDTO;
import com.capg.fms.bean.TrainingProgramDTO;

@Transactional
@Repository
public class CoordinatorDAOImpl implements ICoordinatorDAO {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public List<TrainingProgramDTO> getTrainingProgramList() {
		// TODO Auto-generated method stub
		String query = "SELECT t FROM TrainingProgramDTO t";
		TypedQuery<TrainingProgramDTO> programQuery = eManager.createQuery(
				query, TrainingProgramDTO.class);
		List<TrainingProgramDTO> programList = programQuery.getResultList();
		return programList;
	}

	@Override
	public List<CourseDTO> getAvailableCourses() {
		String query = "SELECT c FROM CourseDTO c";
		TypedQuery<CourseDTO> courseQuery = eManager.createQuery(query,
				CourseDTO.class);
		List<CourseDTO> courseList = courseQuery.getResultList();

		return courseList;
	}

	@Override
	public List<FacultyDTO> getFacultyList() {
		String query = "SELECT f FROM FacultyDTO f";
		TypedQuery<FacultyDTO> facultyQuery = eManager.createQuery(query,
				FacultyDTO.class);
		List<FacultyDTO> facultyList = facultyQuery.getResultList();
		return facultyList;
	}

	@Override
	public int addNewProgram(TrainingProgramDTO trainingProgram) {
		eManager.persist(trainingProgram);
		return trainingProgram.getTrainingCode();
	}

	@Override
	public TrainingProgramDTO updateTrainingProgram(
			TrainingProgramDTO trainingProgram) {
		TrainingProgramDTO updatedTrainingProgram = eManager
				.merge(trainingProgram);
		return updatedTrainingProgram;
	}

	@Override
	public TrainingProgramDTO getTrainingProgramByCode(int trainingCode) {
		// TODO Auto-generated method stub
		TrainingProgramDTO trainingProgram = eManager.find(
				TrainingProgramDTO.class, trainingCode);
		return trainingProgram;
	}

	@Override
	public void deleteTrainingProgram(int trainingCode) {
		TrainingProgramDTO program = eManager.find(TrainingProgramDTO.class,
				trainingCode);
		eManager.remove(program);
	}

	@Override
	public int enrollParticipant(ParticipantDTO participant) {
		eManager.persist(participant);
		return participant.getEnrollmentId();
	}

	@Override
	public List<CourseDTO> getCourseList() {
		List<CourseDTO> courseList = eManager.createQuery(
				"SELECT c FROM CourseDTO c", CourseDTO.class).getResultList();
		return courseList;
	}

	@Override
	public List<Integer> getFacultyCodes(int courseCode) {
		// TODO Auto-generated method stub
		String courseName = eManager.find(CourseDTO.class, courseCode)
				.getCourseName();
		List<FacultyDTO> facultyList = getFacultyList();
		List<Integer> facultyCodes = new ArrayList<Integer>();
		for (FacultyDTO faculty : facultyList) {
			String skills[] = faculty.getSkillSet().split(",");
			for (String skill : skills) {
				if (skill.equals(courseName))
					facultyCodes.add(faculty.getFacultyId());
			}
		}
		return facultyCodes;
	}

	@Override
	public List<Integer> getAllParticipantId() {
		String query = "SELECT e.employeeId FROM EmployeeDTO e WHERE e.role=:role";
		TypedQuery<Integer> participantQuery = eManager.createQuery(query,
				Integer.class);
		participantQuery.setParameter("role", "participant");
		List<Integer> participantCodes = participantQuery.getResultList();
		return participantCodes;
	}

	@Override
	public List<ParticipantDTO> getAllEnrolledParticipant() {
		// TODO Auto-generated method stub
		List<ParticipantDTO> participantList = eManager.createQuery(
				"SELECT p FROM ParticipantDTO p", ParticipantDTO.class)
				.getResultList();

		return participantList;
	}

	@Override
	public int getNoOfDays(int courseCode) {
		CourseDTO course = eManager.find(CourseDTO.class, courseCode);
		return course.getNoOfDays();
	}

	// /////
	@Override
	public List<FeedbackReportDTO> getAverageFeedbackReport() {

		String query = "SELECT t.trainingCode FROM TrainingProgramDTO t";
		TypedQuery<Integer> rs = eManager.createQuery(query, Integer.class);
		List<Integer> tCodes = rs.getResultList();
		
		List<FeedbackReportDTO> feedbacks = new ArrayList<FeedbackReportDTO>();
		
		for(int i : tCodes){
			FeedbackReportDTO feedbackReport = new FeedbackReportDTO();
			feedbackReport.setTrainingCode(i);
			feedbackReport.setFacultyName(getFacutyName(i));
			
			try {
				List<Double> averageFeedback = new ArrayList<Double>();
				averageFeedback = getFeedbackbyTrainingCode(i);
				feedbackReport.setAvgPrsComm(averageFeedback.get(0));
				feedbackReport.setAvgClrfyDbts(averageFeedback.get(1));
				feedbackReport.setAvgTm(averageFeedback.get(2));
				feedbackReport.setAvgHndOut(averageFeedback.get(3));
				feedbackReport.setAvgHwSwNtwrk(averageFeedback.get(4));
				feedbacks.add(feedbackReport);
			} catch (Exception e) {
			}
		}

		return feedbacks;

	}

	@Override
	public List<Double> getFeedbackbyTrainingCode(int index) {

		List<Double> flist = new ArrayList<>();

		String query1 = "SELECT avg(f.prsComm) FROM FeedbackDTO f WHERE f.trainingCode = :i ";
		String query2 = "SELECT avg(f.clrfyDbts) FROM FeedbackDTO f WHERE f.trainingCode = :i";
		String query3 = "SELECT avg(f.tm) FROM FeedbackDTO f where f.trainingCode = :i";
		String query4 = "SELECT avg(f.hndOut) FROM FeedbackDTO f where f.trainingCode = :i";
		String query5 = "SELECT avg(f.hwSwNtwrk) FROM FeedbackDTO f where f.trainingCode = :i";

		// 1
		TypedQuery<Double> avgPrsComm = eManager.createQuery(query1,
				Double.class);
		avgPrsComm.setParameter("i", index);
		Double listAvgPrsComm = avgPrsComm.getSingleResult();
		flist.add(listAvgPrsComm);
		// 2
		TypedQuery<Double> avgClrfyDbts = eManager.createQuery(query2,
				Double.class);
		avgClrfyDbts.setParameter("i", index);
		Double listAvgClrfyDbts = avgClrfyDbts.getSingleResult();
		flist.add(listAvgClrfyDbts);
		// 3
		TypedQuery<Double> avgTm = eManager.createQuery(query3, Double.class);
		avgTm.setParameter("i", index);
		Double listAvgTm = avgTm.getSingleResult();
		flist.add(listAvgTm);
		// 4
		TypedQuery<Double> avgHndOut = eManager.createQuery(query4,
				Double.class);
		avgHndOut.setParameter("i", index);
		Double listAvgHndOut = avgHndOut.getSingleResult();
		flist.add(listAvgHndOut);

		// 5
		TypedQuery<Double> avgHwSwNtwrk = eManager.createQuery(query5,
				Double.class);
		avgHwSwNtwrk.setParameter("i", index);
		Double listAvgHwSwNtwrk = avgHwSwNtwrk.getSingleResult();
		flist.add(listAvgHwSwNtwrk);

		return flist;

	}

	@Override
	public String getFacutyName(int index) {
		String facultyName = null;
		Integer facultyCode = 0;

		String query = "SELECT t.facultyCode FROM TrainingProgramDTO t where t.trainingCode= :i";

		TypedQuery<Integer> fCode = eManager.createQuery(query, Integer.class);
		fCode.setParameter("i", index);
		facultyCode = fCode.getSingleResult();

		String query1 = "SELECT e.employeeName FROM EmployeeDTO e where e.employeeId=:in";

		TypedQuery<String> fName = eManager.createQuery(query1, String.class);
		fName.setParameter("in", facultyCode);
		facultyName = fName.getSingleResult();
		return facultyName;
	}

	@Override
	public List<Integer> getTCodes(int facultyID1) {

		String query = "SELECT t.trainingCode FROM TrainingProgramDTO t where t.facultyCode= :i";
		TypedQuery<Integer> rs = eManager.createQuery(query, Integer.class);
		rs.setParameter("i", facultyID1);
		List<Integer> tCodes = rs.getResultList();

		return tCodes;

	}

	@Override
	public List<EmployeeDTO> facultyDetails() {

		String role = "faculty";
		String query = " SELECT e FROM EmployeeDTO e where e.role=:s ";
		TypedQuery<EmployeeDTO> rs = eManager.createQuery(query,
				EmployeeDTO.class);
		rs.setParameter("s", role);
		List<EmployeeDTO> lfaculty = rs.getResultList();

		return lfaculty;
	}

	@Override
	public List<FeedbackDTO> getAllFeedbackbyTrainingCode(int index) {

		String query = " SELECT f FROM FeedbackDTO f where f.trainingCode=:in ";
		TypedQuery<FeedbackDTO> rs = eManager.createQuery(query,
				FeedbackDTO.class);
		rs.setParameter("in", index);
		List<FeedbackDTO> feedback = rs.getResultList();
		return feedback;
	}

	@Override
	public String getParticipantName(int participantId) {

		String query = " SELECT e.employeeName FROM EmployeeDTO e where e.employeeId=:in";
		TypedQuery<String> rs = eManager.createQuery(query, String.class);
		rs.setParameter("in", participantId);
		String participantName = rs.getSingleResult();

		return participantName;
	}

	@Override
	public List<Integer> getTrainingCodes(int participantId) {
		String result = "SELECT f.trainingCode FROM FeedbackDTO f where f.participantId=:id";
		TypedQuery<Integer> query2 = eManager
				.createQuery(result, Integer.class);
		query2.setParameter("id", participantId);
		List<Integer> feedbackDone = query2.getResultList();
		List<Integer> getAssignedCourses = getAssignedCourses(participantId);
		getAssignedCourses.removeAll(feedbackDone);
		return getAssignedCourses;
	}

	public List<Integer> getAssignedCourses(int participantId) {

		String result = "SELECT p.trainingCode FROM ParticipantDTO p where p.participantId=:id";
		TypedQuery<Integer> query = eManager.createQuery(result, Integer.class);
		query.setParameter("id", participantId);
		List<Integer> courses = query.getResultList();
		return courses;

	}
}
