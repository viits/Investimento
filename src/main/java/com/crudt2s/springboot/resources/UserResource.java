package com.crudt2s.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudt2s.springboot.entities.User;
import com.crudt2s.springboot.entities.dto.UserDTO;
import com.crudt2s.springboot.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO){
	
		User obj = service.convert(userDTO); 
			 obj = service.insert(obj);
		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Integer id,@RequestBody UserDTO user){
		
		User obj = service.convert(user);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
}
