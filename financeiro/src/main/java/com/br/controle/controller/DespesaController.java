package com.br.controle.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.controle.dao.DespesaDAO;
import com.br.controle.model.Despesa;

@Controller
@RequestMapping("/despesa")
public class DespesaController {

	@Autowired
	private DespesaDAO dao;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String registro(Map<String, Object> model) {
		if (model.get("despesa") == null) {
			model.put("despesa", new Despesa());
		}
		return "cadastroDespesa";
	}
	
	@RequestMapping(value="/executarRegistro", method=RequestMethod.POST)
	public String executarRegistro(Despesa despesa, HttpSession session){
		System.out.println(despesa.getNome());
		dao.save(despesa);
		return "";
	}
	
	/*
	@RequestMapping (value="/executarRegistro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String  executarRegistro(@RequestBody @Valid final Customer customer, HttpSession session, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			System.out.println("Erro");
		}
		dao.save(customer);
		session.setAttribute("customers", dao.listAllCustomer());
		return "true";
		//return "redirect:/lista";
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public String getCustomers(Map<String, Object> model){
		
		//model.put("customers", dao.listAllCustomer());
		
		return "listaRegistro";

	}*/
}
