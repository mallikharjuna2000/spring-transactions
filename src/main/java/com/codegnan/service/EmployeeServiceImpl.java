package com.codegnan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.beans.Employee;
import com.codegnan.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String addEmployee(Employee employee) {
		String status = employeeDao.add(employee);
		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		Employee employee = employeeDao.search(eno);
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String status = employeeDao.update(employee);
		return status;
	}

	@Override
	public String deleteEmployee(Employee employee) {
		String status = employeeDao.delete(employee);
		return status;
	}
}
