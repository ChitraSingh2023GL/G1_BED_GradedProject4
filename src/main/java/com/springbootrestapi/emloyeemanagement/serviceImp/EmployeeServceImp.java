package com.springbootrestapi.emloyeemanagement.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springbootrestapi.emloyeemanagement.dao.EmployeeRepository;
import com.springbootrestapi.emloyeemanagement.dao.RoleRepository;
import com.springbootrestapi.emloyeemanagement.dao.UserRepository;
import com.springbootrestapi.emloyeemanagement.entity.Employee;
import com.springbootrestapi.emloyeemanagement.entity.Roles;
import com.springbootrestapi.emloyeemanagement.entity.User;
import com.springbootrestapi.emloyeemanagement.service.EmployeeService;

@Service
public class EmployeeServceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	//@Autowired
	//BCryptPasswordEncoder bcryptEncoder;
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int theId) {
		boolean empExists=employeeRepository.existsById(theId);
		if(empExists)
		{
			return employeeRepository.findById(theId);
		}else
		{
			throw new RuntimeException("There is no employee exist with id : " + theId);
		}
	}

	@Override
	public String save(Employee theEmployee) {
		if (theEmployee.getFirstName().equals("") || theEmployee.getLastName().equals("")
				|| theEmployee.getEmail().equals("")) {
			throw new RuntimeException("Error!!!All fields are mandatory ");

		} else {
			employeeRepository.saveAndFlush(theEmployee);
			return "Employee Added Successfully!\nAdded Employee Details is :\nid : " + theEmployee.getId()
					+ "\nFirst Name : " + theEmployee.getFirstName() + "\nLast Name : " + theEmployee.getLastName()
					+ "\nEmail : " + theEmployee.getEmail();
		}
	}

	@Override
	public String updateEmployee(Employee theEmployee) {
		boolean ifEmployeeExist = employeeRepository.existsById(theEmployee.getId());

		if (ifEmployeeExist) {
			employeeRepository.saveAndFlush(theEmployee);
			return "Employee Updated Successfully!\nUpdated Employee Details is :\nid : " + theEmployee.getId()
					+ "\nFirst Name : " + theEmployee.getFirstName() + "\nLast Name : " + theEmployee.getLastName()
					+ "\nEmail : " + theEmployee.getEmail();
		} else {
			return "There is no employee exist with id : " + theEmployee.getId();

		}
	}

	@Override
	public String deleteById(int theId) {
		boolean empExists=employeeRepository.existsById(theId);
		if(empExists)
		{
			 employeeRepository.deleteById(theId);
			return "Deleted employee id -" + theId;
		}else
		{
			throw new RuntimeException("There is no employee exist with id : " + theId);
		}
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		List<Employee> employees=employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
		if (employees.size() > 0)
			return employees;
		else
			throw new RuntimeException("No employee data found!!!");
	}

	@Override
	public List<Employee> sortByFirstName(String sortBy) {
		List<Employee> employees=employeeRepository.findAll(Sort.by(Direction.fromString(sortBy), "firstName"));
		if (employees.size() > 0)
			return employees;
		else
			throw new RuntimeException("No employee data found!!!");
	}

	@Override
	public User saveUser(User user) {
		//user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Roles saveRole(Roles role) {
		return roleRepository.save(role);
	}

}
