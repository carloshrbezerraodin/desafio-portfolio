package com.desafio.portfolio.model;

import java.util.Set;

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
	private Set<Pessoa> membros; 
}
