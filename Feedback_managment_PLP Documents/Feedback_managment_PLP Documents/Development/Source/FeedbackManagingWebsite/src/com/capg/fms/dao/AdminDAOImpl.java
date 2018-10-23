package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.FacultyDTO;

@Transactional
@Repository
public class AdminDAOImpl implements IAdminDAO {

	@PersistenceContext
	private EntityManager eManager; 
	
	@Override
	public FacultyDTO getFacultyDetails(int facultyId) {
		
		FacultyDTO faculty = eManager.find(FacultyDTO.class, facultyId);
		return faculty;
	}

	@Override
	public int addNewCourse(CourseDTO course) {
		eManager.persist(course);
		
		return course.getCourseId();
	}

	@Override
	public List<FacultyDTO> getFacultyList() {
		
		List<FacultyDTO> facultyList = null;
		String query = "SELECT f FROM FacultyDTO f";
		TypedQuery<FacultyDTO> facultyQuery = eManager.createQuery(query, FacultyDTO.class);
		facultyList = facultyQuery.getResultList();
		return facultyList;
	}

	@Override
	public void updateFacultySkills(FacultyDTO faculty) {
		eManager.merge(faculty);
	}

	@Override
	public List<CourseDTO> getCourseList() {
		List<CourseDTO> courseList = null;
		String query = "SELECT c FROM CourseDTO c";
		TypedQuery<CourseDTO> courseQuery = eManager.createQuery(query, CourseDTO.class);
		courseList = courseQuery.getResultList();
		return courseList;
	}

	@Override
	public CourseDTO getCourse(int id) {
		CourseDTO course = eManager.find(CourseDTO.class, id);
		return course;
	}

	@Override
	public void updateCourse(CourseDTO course) {

		eManager.merge(course);
	}

	@Override
	public void removeCourse(int id) {

		eManager.remove(eManager.find(CourseDTO.class, id));
	}

}
