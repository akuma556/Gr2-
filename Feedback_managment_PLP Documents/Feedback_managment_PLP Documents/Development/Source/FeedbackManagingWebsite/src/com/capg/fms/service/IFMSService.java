package com.capg.fms.service;

import com.capg.fms.bean.EmployeeDTO;

public interface IFMSService {

	EmployeeDTO getEmployee(int userId, String password);

}
