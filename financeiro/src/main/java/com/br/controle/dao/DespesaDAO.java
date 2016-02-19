package com.br.controle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.controle.model.Despesa;

@Repository
public interface DespesaDAO extends CrudRepository<Despesa, Integer> {
	
	@Query("select d from Despesa d where d.id = :id")
	public Despesa findById(@Param("id") Integer id);
	
	@Query("select d from Despesa d ")
	public Page<Despesa> findDespesas(Pageable pageable);

}
