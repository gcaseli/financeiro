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
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Despesa {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/*@ElementCollection(targetClass = TipoDespesa.class)
	@CollectionTable(name = "tipoDespesa", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "tpDespesa", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<TipoDespesa> tipoDespesas = new HashSet<TipoDespesa>();*/

	@NotEmpty
	private String nome;
	
	@NotNull
	private BigDecimal valor;
	@NotEmpty
	@Lob
	private String descricao;
	
	@DateTimeFormat(iso=ISO.DATE)
	private Calendar dataDespesa;
	
	@NotNull(message="Valor minimo deve ser 1")
	@Min(value = 1)
	private int quantidade;

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

	public Calendar getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(Calendar dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
