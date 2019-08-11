package com.hitesh.emp.empcreation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.emp.empcreation.database.EmployeeInfo;
import com.hitesh.emp.empcreation.services.EmployeeDataService;

@RestController
public class TestController {
	@Autowired
	EmployeeDataService employeeDataService;

	@RequestMapping(value ="/home",method=RequestMethod.GET)
	public String getApplication() {
		return "Application Running";
	}
	
	@RequestMapping(value ="/employeeNo",method=RequestMethod.GET)
	public Optional<EmployeeInfo> getEmployeeByNumber(@RequestParam String phoneNumber) {
		return employeeDataService.getEmployeeInfoByNumber(phoneNumber);
	}
	
	@RequestMapping(value ="/employeeId",method=RequestMethod.GET)
	public Optional<EmployeeInfo> getEmployeeById(@RequestParam String id) {
		return employeeDataService.getEmployeeInfoById(Long.valueOf(id));
	}
}
