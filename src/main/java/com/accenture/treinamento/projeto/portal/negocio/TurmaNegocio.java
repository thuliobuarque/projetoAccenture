package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.controller.TurmaController;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;
import com.accenture.treinamento.projeto.portal.dao.TurmaDAO;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */


public class TurmaNegocio {

	public boolean cadastrarTurma(TurmaBean turma) throws ProjetoException {

		TurmaDAO Tdao = new TurmaDAO();
		boolean cadastrou = Tdao.cadastrarTurma(turma);
		return cadastrou;
	}

	public boolean alterarTurma(TurmaBean turma) throws ProjetoException {

		TurmaDAO Tdao = new TurmaDAO();
		boolean alterou = Tdao.alterarTurma(turma);
		return alterou;
	}

	public boolean excluirTurma(TurmaBean turma) throws ProjetoException {
		
		TurmaDAO Tdao = new TurmaDAO();
		boolean excluir = Tdao.excluirTurma(turma);
		return excluir;
	}
	
	public List<TurmaBean> getListaTurma() throws ProjetoException {
		TurmaDAO Tdao = new TurmaDAO();
		return Tdao.listaTurma();
	}
	
	public List<TurmaBean> buscarTurma(String campo, Integer tipo) throws ProjetoException {
		TurmaDAO Tdao = new TurmaDAO();
		return Tdao.buscarTurma(campo, tipo);
	}
	
	
}