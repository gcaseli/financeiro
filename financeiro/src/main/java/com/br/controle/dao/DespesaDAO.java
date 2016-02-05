package com.br.controle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.controle.model.Despesa;

@Repository
public interface DespesaDAO extends CrudRepository<Despesa, Integer> {
	
	@Query("select d from Despesa d where d.nome = :name")
	public Despesa findByName(@Param("name") String name);
	
	@Query("select d from Despesa d ")
	public List<Despesa> findDespesas();

}
