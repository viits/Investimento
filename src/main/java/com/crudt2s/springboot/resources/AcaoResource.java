package com.crudt2s.springboot.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudt2s.springboot.entities.Acao;
import com.crudt2s.springboot.entities.dto.AcaoDTO;
import com.crudt2s.springboot.services.AcaoService;

@RestController
@RequestMapping(value = "/acoes")
public class AcaoResource {

	@Autowired
	private AcaoService service;
	
	@GetMapping
	public ResponseEntity<List<AcaoDTO>> findAll(){
		List<Acao> list = service.findAll();
		List<AcaoDTO> acao = new ArrayList<>();
		for(Acao a : list) {
			acao.add(new AcaoDTO(a));
		}
		
		for(AcaoDTO a : acao) {
			a.setTotal(a.totalAcao());
		}
		return ResponseEntity.ok().body(acao);
	}
	
	@PostMapping
	public ResponseEntity<AcaoDTO> insert(@RequestBody Acao acao){
		acao = service.insert(acao);
		return ResponseEntity.ok().body(new AcaoDTO(acao));
	}	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AcaoDTO> update(@PathVariable Integer id, @RequestBody AcaoDTO acaoDTO){
		Acao acao = service.convertAcao(acaoDTO);
		acao.setId(id);
		acao = service.update(acao);
		return ResponseEntity.ok().body(new AcaoDTO(acao));
		
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
