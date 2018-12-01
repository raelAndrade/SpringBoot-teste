package com.curso.springboot.dto;

import java.io.Serializable;

import com.curso.springboot.domain.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String sobrenome;

	public PessoaDTO() {
	}
	public PessoaDTO(Pessoa pessoa) {
		id = pessoa.getId();
		nome = pessoa.getNome();
		sobrenome = pessoa.getSobrenome();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
