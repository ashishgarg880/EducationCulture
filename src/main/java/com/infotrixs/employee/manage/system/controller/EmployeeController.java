package com.infotrixs.employee.manage.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.service.EmployeeService;

@Component
@RestController
@RequestMapping("infotrixs/")
@Repository
public class EmployeeController {
	
//	@Autowired
//	private EmployeeService employeeDao;
//	
//	@GetMapping("employee")
//	public List<Employee> getEmployee() {
//		return this.employeeDao.getEmployee(0);
//	}
//	
//	@GetMapping("employee/{empId}")
//	public List<Employee> getEmployee(@PathVariable int empId) {
//		return this.employeeDao.getEmployee(empId);
//	}
//	
//	@PostMapping("employee")
//	public String addEmplyee(@RequestBody Employee employee) {
//		return this.employeeDao.addEmployee(employee);
//	}
//	
//	@PutMapping("employee/{empId}")
//	public String putEmployee(@PathVariable int empId, @RequestBody Employee employee) {
//		return this.employeeDao.putEmployee(empId, employee);
//	}
//	@DeleteMapping("employee/{empId}")
//	public void deleteEmployee(@PathVariable int empId) {
//		this.employeeDao.delEmployee(empId);
//	}
}
