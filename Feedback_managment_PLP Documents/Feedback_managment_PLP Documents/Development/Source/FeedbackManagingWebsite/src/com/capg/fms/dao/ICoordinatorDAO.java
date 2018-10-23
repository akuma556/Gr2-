package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.bean.FeedbackReportDTO;
import com.capg.fms.bean.ParticipantDTO;
import com.capg.fms.bean.TrainingProgramDTO;

public interface ICoordinatorDAO {

	List<TrainingProgramDTO> getTrainingProgramList();

	List<CourseDTO> getAvailableCourses();

	List<FacultyDTO> getFacultyList();

	int addNewProgram(TrainingProgramDTO trainingProgram);

	TrainingProgramDTO updateTrainingProgram(TrainingProgramDTO trainingProgram);

	TrainingProgramDTO getTrainingProgramByCode(int trainingCode);

	void deleteTrainingProgram(int trainingCode);

	int enrollParticipant(ParticipantDTO participant);

	List<CourseDTO> getCourseList();

	List<Integer> getFacultyCodes(int courseCode);

	List<Integer> getAllParticipantId();

	List<ParticipantDTO> getAllEnrolledParticipant();

	int getNoOfDays(int courseCode);

	//Feedback Methods
	List<FeedbackReportDTO> getAverageFeedbackReport();
	
	List<Double> getFeedbackbyTrainingCode(int index);

	String getFacutyName(int index);

	List<Integer> getTCodes(int facultyID1);

	List<EmployeeDTO> facultyDetails();

	List<FeedbackDTO> getAllFeedbackbyTrainingCode(int index);

	String getParticipantName(int participantId);

	List<Integer> getTrainingCodes(int participantId);

}
