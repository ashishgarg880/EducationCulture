package com.infotrixs.employee.manage.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotrixs.employee.manage.system.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
