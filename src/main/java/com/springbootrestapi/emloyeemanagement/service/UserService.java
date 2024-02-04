package com.springbootrestapi.emloyeemanagement.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootrestapi.emloyeemanagement.entity.User;

@Service
public interface UserService {
	public List<User> findAll();

	public Optional<User> findById(Integer theId);

	public void save(User theUser);

	public void deleteById(Integer theId);

	public Optional<User> findByUserName(String userName);
	

}
