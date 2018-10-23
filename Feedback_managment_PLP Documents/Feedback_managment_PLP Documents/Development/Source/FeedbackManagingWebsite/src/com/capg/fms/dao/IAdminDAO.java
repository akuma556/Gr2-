package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.bean.CourseDTO;
import com.capg.fms.bean.FacultyDTO;

public interface IAdminDAO {

	FacultyDTO getFacultyDetails(int facultyId);

	int addNewCourse(CourseDTO course);

	List<FacultyDTO> getFacultyList();

	void updateFacultySkills(FacultyDTO faculty);

	List<CourseDTO> getCourseList();

	CourseDTO getCourse(int id);

	void updateCourse(CourseDTO course);

	void removeCourse(int id);

}
