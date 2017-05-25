package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public class ReservaBean {
	
	private Integer id;
	private PessoaBean pessoa;
	private Date dataRetirada;
	private LivroBean livro;
	
	private Integer livro1;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PessoaBean getPessoa() {
		return pessoa;
	}
	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LivroBean getLivro() {
		return livro;
	}
	public void setLivro(LivroBean livro) {
		this.livro = livro;
	}
	public Integer getLivro1() {
		return livro1;
	}
	public void setLivro1(Integer livro1) {
		this.livro1 = livro1;
	}

	
	
}