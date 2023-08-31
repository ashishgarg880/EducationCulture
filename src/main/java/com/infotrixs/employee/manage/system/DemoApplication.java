package com.infotrixs.employee.manage.system;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotrixs.employee.manage.system.entities.Employee;
import com.infotrixs.employee.manage.system.service.EmployeeService;
import com.infotrixs.employee.manage.system.service.impl.EmployeeServiceImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	public EmployeeService employeeService;

	public static void main(String[] args) throws FileNotFoundException,ParseException,IOException,NullPointerException{
		SpringApplication.run(DemoApplication.class, args);
	
	}

	public static boolean checkMobileLength(String number) {
		if(number.charAt(0) == '0' && number.length() == 11) {
			return false;
		} 
		return true;
	}
	
	public static boolean confirmPassword (String password,String confirmPass) {
		return !password.equals(confirmPass); 
	}
	
	public static boolean checkDate (String date) {
		if(date.matches(" ")) {
			return true;
		}
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date javaDate = sdfrmt.parse(date);
			return false;
		} catch (Exception e) {
			return false;	
		}
	}
	
	public static boolean checkValidPass(String password) {
		String regex = "^[A-Za-z]+[@&][0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        
        return !matcher.matches();
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(" <<<<<<     Mobile ordering application   >>>>>>>  ");
		System.out.println(" In which department are you working ");
		System.out.println("1. Sign Up \t\t\t\n 2. Sign In \t\t\t\n 3.Quit");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter What you do? ");
		int t = sc.nextInt();
		switch(t) {
			case 1:
				try {
					System.out.println("Please enter you name:- ");
					String str = sc.next();
					System.out.println("Please enter your mobile number:- ");
					String number = sc.next();
					if(checkMobileLength(number)) {
						System.out.println("Please enter check again");
					} else {
						System.out.println("Please enter your password");
						String password = sc.next();
						if(checkValidPass(password)) {
							System.out.println("Please check the valid password");
						} else {
							System.out.println("Please enter your confirm password:-");
							String confirmPass = sc.next();
							if(confirmPassword(password,confirmPass)) {
								System.out.println("your password is not equals to confirm password");
								System.out.println("Please start again");
							}
							else {
								System.out.println("Please enter you date of birth #DD/MM/YYYY (No Space):-");
								String date = sc.next();
								if(checkDate(date)) {
									System.out.println("Please enter correct date");
									System.out.println("Please start again");
								} 
								Employee employee = new Employee(str,number,password,date);
								System.out.println(this.employeeService.addEmployee(employee));
							}
						}
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Please enter UserName (Mobile Number): ");
					String number = sc.next();
					if(checkMobileLength(number)) {
						System.out.println("Please enter check again");
					}
					System.out.println("Please enter your password:");
					String pass = sc.next();
				 	if(this.employeeService.getEmployee(number,pass)) {
				 		System.out.println("Please enter 1 for Resetting Password \n\n Please enter 2 for Signout");
				 		t = sc.nextInt();
				 		switch(t) {
				 			case 1: 
				 				System.out.println("Please enter your old password:- ");
				 				String password = sc.next();
				 				System.out.println("Please enter your new password:-");
				 				String confirmPass = sc.next();
				 				if(checkValidPass(confirmPass)) {
									System.out.println("Please check the valid password");
								} else {
									String date = "";
									Employee employee = new Employee("",number,password,date);
									System.out.println(this.employeeService.putEmployee(employee));
								}
				 				break;
				 			default:
				 				System.out.println("Thank you for using the Application");
								break;	
				 		}
				 	} else {
				 		System.out.println("Invalid mobile number && password");
				 	}
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			default :
				System.out.println("Thank you for using the Application");
				break;
		}
	}
}
