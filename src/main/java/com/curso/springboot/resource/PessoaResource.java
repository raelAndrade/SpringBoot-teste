package com.curso.springboot.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.springboot.domain.Pessoa;
import com.curso.springboot.dto.PessoaDTO;
import com.curso.springboot.service.impl.PessoaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Pessoa", description = "Entidade Pessoa")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaServiceImpl pessoaService;

	@ApiOperation(value = "Método para listar pessoas")
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> getFindAll(){
		List<Pessoa> listar = pessoaService.findAll();
		List<PessoaDTO> listarDTO = listar.stream().map(pessoa -> new PessoaDTO(pessoa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listarDTO);
	}
	
	@ApiOperation(value = "Método para encontrar pessoa pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getFindOne(@PathVariable Long id){
		pessoaService.findOne(id);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Método para inserir pessoa na base de dados")
	@PostMapping
	public ResponseEntity<Pessoa> insert(@Valid @RequestBody Pessoa pessoa){
		pessoaService.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Método para deletar pessoa pelo ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Método para alterar os dados da pessoa pelo ID")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@Valid @RequestBody PessoaDTO pessoaDTO, @PathVariable Long id){
		Pessoa pessoa = pessoaService.fromDTO(pessoaDTO);
		pessoa.setId(id);
		pessoaService.update(pessoa);
		return ResponseEntity.noContent().build();
		
	}
}
