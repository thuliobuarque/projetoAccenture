package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import java.util.ArrayList;

public class LocacaoBean {
	
	private Integer id;
	private Integer pessoa;
	private Date dataLocacao;
	private Date dataEntrega;
	private ArrayList<Integer> livros;
	
	public LocacaoBean(){
		livros = new ArrayList<>();
	}
	
	public ArrayList<Integer> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Integer> livros) {
		this.livros = livros;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPessoa() {
		return pessoa;
	}
	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	

}
