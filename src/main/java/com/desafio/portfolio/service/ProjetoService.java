package com.desafio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.portfolio.exception.EnumErrorCode;
import com.desafio.portfolio.exception.PortfolioBusinessException;
import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.model.ProjetoMembroDTO;
import com.desafio.portfolio.model.Status;
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
	
	public void saveMembrosProjeto(ProjetoMembroDTO projetoMembro) {
		Projeto projeto  = projetoRepository.findById(projetoMembro.getProjeto().getId()).get();
		projeto.setMembros(projetoMembro.getMembros());
		projetoRepository.save(projeto);
	}

	public void delete(Projeto projeto) throws PortfolioBusinessException {

		if (Status.INICIADO == projeto.getStatus() || Status.EM_ANDAMENTO == projeto.getStatus()
				|| Status.ENCERRADO == projeto.getStatus()) {
			throw new PortfolioBusinessException(EnumErrorCode.REGRA_STATUS);
		}

		projetoRepository.delete(projeto);
	}

	public Projeto getProjeto(Long id) {
		return projetoRepository.findById(id).get();
	}

}
