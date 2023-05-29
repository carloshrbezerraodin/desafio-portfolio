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

import com.desafio.portfolio.model.Projeto;
import com.desafio.portfolio.service.ProjetoService;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("projetos", projetoService.list());
		return "projeto-list";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/add-projeto")
	public String addProjeto(ModelMap model) {
		model.addAttribute("projeto", new Projeto());
		return "projeto-form";
	}

	@RequestMapping(value = "/delete-projeto", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		Projeto projeto = projetoService.getProjeto(id);
		projetoService.delete(projeto);
		return "redirect:/projeto/list";
	}

	@RequestMapping(value = "/update-projeto", method = RequestMethod.GET)
	public String showUpdateProjetoPage(@RequestParam long id, ModelMap model) {
		Projeto projeto = projetoService.getProjeto(id);
		model.put("projeto", projeto);
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
	public String addTodo(ModelMap model, Projeto projeto, BindingResult result) {

		if (result.hasErrors()) {
			return "projeto";
		}

		projetoService.saveOrUpdate(projeto);
		return "redirect:/projeto/list";
	}
}
