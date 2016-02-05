package com.br.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.controle.dao.DespesaDAO;
import com.br.controle.model.Despesa;

@Controller
@RequestMapping("/despesa")
public class DespesaController {

	@Autowired
	private DespesaDAO dao;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView registro(Despesa despesa) {
		ModelAndView view = new ModelAndView("cadastro/despesa");
		view.addObject("despesas", dao.findDespesas());
		//view.addObject("despesa", new Despesa());

		return view;
	}

	@RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
	public ModelAndView executarRegistro(@Valid Despesa despesa, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return registro(null);
		}

		dao.save(despesa);
		redirectAttributes.addFlashAttribute("sucesso",
				"Produto cadastrado com sucesso");
		return new ModelAndView("redirect:listar");

	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cadastro/listar");
		view.addObject("despesas", dao.findDespesas());

		return view;
	}


}
