package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public class ReservaBean {
	
	private Integer id;
	private Integer pessoa;
	private Date dataRetirada;
	private Integer id_livro;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPessoa() {
		return pessoa;
	}
	public Integer getId_livro() {
		return id_livro;
	}
	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}
	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	
	
}