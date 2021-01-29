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

import com.crudt2s.springboot.entities.Acao;
import com.crudt2s.springboot.entities.dto.AcaoDTO;
import com.crudt2s.springboot.services.AcaoService;

@RestController
@RequestMapping(value = "/acoes")
public class AcaoResource {

	@Autowired
	private AcaoService service;
	
	@GetMapping
	public ResponseEntity<List<Acao>> findAll(){
		List<Acao> list = service.findAll();
		return ResponseEntity.ok().body(list);
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
	
}
