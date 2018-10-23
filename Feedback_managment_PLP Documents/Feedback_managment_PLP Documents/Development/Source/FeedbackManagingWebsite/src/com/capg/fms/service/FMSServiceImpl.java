package com.capg.fms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.bean.EmployeeDTO;
import com.capg.fms.dao.IFMSDao;

@Transactional
@Service
public class FMSServiceImpl implements IFMSService {
	
	@Autowired
	private IFMSDao iFmsDao;

	@Override
	public EmployeeDTO getEmployee(int userId, String password) {
		// TODO Auto-generated method stub
		return iFmsDao.getEmployee(userId,password);
	}

}
