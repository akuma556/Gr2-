package com.capg.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.bean.FeedbackDTO;
import com.capg.fms.dao.IParticipantDAO;


@Transactional
@Service
public class ParticipantServiceImpl implements IParticipantService {

	@Autowired
	IParticipantDAO iParticipantDAO;
	@Override
	public List<Integer> getAssignedCourses(int id) {
		// TODO Auto-generated method stub
		
		return iParticipantDAO.getAssignedCourses(id);
	}
	@Override
	public List<Integer> getCourses(int id) {
		// TODO Auto-generated method stub
		return iParticipantDAO.getCourses(id);
	}
	@Override
	public void submitFeedback(FeedbackDTO feedback) {
		// TODO Auto-generated method stub
		iParticipantDAO.submitFeedback(feedback);
	}

}
