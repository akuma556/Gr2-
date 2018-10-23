package com.capg.fms.service;

import java.util.List;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.bean.FeedbackReportDTO;
import com.capg.fms.bean.ParticipantDTO;
import com.capg.fms.bean.TrainingProgramDTO;

public interface ICoordinatorService {

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
	
	boolean isParticipantEnrolledToTrainingCode(ParticipantDTO participant);
	
	long getNoOfDays(int courseCode);

	//Feedback Methods
	List<FeedbackReportDTO> getAverageFeedbackReport();

	List<Double> getFeedbackbyTrainingCode(int index);

	String getFacutyName(int index);

	List<FeedbackDTO> getAllFeedbackbyTrainingCode(int index);

	String getParticipantName(int participantId);

	List<Integer> getTCodes(int facultyID1);

	List<EmployeeDTO> facultyDetails();

	List<Integer> getTrainingCodes(int i);
}
