package com.desafio.portfolio.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.portfolio.exception.PortfolioBusinessException;
import com.desafio.portfolio.model.Pessoa;
import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.model.Risco;
import com.desafio.portfolio.model.Status;
import com.desafio.portfolio.service.MembroService;
import com.desafio.portfolio.service.ProjetoService;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private MembroService membroService;

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("projetos", projetoService.list());
		return "projeto-list";
	}

	@GetMapping("/")
	public String index() {
		return "redirect:/projeto/list";
	}

	@GetMapping("/add-projeto")
	public String addProjeto(ModelMap model) {
		model.addAttribute("projeto", new Projeto());
		model.addAttribute("statusList", Status.values());
		model.addAttribute("riscoList", Risco.values());
		model.addAttribute("gerentes", membroService.listaFuncionario());

		return "projeto-form";
	}
	

	@RequestMapping(value = "/delete-projeto", method = RequestMethod.GET)
	public String deleteProjeto(@RequestParam long id, ModelMap model) {
		try {
			Projeto projeto = projetoService.getProjeto(id);
			projetoService.delete(projeto);
		} catch (PortfolioBusinessException e) {
			model.addAttribute("erro", e.getErrorCode().getErrorMessage());
			model.addAttribute("projetos", projetoService.list());
			return "projeto-list";
		}
		return "projeto-list";
	}

	@RequestMapping(value = "/update-projeto", method = RequestMethod.GET)
	public String showUpdateProjetoPage(@RequestParam long id, ModelMap model) {
		Projeto projeto = projetoService.getProjeto(id);
		model.put("projeto", projeto);
		model.addAttribute("gerentes", membroService.listaFuncionario());
		return "projeto-form";
	}

	@RequestMapping(value = "/update-projeto", method = RequestMethod.POST)
	public String updateProjeto(ModelMap model, Projeto projeto, BindingResult result) {

		if (result.hasErrors()) {
			return "projeto";
		}

		projetoService.saveOrUpdate(projeto);
		return "redirect:/projeto/list";
	}

	@RequestMapping(value = "/add-projeto", method = RequestMethod.POST)
	public String addProjeto(ModelMap model, Projeto projeto, BindingResult result) {

		if (result.hasErrors()) {
			return "projeto";
		}

		projetoService.saveOrUpdate(projeto);
		return "redirect:/projeto/list";
	}
}
