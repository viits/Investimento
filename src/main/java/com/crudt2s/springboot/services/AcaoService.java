package com.crudt2s.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.Acao;
import com.crudt2s.springboot.repositories.AcaoRepository;

@Service
public class AcaoService {
	
	@Autowired
	private AcaoRepository repository;
	
	public List<Acao> findAll() {
		return repository.findAll();
	}
	
	public Acao insert(Acao acao) {
		return repository.save(acao);
	}
	
	
	
}
