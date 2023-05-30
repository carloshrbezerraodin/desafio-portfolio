package com.desafio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.portfolio.dto.ProjetoMembroDTO;
import com.desafio.portfolio.exception.PortfolioBusinessException;
import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.service.MembroService;
import com.desafio.portfolio.service.ProjetoService;

@Controller
@RequestMapping("/associar")
public class AssociarMembroProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private MembroService membroService;

	
	@GetMapping("/list-membro-projeto")
	public String listMembroProjeto(Model model) {
		model.addAttribute("projetos", projetoService.list());
		return "projeto-membro-list";
	}

	
	@GetMapping("/add-membro-projeto")
	public String addMembroProjeto(ModelMap model) {
		model.addAttribute("projetoMembro", new ProjetoMembroDTO());
		model.addAttribute("projetos", projetoService.list());
		model.addAttribute("membros", membroService.listaFuncionario());
		return "projeto-membro-form";
	}
	
	@RequestMapping(value = "/add-membro-projeto", method = RequestMethod.POST)
	public String addProjetoMembro(ModelMap model, ProjetoMembroDTO projetoMembro, BindingResult result) {

		if (result.hasErrors()) {
			return "associar";
		}

		projetoService.saveMembrosProjeto(projetoMembro);
		return "redirect:/associar/list-membro-projeto";
	}
	
	@RequestMapping(value = "/update-associar-projeto", method = RequestMethod.GET)
	public String showUpdateProjetoPage(@RequestParam long id, ModelMap model) {
		Projeto projeto = projetoService.getProjeto(id);
		ProjetoMembroDTO projetoMembroDTO = new ProjetoMembroDTO();
		projetoMembroDTO.setProjeto(projeto);
		projetoMembroDTO.setMembros(projeto.getMembros());
		model.addAttribute("projetoMembro", new ProjetoMembroDTO());
		model.addAttribute("projetos", projetoService.list());
		model.addAttribute("membros", membroService.listaFuncionario());
		return "projeto-membro-form";
	}
	
	@RequestMapping(value = "/update-associar-projeto", method = RequestMethod.POST)
	public String updateAssociarProjeto(ModelMap model, ProjetoMembroDTO projetoMembro, BindingResult result) {

		if (result.hasErrors()) {
			return "associar";
		}

		projetoService.saveMembrosProjeto(projetoMembro);
		return "redirect:/associar/list-membro-projeto";
	}

	

}
