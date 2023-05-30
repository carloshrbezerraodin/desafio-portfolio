package com.desafio.portfolio.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="projeto_sequence")
	@SequenceGenerator(name="projeto_sequence", sequenceName="projeto_seq")
	private Long id;
	private String nome;
	@Column(name = "data_inicio")
	private Date dataInicio;
	@Column(name = "data_previsao_fim")
	private Date dataPrevisaoFim;
	@Column(name = "data_fim")
	private Date dataFim;
	private String descricao;
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	private Float orcamento;
	@Enumerated(EnumType.ORDINAL)
	private Risco risco;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name = "idgerente")
	private Pessoa gerente;
	
	@JsonBackReference("membros")
	@ManyToMany
	@JoinTable(
			  name = "membros", 
			  joinColumns = @JoinColumn(name = "idprojeto"), 
			  inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    List<Pessoa> membros;
	
}
