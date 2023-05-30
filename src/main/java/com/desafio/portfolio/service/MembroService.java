package com.desafio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.portfolio.exception.PortfolioBusinessException;
import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.repository.MembroRepository;

@Service
public class MembroService {
	
	@Autowired
	MembroRepository membroReRpository;
	
	public List<Pessoa> list() {
		return membroReRpository.findAll();
	}
	
	public List<Pessoa> listaFuncionario() {
		return membroReRpository.findByFuncionarioTrue();
	}
	
	public Pessoa saveOrUpdate(Pessoa pessoa) {
		return membroReRpository.save(pessoa);
	}
	
	public void delete(Pessoa pessoa) throws PortfolioBusinessException {
		membroReRpository.delete(pessoa);
	}
	
}
