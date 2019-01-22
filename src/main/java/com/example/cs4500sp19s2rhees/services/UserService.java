package com.example.cs4500sp19s2rhees.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cs4500sp19s2rhees.models.User;

@RestController
public class UserService {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(123, "alice", "alice", "Alice", "Wonderland"));
		users.add(new User(234, "bob", "bob", "Bob", "Marley"));
	}
	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return users;
	}
	@GetMapping("/api/user/{userId}")
	public User findUserById(
		@PathVariable("userId") Integer id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
