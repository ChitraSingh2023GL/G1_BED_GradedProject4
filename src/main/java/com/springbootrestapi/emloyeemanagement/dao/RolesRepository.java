package com.springbootrestapi.emloyeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootrestapi.emloyeemanagement.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
	

}