package com.accenture.treinamento.projeto.livraria.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;

public interface IAutorDAO {

	public abstract boolean cadastrarAutor(AutorBean autor) throws ProjetoException;
	public abstract boolean alterarAutor(AutorBean autor) throws ProjetoException;
	public abstract boolean excluirAutor(AutorBean autor) throws ProjetoException;
	public abstract List listaAutor() throws ProjetoException;
	
}
