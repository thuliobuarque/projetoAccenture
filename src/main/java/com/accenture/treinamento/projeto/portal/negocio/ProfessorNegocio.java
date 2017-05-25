package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.ProfessorDAO;
import com.accenture.treinamento.projeto.portal.model.ProfessorBean;


/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class ProfessorNegocio {
	
	public boolean cadastrarProfessor(ProfessorBean professor) throws ProjetoException{
		
		ProfessorDAO Pdao = new ProfessorDAO();
		boolean cadastrou = Pdao.cadastrarProfessor(professor);
		return cadastrou;
	}
	
	public boolean alterarProfessor(ProfessorBean professor) throws ProjetoException {

		ProfessorDAO Pdao = new ProfessorDAO();
		boolean alterou = Pdao.alterarProfessor(professor);
		return alterou;
	}

	public boolean excluirProfessor(ProfessorBean professor) throws ProjetoException {
		ProfessorDAO Pdao = new ProfessorDAO();
		boolean excluiu = Pdao.excluirProfessor(professor);
		return excluiu;
	}
	
	public List<ProfessorBean> getListaProfessor() throws ProjetoException {
		ProfessorDAO Pdao = new ProfessorDAO();
		return Pdao.listaProfessor();
	}
	public List<ProfessorBean> buscarProfessor(String campo, Integer tipo) throws ProjetoException {
		ProfessorDAO Pdao = new ProfessorDAO();
		return Pdao.buscarProfessor(campo, tipo);
	}
	
}
