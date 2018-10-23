package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.FeedbackDTO;

@Transactional
@Repository
public class ParticipantDAOImpl implements IParticipantDAO {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public List<Integer> getAssignedCourses(int id) {

		String result = "SELECT p.trainingCode FROM ParticipantDTO p WHERE p.participantId=:id";
		TypedQuery<Integer> query = eManager.createQuery(result, Integer.class);
		query.setParameter("id", id);
		List<Integer> courses = query.getResultList();
		return courses;

	}

	@Override
	public List<Integer> getCourses(int id) {

		String result = "SELECT f.trainingCode FROM FeedbackDTO f WHERE f.participantId=:id";
		TypedQuery<Integer> query2 = eManager
				.createQuery(result, Integer.class);
		query2.setParameter("id", id);
		List<Integer> feedbackDone = query2.getResultList();
		List<Integer> getAssignedCourses = getAssignedCourses(id);
		getAssignedCourses.removeAll(feedbackDone);
		return getAssignedCourses;

	}

	@Override
	public void submitFeedback(FeedbackDTO feedback) {
		eManager.persist(feedback);

	}

}
