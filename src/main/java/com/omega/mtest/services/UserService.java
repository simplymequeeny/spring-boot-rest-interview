package com.omega.mtest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omega.mtest.models.User;

@Service
public interface UserService {
	public User findById(int id);
	public List<User> findAll();
}
