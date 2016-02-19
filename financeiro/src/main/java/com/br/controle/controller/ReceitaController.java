package com.br.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.controle.dao.ReceitaDAO;
import com.br.controle.model.Receita;

@Controller
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaDAO dao;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView registro(Receita receita, RedirectAttributes attributes){
		ModelAndView modelAndView = new ModelAndView("receita/cadastro");
		modelAndView.addObject("receitas", dao.findReceitas());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
	public ModelAndView executarRegistro(@Valid Receita receita, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return registro(null, redirectAttributes);
		}

		dao.save(receita);
		redirectAttributes.addFlashAttribute("message",
				"Receita cadastrada com sucesso");
		return new ModelAndView("redirect:/receita/cadastro");

	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("receita/listar");
		view.addObject("receitas", dao.findReceitas());

		return view;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		ModelAndView view = new ModelAndView("receita/editar");
		view.addObject("receita", dao.findReceitaById(id));
		view.addObject("receitas", dao.findReceitas());
		redirectAttributes.addFlashAttribute("message", null);

		return view;
	}
	
	@RequestMapping(value = "/alterarReceita", method = RequestMethod.POST)
	public ModelAndView alterarReceita(@Valid Receita receita, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return editar(receita.getId(), redirectAttributes);
		}

		dao.save(receita);
		redirectAttributes.addFlashAttribute("message",
				"Receita alterada com sucesso");
		return new ModelAndView("redirect:/receita/cadastro");

	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView excluir(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		
		dao.delete(id);

		return registro(null, redirectAttributes);
	}
}
