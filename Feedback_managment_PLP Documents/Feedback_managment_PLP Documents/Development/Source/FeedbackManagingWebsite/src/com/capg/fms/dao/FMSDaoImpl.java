package com.capg.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.EmployeeDTO;

@Transactional
@Repository
public class FMSDaoImpl implements IFMSDao {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public EmployeeDTO getEmployee(int userId, String password) {
		
		EmployeeDTO employee;
		try {
			employee = eManager.find(EmployeeDTO.class, userId);
			if(employee.getPassword().equals(password))
				return employee;
		} catch (Exception e) {
		}
		return null;
	}
}
