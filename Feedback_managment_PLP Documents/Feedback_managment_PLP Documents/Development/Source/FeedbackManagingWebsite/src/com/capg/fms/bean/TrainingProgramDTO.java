package com.capg.fms.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING_PROGRAM")
public class TrainingProgramDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_generator")
	@SequenceGenerator(name = "program_generator", sequenceName = "program_seq", allocationSize = 1009)
	@Column(name = "training_Code")
	private int trainingCode;
	@Column(name = "course_Code")
	private int courseCode;
	@Column(name = "faculty_code")
	private int facultyCode;

	
	@Column(name = "start_Date")
	private Date startDate;

	@Column(name = "end_Date")
	private Date endDate;

	public TrainingProgramDTO() {
	}

	public TrainingProgramDTO(int trainingCode, int courseCode,
			int facultyCode, Date startDate, Date endDate) {
		this.trainingCode = trainingCode;
		this.courseCode = courseCode;
		this.facultyCode = facultyCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getTrainingCode() {
		return trainingCode;
	}

	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public int getFacultyCode() {
		return facultyCode;
	}

	public void setFacultyCode(int facultyCode) {
		this.facultyCode = facultyCode;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "TrainingProgramDTO [trainingCode=" + trainingCode
				+ ", courseCode=" + courseCode + ", facultyCode=" + facultyCode
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
