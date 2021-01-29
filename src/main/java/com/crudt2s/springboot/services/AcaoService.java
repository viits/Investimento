package com.crudt2s.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.Acao;
import com.crudt2s.springboot.entities.dto.AcaoDTO;
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
	
	public Acao update(Acao acaoN) {
		Acao acao = repository.getOne(acaoN.getId());
		updateData(acao,acaoN);
		return repository.save(acao);
	}
	
	public  void delete(Integer id) {
		
		repository.deleteById(id);

	}
	
	private void updateData(Acao obj,Acao acao) {
		obj.setName(acao.getName());
		obj.setValorCompra(acao.getValorCompra());
		obj.setQuantidadeAcao(acao.getQuantidadeAcao());
		obj.setDiaCompra(acao.getDiaCompra());
	}
	
	public Acao convertAcao(AcaoDTO acaoDTO) {
		Acao acao = new  Acao(acaoDTO.getId(),acaoDTO.getName(),acaoDTO.getValorCompra(),acaoDTO.getQuantidadeAcao(),acaoDTO.getDiaCompra());
		return acao;
	}
	
	
	
}
