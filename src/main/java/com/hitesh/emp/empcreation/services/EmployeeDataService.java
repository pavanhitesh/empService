package com.hitesh.emp.empcreation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitesh.emp.empcreation.database.EmployeeInfo;
import com.hitesh.emp.empcreation.repository.EmployeeDataRepository;

@Service
public class EmployeeDataService {
	
	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	
	public Optional<EmployeeInfo> getEmployeeInfoById(Long empId){
		return employeeDataRepository.findById(empId);
	}
	

	public Optional<EmployeeInfo> getEmployeeInfoByNumber(String phoneNo){
		return employeeDataRepository.findByMobileNumber(phoneNo);
	}
	
	

}
