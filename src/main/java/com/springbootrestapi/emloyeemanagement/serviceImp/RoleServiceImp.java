package com.springbootrestapi.emloyeemanagement.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapi.emloyeemanagement.dao.RolesRepository;
import com.springbootrestapi.emloyeemanagement.entity.Roles;
import com.springbootrestapi.emloyeemanagement.service.RoleService;

import jakarta.transaction.Transactional;
@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	RolesRepository roleRepository;

	@Override
	@Transactional
	public List<Roles> findAll() {
		List<Roles> roles = roleRepository.findAll();
		return roles;
	}

	@Override
	@Transactional
	public Optional<Roles> findById(int theId) {
		return roleRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Roles theRole) {
		roleRepository.save(theRole);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		roleRepository.deleteById(theId);
	}

	@Override
	public Optional<Roles> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
