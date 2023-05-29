package com.desafio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	public List<Projeto> list() {
		return projetoRepository.findAll();
	}
	
	public void saveOrUpdate(Projeto projeto) {
		projetoRepository.save(projeto);
	}
	
	public void delete(Projeto projeto) {
		projetoRepository.delete(projeto);
	}
	
	public Projeto getProjeto(Long id) {
		return projetoRepository.findById(id).get();
	}
	
	

}
