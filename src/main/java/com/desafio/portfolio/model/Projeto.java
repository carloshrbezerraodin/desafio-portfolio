package com.desafio.portfolio.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	@Column(name = "data_inicio")
	private Date dataInicio;
	@Column(name = "data_previsao_fim")
	private Date dataPrevisaoFim;
	@Column(name = "data_fim")
	private Date dataFim;
	private String descricao;
	private String status;
	private Float orcamento;
	private String risco;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Pessoa pessoa;
	
}
