package com.codegnan.service;

import com.codegnan.beans.Employee;

public interface EmployeeService {
	public String addEmployee(Employee employee);

	public Employee searchEmployee(int eno);

	public String updateEmployee(Employee employee);

	public String deleteEmployee(Employee employee);

}
