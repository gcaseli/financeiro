package com.br.controle.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotNull(message = "Valor não pode ser nulo")
	private BigDecimal valor;

	@Lob
	private String descricao;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Calendar dataReceita;

	@NotNull(message = "Valor minimo deve ser 1")
	@Min(value = 1)
	private Integer quantidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Calendar dataReceita) {
		this.dataReceita = dataReceita;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == null)
			return true;

		if (id == null || obj == null || getClass() != obj.getClass())
			return false;

		Receita receita = (Receita) obj;
		return id.equals(receita.getId());

	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
