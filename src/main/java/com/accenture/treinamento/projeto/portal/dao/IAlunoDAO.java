package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

public interface IAlunoDAO {

	public abstract boolean cadastrarAluno(AlunoBean usuario) throws ProjetoException;
	public abstract boolean alterarAluno(AlunoBean usuario) throws ProjetoException;
	public abstract boolean excluirAluno(AlunoBean usuario) throws ProjetoException;
	public abstract List listaAluno() throws ProjetoException;


}
