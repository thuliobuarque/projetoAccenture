package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public class LocacaoBean {
	
	private Integer id;
	private PessoaBean pessoa;
	private Date dataLocacao;
	private Date dataEntrega;
	private LivroBean livro;
	
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
	public LivroBean getLivro() {
		return livro;
	}
	public void setLivro(LivroBean livro) {
		this.livro = livro;
	}

	

}
