package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;
import com.accenture.treinamento.projeto.portal.model.FuncionarioBean;
import com.accenture.treinamento.projeto.portal.dao.DisciplinaDAO;
import com.accenture.treinamento.projeto.portal.dao.FuncionarioDAO;

/**
 * @author Thulio, thayse, Thales, Caio, Priscila, Veridiana
 * @since 17/05/2017
 */


public class DisciplinaNegocio {
	
	public boolean cadastrarDisciplina(DisciplinaBean disciplina) throws ProjetoException {

		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean cadastrou = Ddao.cadastrarDisciplina(disciplina);
		return cadastrou;

	}

	public boolean alterarDisciplina(DisciplinaBean disciplina) throws ProjetoException {

		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean alterou = Ddao.alterarDisciplina(disciplina);
		return alterou;

	}

	public boolean excluirDisciplina(DisciplinaBean disciplina) throws ProjetoException {
		DisciplinaDAO Ddao = new DisciplinaDAO();
		boolean excluir = Ddao.excluirDisciplina(disciplina);
		return excluir;

	}
	
	public List<DisciplinaBean> getListaDisciplina() throws ProjetoException {
		DisciplinaDAO Ddao = new DisciplinaDAO();
		return Ddao.listaDisciplina();
	}
	
	public List<DisciplinaBean> buscarDisciplina(String campo, Integer tipo) throws ProjetoException {
		DisciplinaDAO Ddao = new DisciplinaDAO();
		return Ddao.buscarDisciplina(campo, tipo);
	}
	
	
}
