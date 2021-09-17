package com.pgr.springhibernate.bean;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
		EmployeeDao employeeDao = (EmployeeDao) context.getBean("EmployeeDao");
		employeeDao.saveEmployee(new Employee(104, "MB", "10000"));
		
		//employeeDao.updateEmployee(new Employee(2, "Malli", "90000"));
		
		//employeeDao.deleteEmployee(1);
		
		/*List<Employee> list = employeeDao.getAllEmployees();
		//System.out.println(employeeDao.getEmployee(1));
		for(Employee emp : list) {
			System.out.println(emp);
		}*/
	}
}
