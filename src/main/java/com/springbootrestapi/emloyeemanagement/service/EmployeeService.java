package com.springbootrestapi.emloyeemanagement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootrestapi.emloyeemanagement.dao.EmployeeRepository;
import com.springbootrestapi.emloyeemanagement.entity.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepoistory;
	public List<Employee> fetchAllEmployeeRecord()
	{
		return this.employeeRepoistory.findAll();
	}
	/*public List<Employee> fetchAllEmployeeRecordBySortOrder(String orderby)
	{
		return this.employeeRepoistory.sortByOrder(orderby);
	}*/
	public Employee SaveEmplyeeRecord(Employee emp)
	{
		return this.employeeRepoistory.save(emp);
	}
	public Employee findEmployeeRecord(Integer empId)
	{
		return this.employeeRepoistory.findById(empId).orElseThrow(()->new IllegalArgumentException("invalid employee id"));
	}
	/*public List<Employee> findEmployeeRecordByName(String fname)
	{
		return this.employeeRepoistory.searchByName(fname);
	}*/
	public Employee upateEmployeeRecord(Integer empId)
	{
		@SuppressWarnings("deprecation")
		Employee emp=this.employeeRepoistory.getById(empId);
		//Employee emp=this.employeeRepoistory.findById(empId).orElseThrow(()->new IllegalArgumentException("invalid employee id"));
		emp.setFirstName(emp.getFirstName());
		emp.setLastName(emp.getLastName());
		emp.setEmailId(emp.getEmailId());
		return this.employeeRepoistory.saveAndFlush(emp);
	}
	public String deleteEmployeeRecord(Integer empId)
	{
		 this.employeeRepoistory.deleteById(empId);
		return "Deleted employee id -"+empId;
		
		
	}
	

}
