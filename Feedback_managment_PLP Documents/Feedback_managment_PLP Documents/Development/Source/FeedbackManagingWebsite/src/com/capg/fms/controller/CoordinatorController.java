package com.capg.fms.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.bean.FeedbackReportDTO;
import com.capg.fms.bean.ParticipantDTO;
import com.capg.fms.bean.TrainingProgramDTO;
import com.capg.fms.service.ICoordinatorService;

@Controller
public class CoordinatorController {

	@Autowired
	private ICoordinatorService iCService;

	List<TrainingProgramDTO> programList;

	@RequestMapping("/trainingProgramMaintenance")
	public String programMaintenance(Model model) {
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		model.addAttribute("viewProgram", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/getTrainingProgram")
	public String getTrainingProgram(@RequestParam("id") int trainingCode,
			Model model) {
		TrainingProgramDTO trainingProgram = iCService
				.getTrainingProgramByCode(trainingCode);
		List<Integer> facultyCodes = iCService.getFacultyCodes(trainingProgram.getCourseCode());
		model.addAttribute("facultyCodes", facultyCodes);
		model.addAttribute("program", trainingProgram);
		model.addAttribute("programList", programList);
		model.addAttribute("wantToUpdate", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/updateProgram")
	public String updateTrainingProgram(
			@ModelAttribute("program") TrainingProgramDTO trainingProgram,
			BindingResult bindingResult, Model model) {
		LocalDate startDate = trainingProgram
				.getStartDate()
				.toLocalDate()
				.plusDays(
						iCService.getNoOfDays(trainingProgram.getCourseCode()));
		Date endDate = Date.valueOf(startDate);
		trainingProgram.setEndDate(endDate);
		if(trainingProgram.getFacultyCode()==0) {
			List<Integer> facultyCodes = iCService.getFacultyCodes(trainingProgram.getCourseCode());
			model.addAttribute("facultyCodes", facultyCodes);
			model.addAttribute("program", trainingProgram);
			model.addAttribute("programList", programList);
			model.addAttribute("wantToUpdate", true);
			model.addAttribute("facultySelect", true);
			return "CoordinatorPage";
		}
		TrainingProgramDTO updatedProgram = iCService
				.updateTrainingProgram(trainingProgram);
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		model.addAttribute("program", updatedProgram);
		model.addAttribute("updated", true);
		model.addAttribute("viewProgram", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/addProgram")
	public String addProgram(Model model) {
		List<CourseDTO> courseCodes = iCService.getCourseList();

		model.addAttribute("program", new TrainingProgramDTO());
		model.addAttribute("add", true);
		model.addAttribute("courseCodes", courseCodes);
		return "CoordinatorPage";
	}

	@RequestMapping("/getFacultyCodes")
	public String getFacultyCodes(@RequestParam("id") int courseCode,
			Model model) {
		TrainingProgramDTO program = new TrainingProgramDTO();
		program.setCourseCode(courseCode);
		List<Integer> facultyCodes = iCService.getFacultyCodes(courseCode);
		if (facultyCodes.isEmpty()) {
			List<CourseDTO> courseCodes = iCService.getCourseList();
			model.addAttribute("program", new TrainingProgramDTO());
			model.addAttribute("add", true);
			model.addAttribute("courseCodes", courseCodes);
			model.addAttribute("isFacultyNotAvailable", true);
			return "CoordinatorPage";
		} else {
			model.addAttribute("isFacultyAvailable", true);
			List<CourseDTO> courseCodes = iCService.getCourseList();
			model.addAttribute("courseCodes", courseCodes);
			model.addAttribute("facultyCodes", facultyCodes);
			model.addAttribute("program", program);
			model.addAttribute("add", true);
			return "CoordinatorPage";
		}
	}

	@RequestMapping("/addNewProgram")
	public String addNewProgram(
			@ModelAttribute("program") TrainingProgramDTO trainingProgram,
			BindingResult bindingResult, Model model) {
		List<Integer> facultyCodes = iCService.getFacultyCodes(trainingProgram
				.getCourseCode());
		if (trainingProgram.getFacultyCode() == 0
				|| trainingProgram.getStartDate() == null) {
			if ((trainingProgram.getFacultyCode() == 0 && trainingProgram
					.getStartDate() == null)) {
				model.addAttribute("selectDate", true);
				model.addAttribute("selectFaculty", true);
			}

			if (trainingProgram.getStartDate() == (null)) {
				model.addAttribute("selectDate", true);
			} else if (trainingProgram.getFacultyCode() == 0) {
				model.addAttribute("selectFaculty", true);
			}
			model.addAttribute("isFacultyAvailable", true);
			List<CourseDTO> courseCodes = iCService.getCourseList();
			model.addAttribute("courseCodes", courseCodes);
			model.addAttribute("facultyCodes", facultyCodes);
			model.addAttribute("program", trainingProgram);
			model.addAttribute("add", true);
			return "CoordinatorPage";
		}
		LocalDate startDate = trainingProgram
				.getStartDate()
				.toLocalDate()
				.plusDays(
						iCService.getNoOfDays(trainingProgram.getCourseCode()));
		Date endDate = Date.valueOf(startDate);
		trainingProgram.setEndDate(endDate);
		int addedTrainingCode = iCService.addNewProgram(trainingProgram);
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		model.addAttribute("addedCode", addedTrainingCode);
		model.addAttribute("viewProgram", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/deleteTrainingProgram")
	public String deleteTrainingProgram(@RequestParam("id") int trainingCode,
			Model model) {
		iCService.deleteTrainingProgram(trainingCode);
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		model.addAttribute("viewProgram", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/participantEnrollment")
	public String getTrainingProgramForEnrollment(Model model) {
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		List<ParticipantDTO> participantList = iCService
				.getAllEnrolledParticipant();
		model.addAttribute("participantList", participantList);
		model.addAttribute("enroll", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/getParticipantId")
	public String getParticipantId(@RequestParam("id") int trainingCode,
			Model model) {
		ParticipantDTO participant = new ParticipantDTO();
		programList = iCService.getTrainingProgramList();
		model.addAttribute("programList", programList);
		List<Integer> participantCodes = iCService.getAllParticipantId();
		participant.setTrainingCode(trainingCode);
		model.addAttribute("participantCodes", participantCodes);
		model.addAttribute("participant", participant);
		model.addAttribute("enrolling", true);
		return "CoordinatorPage";
	}

	@RequestMapping("/enrollParticipant")
	public String enrollParticipant(
			@ModelAttribute("participant") ParticipantDTO participant,
			BindingResult bindingResult, Model model) {

		if (participant.getParticipantId() == 0) {
			programList = iCService.getTrainingProgramList();
			model.addAttribute("programList", programList);
			model.addAttribute("enroll", true);
			List<Integer> participantCodes = iCService.getAllParticipantId();
			model.addAttribute("participantCodes", participantCodes);
			model.addAttribute("participant", participant);
			model.addAttribute("select", true);
			model.addAttribute("enrolling", true);
			return "CoordinatorPage";
		}
		boolean enrolled = iCService
				.isParticipantEnrolledToTrainingCode(participant);
		if (enrolled) {
			model.addAttribute("alreadyEnrolled", true);
			List<ParticipantDTO> participantList = iCService
					.getAllEnrolledParticipant();
			model.addAttribute("participantList", participantList);
			model.addAttribute("viewEnrolledParticipant", true);
			programList = iCService.getTrainingProgramList();
			model.addAttribute("programList", programList);
			model.addAttribute("enroll", true);
			return "CoordinatorPage";
		} else {
			iCService.enrollParticipant(participant);
			List<ParticipantDTO> participantList = iCService
					.getAllEnrolledParticipant();
			model.addAttribute("participantList", participantList);
			return "CoordinatorPage";
		}

	}

	@RequestMapping("/feedbackReport")
	public String feedbackReport() {
		return "FeedbackPage";
	}

	@RequestMapping("/allFeedbacks")
	public String allFeedbacks(Model model) {

		model.addAttribute("feedback", 1);
		List<FeedbackReportDTO> feedbacks = iCService
				.getAverageFeedbackReport();
		model.addAttribute("feedbackReport", feedbacks);
		return "FeedbackPage";
	}

	@RequestMapping("/feedbackByFacultyID")
	public String getFeedbackByFacultyID(Model model) {
		List<EmployeeDTO> facultyList = iCService.facultyDetails();
		model.addAttribute("facultyList", facultyList);
		model.addAttribute("feedbackFaculty", true);
		return "FeedbackPage";
	}

	@RequestMapping("/getFacultyFeedback")
	public String getFacultyFeedback(@RequestParam("id") int facultyId,
			Model model) {
		List<Integer> tCodes = iCService.getTCodes(facultyId);
		List<FeedbackReportDTO> feedbacks = iCService
				.getAverageFeedbackReport();
		List<FeedbackReportDTO> feedbackFacultyList = new ArrayList<FeedbackReportDTO>();
		for (int tCode : tCodes) {
			for (FeedbackReportDTO feedback : feedbacks) {
				if (tCode == feedback.getTrainingCode()) {
					feedbackFacultyList.add(feedback);
				}
			}
		}
		model.addAttribute("feedbackFacultyList", feedbackFacultyList);
		model.addAttribute("feedback", 2);
		List<EmployeeDTO> facultyList = iCService.facultyDetails();
		model.addAttribute("facultyList", facultyList);
		model.addAttribute("feedbackFaculty", true);
		return "FeedbackPage";
	}
	
	@RequestMapping("/feedbackDefaulters")
	public String getFeedbackDefaulters(Model model){
		List<Integer> participantList = iCService.getAllParticipantId();
		List<FeedbackDTO> feedbackReport = new ArrayList<FeedbackDTO>();
		for(int i: participantList){
			List<Integer> trainingCodes = iCService.getTrainingCodes(i);
			for(int j: trainingCodes){
				FeedbackDTO feedback = new FeedbackDTO();
				feedback.setParticipantId(i);
				feedback.setTrainingCode(j);
				feedbackReport.add(feedback);
			}
		}
		model.addAttribute("report", feedbackReport);
		model.addAttribute("feedback", 3);
		return "FeedbackPage";
	}
}
