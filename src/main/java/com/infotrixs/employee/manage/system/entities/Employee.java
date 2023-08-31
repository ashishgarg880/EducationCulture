package com.infotrixs.employee.manage.system.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_mob")
	private String empMobNo;
	@Column(name = "emp_pass")
	private String empPass;
	@Column(name = "emp_date")
	private String empDate;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, String empMobNo, String empPass, String empDate) {
		super();
		this.empName = empName;
		this.empMobNo = empMobNo;
		this.empPass = empPass;
		this.empDate = empDate;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empMobNo=" + empMobNo + ", empPass=" + empPass + ", empDate=" + empDate + "]";
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMobNo() {
		return empMobNo;
	}
	public void setEmpMobNo(String empMobNo) {
		this.empMobNo = empMobNo;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public String getEmpDate() {
		return empDate;
	}
	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}
	
}
