package com.br.controle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.controle.model.Receita;

@Repository
public interface ReceitaDAO extends CrudRepository<Receita, Integer> {

	@Query("select r from Receita r")
	public List<Receita> findReceitas();
	
	@Query("select r from Receita r where r.id = :id")
	public Receita findReceitaById(@Param("id") Integer id);
}
