package com.desafio.portfolio.dto;

import java.util.List;

import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.model.Projeto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoMembroDTO {
	private Long id;
	private Projeto projeto;
	private List<Pessoa> membros; 
}
