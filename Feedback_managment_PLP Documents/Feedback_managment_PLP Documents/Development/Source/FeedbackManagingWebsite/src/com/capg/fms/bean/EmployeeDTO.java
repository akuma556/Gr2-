package com.capg.fms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "EMPLOYEE_MASTER")
public class EmployeeDTO {

	@Id
	@Column(name = "Employee_Id")
	private int employeeId;
	@Column(name = "Employee_name")
	private String employeeName;
	private String password;
	private String role;

	public EmployeeDTO() {
	}

	public EmployeeDTO(int employeeId, String employeeName, String password, String role) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@NotEmpty(message="Password cannot be empty")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", role=" + role + "]";
	}

}
