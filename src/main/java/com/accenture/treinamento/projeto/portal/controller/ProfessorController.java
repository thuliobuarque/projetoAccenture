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
import com.accenture.treinamento.projeto.portal.negocio.AlunoNegocio;
import com.accenture.treinamento.projeto.portal.negocio.ProfessorNegocio;


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
	
	private String campoBuscaProfessor;
	private Integer tipoBuscaProfessor;
	private Integer abaAtiva = 0;
	
	public ProfessorController(){
		
		professor = new ProfessorBean();

		listaprofessor = new ArrayList<>();
		listaprofessor = null;
		
		tipoBuscaProfessor = 1;
		campoBuscaProfessor = "";
	}

	
	public void cadastrarProfessor(ProfessorBean professor) throws ProjetoException{
		
		ProfessorDAO Pdao = new ProfessorDAO();

		if (Pdao.cadastrarProfessor(professor)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadProfessor.hide();");
			listaprofessor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadProfessor.hide();");
		}
	}
	
	public void alterarProfessor(ProfessorBean professor) throws ProjetoException {

		ProfessorDAO Pdao = new ProfessorDAO();

		if (Pdao.alterarProfessor(professor)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
			listaprofessor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
		}
	}

	public void excluirAutor() throws ProjetoException {
		
		ProfessorDAO Pdao = new ProfessorDAO();
		
		if (Pdao.excluirProfessor(professor)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Professor excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// listaLaudo = null;
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
			listaprofessor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}
	
   /* public void buscarProfessor() throws ProjetoException {

		ProfessorNegocio Pdao = new ProfessorNegocio();

		listaprofessor = Pdao.buscarProfessor(campoBuscaProfessor, tipoBuscaProfessor);

		if (listaprofessor == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhum professor encontrado.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
    }*/
	
	public ProfessorBean getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}

	public List<ProfessorBean> getListaprofessor() throws ProjetoException {
		if (listaprofessor == null) {
			ProfessorNegocio Pdao = new ProfessorNegocio();
			listaprofessor = Pdao.getListaProfessor();
		}
		return listaprofessor;
	}

	public void setListaprofessor(List<ProfessorBean> listaprofessor) {
		this.listaprofessor = listaprofessor;
	}
	
	public void LimparObjeto() {
		professor = null;
	}


	public String getCampoBuscaProfessor() {
		return campoBuscaProfessor;
	}


	public void setCampoBuscaProfessor(String campoBuscaProfessor) {
		this.campoBuscaProfessor = campoBuscaProfessor;
	}


	public Integer getTipoBuscaProfessor() {
		return tipoBuscaProfessor;
	}


	public void setTipoBuscaProfessor(Integer tipoBuscaProfessor) {
		this.tipoBuscaProfessor = tipoBuscaProfessor;
	}


	public Integer getAbaAtiva() {
		return abaAtiva;
	}


	public void setAbaAtiva(Integer abaAtiva) {
		this.abaAtiva = abaAtiva;
	}
	
	
	
}
