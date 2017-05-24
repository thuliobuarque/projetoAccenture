package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.ProfessorBean;

public interface IProfessorDAO {
	
	public abstract boolean cadastrarProfessor(ProfessorBean professor) throws ProjetoException;
	public abstract boolean alterarProfessor(ProfessorBean professor) throws ProjetoException;
	public abstract boolean excluirProfessor(ProfessorBean professor) throws ProjetoException;
	public abstract List<ProfessorBean> listaProfessor() throws ProjetoException;
	
}
