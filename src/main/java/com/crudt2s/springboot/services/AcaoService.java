package com.crudt2s.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.repositories.AcaoRepository;

@Service
public class AcaoService {
	
	@Autowired
	private AcaoRepository repository;
	
}
