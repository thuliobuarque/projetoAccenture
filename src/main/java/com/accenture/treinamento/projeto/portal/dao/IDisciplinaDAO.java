package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;

public interface IDisciplinaDAO {
	
	public abstract boolean cadastrarDisciplina(DisciplinaBean disciplina) throws ProjetoException;
	public abstract boolean alterarDisciplina(DisciplinaBean disciplina) throws ProjetoException;
	public abstract boolean excluirDisciplina(DisciplinaBean disciplina) throws ProjetoException;
	public abstract List listaDisciplina() throws ProjetoException;
	public List<DisciplinaBean> buscarDisciplina(String valor, Integer tipo)throws ProjetoException ;

}
