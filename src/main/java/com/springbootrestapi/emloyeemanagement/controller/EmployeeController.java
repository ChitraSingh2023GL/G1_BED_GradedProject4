package com.springbootrestapi.emloyeemanagement.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.springbootrestapi.emloyeemanagement.entity.Employee;
import com.springbootrestapi.emloyeemanagement.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	
	@GetMapping()
	public List<Employee> fetchAllEmployeeRecord() {
		return this.empservice.fetchAllEmployeeRecord();
	}
	@PostMapping
	public Employee SaveEmplyeeRecord(@RequestBody Employee emp) {
		return this.empservice.SaveEmplyeeRecord(emp);
	}
	@GetMapping("/{id}")
	public Employee findEmployeeRecord(@PathVariable("id")Integer empId) {
		return this.empservice.findEmployeeRecord(empId);
	}
	@PostMapping("/{id}")
	public Employee upateEmployeeRecord(@PathVariable("id")Integer empId) {
		return this.upateEmployeeRecord(empId);
	}
	@DeleteMapping("/{id}")
	public String deleteEmployeeRecord(@PathVariable("id")Integer empId) {
		return this.empservice.deleteEmployeeRecord(empId);
	}
	/*@GetMapping("/{order}")
	public List<Employee> Sort(@PathVariable("order")String orderby) {
		return this.empservice.fetchAllEmployeeRecordBySortOrder(orderby);
	}
	@GetMapping("/{fname}")
	public List<Employee> Search(@PathVariable("fname")String fname) {
		return this.empservice.findEmployeeRecordByName(fname);
	}*/

}
