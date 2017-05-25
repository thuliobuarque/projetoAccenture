package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;



public class LivroBean {
	

	private int id_livro;
	private String titulo;
	private String ano_publicacao;
	private String editora;
	private String resumo;
	private String classificacao;
	private int quantidade;
	private AutorBean autor;
	
	public int getId_livro() {
		return id_livro;
	}
	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(String ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public AutorBean getAutor() {
		return autor;
	}
	public void setAutor(AutorBean autor) {
		this.autor = autor;
	}

}
	
	
	
	