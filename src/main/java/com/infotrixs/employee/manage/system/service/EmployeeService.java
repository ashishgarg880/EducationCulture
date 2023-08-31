package com.infotrixs.employee.manage.system.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.infotrixs.employee.manage.system.entities.Employee;

@Component
public interface EmployeeService {
	public boolean getEmployee(String number, String password);
	
	public String addEmployee(Employee employee);
	
	public String putEmployee(Employee employee);
	
}
