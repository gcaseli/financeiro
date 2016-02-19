package com.br.controle.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView registro(Despesa despesa, RedirectAttributes redirectAttributes) {
		ModelAndView view = new ModelAndView("cadastro/despesa");
		view.addObject("despesas", dao.findDespesas(new PageRequest(0, 5)));
		redirectAttributes.addFlashAttribute("message", redirectAttributes == null ?  null : redirectAttributes.getFlashAttributes().get("message"));
		//view.addObject("despesa", new Despesa());

		return view;
	}

	@RequestMapping(value = "/executarRegistro", method = RequestMethod.POST)
	public ModelAndView executarRegistro(@Valid Despesa despesa, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return registro(null, redirectAttributes);
		}

		dao.save(despesa);
		redirectAttributes.addFlashAttribute("message",
				"Despesa cadastrada com sucesso");
		return new ModelAndView("redirect:/despesa/cadastro");

	}

	@RequestMapping(value = "listar", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cadastro/listar");
		Pageable pageRequest = new PageRequest(0, 5);
		view.addObject("despesas", dao.findDespesas(pageRequest));

		return view;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id, RedirectAttributes redirectAttributes, Pageable pageRequest) {
		ModelAndView view = new ModelAndView("cadastro/editar");
		view.addObject("despesa", dao.findById(id));
		view.addObject("despesas", dao.findDespesas(pageRequest));
		redirectAttributes.addFlashAttribute("message", null);

		return view;
	}
	
	@RequestMapping(value = "/alterarDespesa", method = RequestMethod.POST)
	public ModelAndView alterarDespesa(@Valid Despesa despesa, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return editar(despesa.getId(), redirectAttributes, null);
		}

		dao.save(despesa);
		redirectAttributes.addFlashAttribute("message",
				"Despesa alterada com sucesso");
		return new ModelAndView("redirect:/despesa/cadastro");

	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public ModelAndView excluir(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		
		dao.delete(id);

		return registro(null, redirectAttributes);
	}

	/*@RequestMapping(value = "/pages/{id}", method = RequestMethod.GET)
	public ModelAndView pages(@PathVariable Integer pageNumber) {
		ModelAndView view = new ModelAndView("cadastro/listar");
		Pageable pageRequest = new PageRequest(pageNumber - 1, 10, Sort.Direction.ASC, "dataDespesa");
		
		Page<Despesa> despesas = dao.findDespesas(pageRequest);
		
		int current = despesas.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, despesas.getTotalPages());
	    
	    view.addObject("beginIndex", begin);
	    view.addObject("endIndex", end);
	    view.addObject("currentIndex", current);
		view.addObject("despesas", despesas);

		return view;
	}*/
}
