package com.curso.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.springboot.domain.Pessoa;
import com.curso.springboot.dto.PessoaDTO;
import com.curso.springboot.repository.PessoaRepository;
import com.curso.springboot.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	// Método para listar pessoas
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
	
	// Método para buscar por pessoa por id
	public Optional<Pessoa> findOne(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public void delete(Long id) {
		findOne(id);
		pessoaRepository.deleteById(id);
	}
	
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Pessoa pessoa) {
		findOne(pessoa.getId());
		return pessoaRepository.save(pessoa);
	}

	public Pessoa fromDTO(PessoaDTO pessoaDTO) {
		return new Pessoa();
	}
}
