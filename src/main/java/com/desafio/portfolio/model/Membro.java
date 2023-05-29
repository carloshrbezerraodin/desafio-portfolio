package com.desafio.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Membro {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idprojeto",referencedColumnName = "id")
	private Projeto projeto;

	@Id
	@ManyToOne
	@JoinColumn(name = "idpessoa",referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_membros_pessoa"))
	private Pessoa pessoa;

}
