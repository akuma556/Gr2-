package com.capg.fms.dao;

import com.capg.fms.bean.EmployeeDTO;

public interface IFMSDao {

	EmployeeDTO getEmployee(int userId, String password);

}
