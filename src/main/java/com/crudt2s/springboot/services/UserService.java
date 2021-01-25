package com.crudt2s.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.User;
import com.crudt2s.springboot.entities.dto.UserDTO;
import com.crudt2s.springboot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User>findAll(){
		return repository.findAll();
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User convert(UserDTO userDTO) {
		User user = new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail(),userDTO.getPassword());
		return user;
	}
	
	public User update(User user) {
		User obj = repository.getOne(user.getId());
		updateData(user, obj);
		return repository.save(obj);
	}
	private void updateData(User user,User obj) {
		obj.setName(user.getName());
		obj.setEmail(user.getEmail());
		obj.setPassword(user.getPassword());
	}
	
}
