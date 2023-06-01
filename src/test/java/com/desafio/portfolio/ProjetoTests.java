package com.desafio.portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.desafio.portfolio.exception.EnumErrorCode;
import com.desafio.portfolio.exception.PortfolioBusinessException;
import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.model.Risco;
import com.desafio.portfolio.model.Status;
import com.desafio.portfolio.service.MembroService;
import com.desafio.portfolio.service.ProjetoService;

@SpringBootTest
public class ProjetoTests {

	@Autowired
	ProjetoService projetoSerivce;

	@Autowired
	MembroService membroService;

	@InjectMocks
	ProjetoService projetServiceMock;


	private static final String NOME_PROJETO = "Programacao";

	

	@Test
	public void testSalvarMembro() throws Exception {

		Pessoa pessoa = Pessoa.builder().nome("Carlos").dataNascimento(new Date()).funcionario(true).build();
		Pessoa pessoaDB = membroService.saveOrUpdate(pessoa);
		assertEquals(pessoa.getNome(), pessoaDB.getNome());
	}

	@Test
	public void testSalvarProjeto() {
		
		Pessoa pessoa = Pessoa.builder().nome("Carlos").dataNascimento(new Date()).funcionario(true).build();
		Pessoa gerente = membroService.saveOrUpdate(pessoa);

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).gerente(gerente).build();

		Projeto projetoBD = projetoSerivce.saveOrUpdate(projeto);

		assertEquals(NOME_PROJETO, projetoBD.getNome());

	}

	@Test
	public void testAssociarMembro() {

		List<Pessoa> membros = new ArrayList<Pessoa>();
		Pessoa membro = Pessoa.builder().nome("Carlos").dataNascimento(new Date()).funcionario(true).build();
		membros.add(membro);

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).membros(membros).build();

		assertTrue(projeto.getMembros().size() > 0);

	}

	@Test
	public void testStatusIniciadoProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).build();

		try {
			projetServiceMock.validarExclusaoProjeto(projeto);
			fail("Sem exception de retorno");
		} catch (PortfolioBusinessException e) {
			assertEquals(EnumErrorCode.REGRA_STATUS, e.getErrorCode());
		}

	}

	@Test
	public void testStatusEmAndamentoProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.EM_ANDAMENTO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).build();

		try {
			projetServiceMock.validarExclusaoProjeto(projeto);
			fail("Sem exception de retorno");
		} catch (PortfolioBusinessException e) {
			assertEquals(EnumErrorCode.REGRA_STATUS, e.getErrorCode());
		}

	}

	@Test
	public void testStatusEncerradoProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.ENCERRADO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).build();

		try {
			projetServiceMock.validarExclusaoProjeto(projeto);
			fail("Sem exception de retorno");
		} catch (PortfolioBusinessException e) {
			assertEquals(EnumErrorCode.REGRA_STATUS, e.getErrorCode());
		}

	}

	@Test
	public void testRiscoBaixoProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.BAIXO_RISCO)
				.orcamento(2.00f).build();

		assertEquals(Risco.BAIXO_RISCO, projeto.getRisco());

	}

	@Test
	public void testRiscoMedioProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.MEDIO_RISCO)
				.orcamento(2.00f).build();

		assertEquals(Risco.MEDIO_RISCO, projeto.getRisco());

	}

	@Test
	public void testRiscoAltoProjetoNaoExclusao() {

		Projeto projeto = Projeto.builder().nome("Programacao").dataFim(new Date()).dataInicio(new Date())
				.dataPrevisaoFim(new Date()).descricao("Teste").status(Status.INICIADO).risco(Risco.ALTO_RISCO)
				.orcamento(2.00f).build();

		assertEquals(Risco.ALTO_RISCO, projeto.getRisco());
	}

}
