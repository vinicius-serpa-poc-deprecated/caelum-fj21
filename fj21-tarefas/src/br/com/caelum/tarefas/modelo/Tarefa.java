package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {

	private Long id;
	
	@NotNull(message="A descrição não pode estar vazia!")
	@NotEmpty(message="A descrição não pode estar vazia!")
	@Size(max=100, message="A descrição deve ser menor que 100!")
	private String descricao;
	
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;
		
	@Range(min=1, max=10, message="{tarefa.peso.range}")
	private Integer peso;
	
	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
