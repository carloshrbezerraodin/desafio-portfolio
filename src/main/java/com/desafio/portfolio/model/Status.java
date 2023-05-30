package com.desafio.portfolio.model;

import java.util.ArrayList;
import java.util.List;

public enum Status {

	EM_ANALISE("em análise"), ANALISE_REALIZADA("análise realizada"), ANALISE_APROVADA(" análise aprovada"),
	INICIADO("iniciado"), PLANEJADO("planejado"), EM_ANDAMENTO(" em andamento"), ENCERRADO("encerrado"),
	CANCELADO("cancelado");

	private final String descricao;

	Status(String descricaoParam) {
		descricao = descricaoParam;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<String> getNames() {
        List<String> list = new ArrayList<String>();
        for (Status status : Status.values()) {
            list.add(status.descricao);
        }
        return list;
    }

}
