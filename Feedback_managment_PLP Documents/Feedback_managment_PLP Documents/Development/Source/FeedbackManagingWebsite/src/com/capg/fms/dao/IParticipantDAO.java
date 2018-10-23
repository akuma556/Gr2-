package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.bean.FeedbackDTO;

public interface IParticipantDAO {

	List<Integer> getAssignedCourses(int id);

	List<Integer> getCourses(int id);

	void submitFeedback(FeedbackDTO feedback);

}
