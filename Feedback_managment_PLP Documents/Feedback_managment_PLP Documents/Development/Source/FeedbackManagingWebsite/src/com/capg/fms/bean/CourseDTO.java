package com.capg.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "COURSE_MASTER")
public class CourseDTO {

	@Id
	@SequenceGenerator(name = "course_seq", sequenceName = "course_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	@Min(1)
	@Column(name = "no_of_days")
	private int noOfDays;

	public CourseDTO() {

	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@NotEmpty(message="Course Name should not be empty")
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@NotNull(message="No of Days should be greater than 1")
	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", noOfDays=" + noOfDays + "]";
	}

	public CourseDTO(int courseId, String courseName, int noOfDays) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.noOfDays = noOfDays;
	}

}
