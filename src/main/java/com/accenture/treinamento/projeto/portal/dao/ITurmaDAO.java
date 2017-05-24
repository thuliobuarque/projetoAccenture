package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;

public interface ITurmaDAO {
	
	public abstract boolean cadastrarTurma(TurmaBean turma) throws ProjetoException;
	public abstract boolean alterarTurma(TurmaBean turma) throws ProjetoException;
	public abstract boolean excluirTurma(TurmaBean turma) throws ProjetoException;
	public abstract List listaTurma() throws ProjetoException;

}
