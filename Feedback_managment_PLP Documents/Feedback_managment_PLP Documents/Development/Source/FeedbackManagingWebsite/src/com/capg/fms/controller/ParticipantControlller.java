package com.capg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.service.IParticipantService;

@Controller
public class ParticipantControlller {
	
	@Autowired
	private IParticipantService participantService;
	
	@RequestMapping("/participantPage")
	public String viewParticipantPage(@RequestParam ("id") int id, Model model) 
	{
		
		List<Integer> assignedCourses=participantService.getAssignedCourses(id);
		if(assignedCourses.size()==0){
			model.addAttribute("noCourses", true);
			return "ParticipantPage";
		}
		model.addAttribute("assignedCourses",assignedCourses);
	
		List<Integer> feedbackRequired=participantService.getCourses(id);
		if(feedbackRequired.size()==0){
			model.addAttribute("feedbackSubmitted", true);
			return "ParticipantPage";
		}
		model.addAttribute("feedbackForm", true);
		model.addAttribute("feedbackrequired",feedbackRequired);
		
		model.addAttribute("participantId",id);
		
		model.addAttribute("feedback",new FeedbackDTO());
		return "ParticipantPage";
		
	}
	@RequestMapping("/submitFeedback")
	public String submitFeedback(@ModelAttribute ("feedback") FeedbackDTO feedback,BindingResult bindingResult,Model model)
	{
		//feedback.setFeedbackId(3);

		
		participantService.submitFeedback(feedback);
		model.addAttribute("status",true);
		List<Integer> assignedCourses=participantService.getAssignedCourses(feedback.getParticipantId());
		model.addAttribute("assignedCourses",assignedCourses);
	
		List<Integer> feedbackRequired=participantService.getCourses(feedback.getParticipantId());
		if(feedbackRequired.size()==0){
			model.addAttribute("feedbackSubmitted", true);
			return "ParticipantPage";
		}
		model.addAttribute("feedbackForm", true);
		model.addAttribute("feedbackrequired",feedbackRequired);
		return "ParticipantPage";	
	}
	
	
}
