package com.desafio.portfolio.model;

import java.util.ArrayList;
import java.util.List;

public enum Risco {

	BAIXO_RISCO("Baixo Risco"), MEDIO_RISCO("Medio Risco"), ALTO_RISCO("Alto Risco");

	private final String descricao;

	Risco(String descricaoParam) {
		descricao = descricaoParam;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<String> getNames() {
        List<String> list = new ArrayList<String>();
        for (Risco risco : Risco.values()) {
            list.add(risco.descricao);
        }
        return list;
    }
}