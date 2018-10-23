package com.capg.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_skill")
public class FacultyDTO {

	@Id
	@Column(name = "faculty_id")
	private int facultyId;
	@Column(name = "skill_set")
	private String skillSet;
	
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", skillSet=" + skillSet
				+ "]";
	}
	
	public FacultyDTO() {
	}
	
	public FacultyDTO(int facultyId,String skillSet) {
		this.facultyId = facultyId;
		this.skillSet = skillSet;
	}
	
	
}
