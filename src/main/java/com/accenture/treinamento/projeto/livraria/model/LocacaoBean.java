package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import java.util.List;

public class LocacaoBean {
	
	private Integer id_locacao;
	private Date data_locacao;
	private Date data_devolucao;
	private Integer id_pessoa;
	private List<Integer> livros;
	private String status;
	
	public Integer getId_locacao() {
		return id_locacao;
	}
	public void setId_locacao(Integer id_locacao) {
		this.id_locacao = id_locacao;
	}
	public Date getData_locacao() {
		return data_locacao;
	}
	public List<Integer> getLivros() {
		return livros;
	}
	public void setLivros(List<Integer> livros) {
		this.livros = livros;
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
	
	public Integer getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
	
	/*private Integer pessoa;
	private ArrayList<Integer> livros;
	
	public LocacaoBean(){
		livros = new ArrayList<>();
	}
	
	public ArrayList<Integer> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Integer> livros) {
		this.livros = livros;
	}*/

	