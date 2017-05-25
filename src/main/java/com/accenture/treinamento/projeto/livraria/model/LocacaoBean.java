package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import java.util.ArrayList;

public class LocacaoBean {
	
	private Integer id_locacao;
	private Integer pessoa;
	private Date data_locacao;
	private Date data_devolucao;
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

	public Integer getId_locacao() {
		return id_locacao;
	}

	public void setId_locacao(Integer id_locacao) {
		this.id_locacao = id_locacao;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData_locacao() {
		return data_locacao;
	}

	public void setData_locacao(Date data_locacao) {
		this.data_locacao = data_locacao;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

}