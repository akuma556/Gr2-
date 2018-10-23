package com.capg.fms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.FacultyDTO;
import com.capg.fms.dao.IAdminDAO;

@Transactional
@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDAO iAdminDao;
	
	@Override
	public FacultyDTO getFacultyDetails(int facultyId) {

		return iAdminDao.getFacultyDetails(facultyId);
	}

	@Override
	public int addNewCourse(CourseDTO course) {
		// TODO Auto-generated method stub
		return iAdminDao.addNewCourse(course);
	}

	@Override
	public List<FacultyDTO> getFacultyList() {
		// TODO Auto-generated method stub
		return iAdminDao.getFacultyList();
	}

	@Override
	public void updateFacultySkills(FacultyDTO faculty) {
		// TODO Auto-generated method stub
		iAdminDao.updateFacultySkills(faculty);
	}

	@Override
	public List<CourseDTO> getCourseList() {
		// TODO Auto-generated method stub
		return iAdminDao.getCourseList();
	}

	@Override
	public CourseDTO getCourse(int id) {
		// TODO Auto-generated method stub
		return iAdminDao.getCourse(id);
	}

	@Override
	public void updateCourse(CourseDTO course) {

		iAdminDao.updateCourse(course);
	}

	@Override
	public void removeCourse(int id) {
		// TODO Auto-generated method stub
		iAdminDao.removeCourse(id);
	}

}
