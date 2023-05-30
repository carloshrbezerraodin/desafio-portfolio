package com.desafio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.portfolio.model.Pessoa;

@Repository
public interface MembroRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByFuncionarioTrue();
	
}