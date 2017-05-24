package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.FuncionarioBean;

public interface IFuncionarioDAO {
	
	public abstract boolean cadastrarFuncionario(FuncionarioBean funcionario) throws ProjetoException;
	public abstract boolean alterarFuncionario(FuncionarioBean funcionario) throws ProjetoException;
	public abstract boolean excluirFuncionario(FuncionarioBean funcionario) throws ProjetoException;
	public abstract List listaFuncionario() throws ProjetoException;


}
