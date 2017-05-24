package com.accenture.treinamento.projeto.portal.controller;

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


@ManagedBean(name = "MBProfessores")
@SessionScoped
public class ProfessorController {

	private ProfessorBean professor;
	private List<ProfessorBean> listaprofessor;
	
	public ProfessorController(){
		
		professor = new ProfessorBean();

		listaprofessor = new ArrayList<>();
		listaprofessor = null;
	}

	
	public void cadastrarProfessor() throws ProjetoException{
		ProfessorDAO Pdao = new ProfessorDAO();
		boolean cadastrou = Pdao.cadastrarProfessor(professor);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadProfessor.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadProfessor.hide();");
		}
	}
	
	public void alterarProfessor() throws ProjetoException {

		ProfessorDAO Pdao = new ProfessorDAO();
		boolean alterou = Pdao.alterarProfessor(professor);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
		}
	}

	public void excluirAutor() throws ProjetoException {
		ProfessorDAO Pdao = new ProfessorDAO();
		boolean excluiu = Pdao.excluirProfessor(professor);

		if (excluiu == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// listaLaudo = null;
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}
	
	public ProfessorBean getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}

	public List<ProfessorBean> getListaprofessor() throws ProjetoException {
		if (listaprofessor == null) {
			ProfessorDAO pdao = new ProfessorDAO();
			listaprofessor = pdao.listaProfessor();
		}
		return listaprofessor;
	}

	public void setListaprofessor(List<ProfessorBean> listaprofessor) {
		this.listaprofessor = listaprofessor;
	}
	
	public void LimparObjeto() {
		professor = null;
	}
	
}
