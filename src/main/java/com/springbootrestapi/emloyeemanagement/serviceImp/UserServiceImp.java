package com.springbootrestapi.emloyeemanagement.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapi.emloyeemanagement.dao.UserRepository;
import com.springbootrestapi.emloyeemanagement.entity.User;
import com.springbootrestapi.emloyeemanagement.service.UserService;

import jakarta.transaction.Transactional;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	@Transactional
	public Optional<User> findById(Integer theId) {
		return userRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	@Transactional
	public void deleteById(Integer theId) {
		userRepository.deleteById(theId);
	}

	@Override
	@Transactional
	public Optional<User> findByUserName(String userName) {
		return Optional.ofNullable(userRepository.getUserByUsername(userName));
	}
}
