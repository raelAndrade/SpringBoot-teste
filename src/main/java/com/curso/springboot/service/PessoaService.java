package com.curso.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.springboot.domain.Pessoa;
import com.curso.springboot.dto.PessoaDTO;

@Service
public interface PessoaService {
	
	/**
	 * Método para listar todas as pessoas cadastrada
	 */
	List<Pessoa> findAll();
	
	/**
	 * Método para buscar um pessoa pelo ID 
	 * @param id
	 */
	Optional<Pessoa> findOne(Long id);
	
	/**
	 * Método para deletar pessoa
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Método para salvar pessoa
	 * @param pessoa
	 */
	Pessoa save(Pessoa pessoa);
	
	/**
	 * Método para atualizar pessoa
	 * @param pessoa
	 */
	Pessoa update(Pessoa pessoa);

	Pessoa fromDTO(PessoaDTO pessoaDTO);
}
