package com.capg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.bean.FeedbackReportDTO;
import com.capg.fms.bean.ParticipantDTO;
import com.capg.fms.bean.TrainingProgramDTO;
import com.capg.fms.dao.ICoordinatorDAO;

@Transactional
@Service
public class CoordinatorServiceImpl implements ICoordinatorService {

	@Autowired
	private ICoordinatorDAO iCDao;

	@Override
	public List<TrainingProgramDTO> getTrainingProgramList() {
		return iCDao.getTrainingProgramList();
	}

	@Override
	public List<CourseDTO> getAvailableCourses() {
		return iCDao.getAvailableCourses();
	}

	@Override
	public List<FacultyDTO> getFacultyList() {
		return iCDao.getFacultyList();
	}

	@Override
	public int addNewProgram(TrainingProgramDTO trainingProgram) {
		return iCDao.addNewProgram(trainingProgram);
	}

	@Override
	public TrainingProgramDTO updateTrainingProgram(TrainingProgramDTO trainingProgram) {
		return iCDao.updateTrainingProgram(trainingProgram);
	}

	@Override
	public TrainingProgramDTO getTrainingProgramByCode(int trainingCode) {
		return iCDao.getTrainingProgramByCode(trainingCode);
	}

	@Override
	public void deleteTrainingProgram(int trainingCode) {
		iCDao.deleteTrainingProgram(trainingCode);
	}

	@Override
	public int enrollParticipant(ParticipantDTO participant) {
		return iCDao.enrollParticipant(participant);
	}

	@Override
	public List<CourseDTO> getCourseList() {
		return iCDao.getCourseList();
	}

	@Override
	public List<Integer> getFacultyCodes(int courseCode) {
		return iCDao.getFacultyCodes(courseCode);
	}

	@Override
	public List<Integer> getAllParticipantId() {
		return iCDao.getAllParticipantId();
	}

	@Override
	public List<ParticipantDTO> getAllEnrolledParticipant() {
		return iCDao.getAllEnrolledParticipant();
	}

	@Override
	public boolean isParticipantEnrolledToTrainingCode(ParticipantDTO participantDTO) {
		List<ParticipantDTO> participantList = getAllEnrolledParticipant();
		for (ParticipantDTO participant : participantList) {
			if ((participant.getParticipantId() == participantDTO.getParticipantId())
					&& (participant.getTrainingCode() == participantDTO.getTrainingCode())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public long getNoOfDays(int courseCode) {
		return iCDao.getNoOfDays(courseCode);
	}

	@Override
	public List<FeedbackReportDTO> getAverageFeedbackReport() {
		return iCDao.getAverageFeedbackReport();
	}

	@Override
	public List<Double> getFeedbackbyTrainingCode(int index) {
		return iCDao.getFeedbackbyTrainingCode(index);
	}

	@Override
	public String getFacutyName(int index) {
		return iCDao.getFacutyName(index);
	}

	@Override
	public List<Integer> getTCodes(int facultyID1) {
		return iCDao.getTCodes(facultyID1);
	}

	@Override
	public List<EmployeeDTO> facultyDetails() {
		return iCDao.facultyDetails();
	}

	@Override
	public List<FeedbackDTO> getAllFeedbackbyTrainingCode(int index) {
		return iCDao.getAllFeedbackbyTrainingCode(index);
	}

	@Override
	public String getParticipantName(int participantId) {
		return iCDao.getParticipantName(participantId);
	}

	@Override
	public List<Integer> getTrainingCodes(int participantId) {
		return iCDao.getTrainingCodes(participantId);
	}

	
}
