package com.desafio.portfolio.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_sequence")
	@SequenceGenerator(name="pessoa_sequence", sequenceName="pessoa_seq")
	private Long id;
	private String nome;
	@JsonFormat(pattern="dd/mm/yyyy")
	@Column(name = "datanascimento")
	private Date dataNascimento;
	private String cpf;
	private boolean funcionario;
	
}
