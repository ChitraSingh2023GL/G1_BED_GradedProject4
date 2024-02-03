package com.springbootrestapi.emloyeemanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootrestapi.emloyeemanagement.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

/*@Query("select * from Employee where first_name=?1")
List<Employee> searchByName(String fname);

@Query("select * from Employee order by ?1")
List<Employee> sortByOrder(String orderby);*/


}
