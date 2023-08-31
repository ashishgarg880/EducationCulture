package com.infotrixs.employee.manage.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotrixs.employee.manage.system.dao.EmployeeRepository;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {	
		
	@Autowired
	public EmployeeRepository employeeRepository;
	private Employee employee;
	private String mobileNo;
	
	public boolean getEmployee(String number, String password) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		list = list.stream().filter(n ->  n.getEmpMobNo() == number && n.getEmpPass() == password).collect(Collectors.toList());
		if(list.size() > 0) {
			mobileNo = list.get(0).getEmpMobNo(); 
			System.out.println("Welcome" +list.get(0).getEmpName());
			return true;
		 }
		 return false;
	}
	
	public String addEmployee(Employee employee) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		list = list.stream().filter(n -> n.getEmpMobNo() == employee.getEmpMobNo()).collect(Collectors.toList());
		System.out.println(list);
		if(list.size() > 0) {
			return "Data is Exist";
		}
		employeeRepository.save(employee);
		return "You have Successfully sign Up";
	}
	
	public String putEmployee(Employee employee) {
		List<Employee> list = new ArrayList(); 
		list = this.employeeRepository.findAll();
		list = list.stream().filter(n -> n.getEmpMobNo() == mobileNo && n.getEmpPass() == employee.getEmpPass()).collect(Collectors.toList());
		if(list.size() > 0) {
			employeeRepository.save(employee);
			return "You password has been reset successfully";
		}
		return "your previous password is wrong";		
	}
}
