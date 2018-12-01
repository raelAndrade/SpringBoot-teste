package com.curso.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.curso.springboot.domain.Pessoa;
import com.curso.springboot.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Pessoa", description = "Entidade Pessoa")
@Controller
public class PessoaController {
	
	@Autowired
	private PessoaRepository repo;

	@ApiOperation(value = "Página index")
	@RequestMapping(method=RequestMethod.GET, value="/cadastropessoa")
	public String index() {
		return "cadastro/cadastropessoa";
	}
	
	@ApiOperation(value = "Método para salvar pessoa")
	@RequestMapping(method=RequestMethod.POST, value= "/salvapessoa")
	public String salvar(Pessoa pessoa) {
		repo.save(pessoa);
		return "cadastro/cadastropessoa";
	}
	
//	@ApiOperation(value = "Método para listar pessoa")
//	@RequestMapping(method=RequestMethod.GET)
//	public ModelAndView listar() {
//		ModelAndView mv =  new ModelAndView("cadastro/listapessoa");
//		List<Pessoa> pessoa = repo.findAll();
//		mv.addObject("pessoas", pessoa);
//		return mv;
//	}
}
