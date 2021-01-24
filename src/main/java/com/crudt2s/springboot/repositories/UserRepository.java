package com.crudt2s.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudt2s.springboot.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
