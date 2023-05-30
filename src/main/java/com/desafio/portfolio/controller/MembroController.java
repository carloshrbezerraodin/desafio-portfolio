package com.desafio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.service.MembroService;

@RestController
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroService membroService;

	@GetMapping("/list")
	public List<Pessoa> list(Model model) {
		return membroService.list();
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Pessoa save(@RequestBody Pessoa pessoa) {
		return membroService.saveOrUpdate(pessoa);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return membroService.saveOrUpdate(pessoa);
	}
	
}
