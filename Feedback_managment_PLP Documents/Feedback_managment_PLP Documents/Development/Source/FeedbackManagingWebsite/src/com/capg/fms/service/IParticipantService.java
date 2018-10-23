package com.capg.fms.service;

import java.util.List;

import com.capg.fms.bean.FeedbackDTO;

public interface IParticipantService {

	List<Integer> getAssignedCourses(int id);

	List<Integer> getCourses(int id);

	void submitFeedback(FeedbackDTO feedback);

}
