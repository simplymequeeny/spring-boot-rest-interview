package com.omega.mtest.services;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.omega.mtest.models.User;

public class UserServiceImpl implements UserService {

	private Map<Integer, User> users;
	
	public UserServiceImpl() {
		User john = new User(1, "John", 31, "New York");
    	User doe = new User(2, "Doe", 22, "Vancouver");
    	
    	users = new LinkedHashMap<Integer, User>();
    	users.put(john.getId(), john);
    	users.put(doe.getId(), doe);
	}
	
	@Override
	public User findById(int id) {
		return users.get(id);
	}

	@Override
	public List<User> findAll() {
		return Arrays.asList(users.values().toArray(new User[0]));
	}

}
