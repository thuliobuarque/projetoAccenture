package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;
import com.accenture.treinamento.projeto.portal.negocio.DisciplinaNegocio;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.dao.DisciplinaDAO;

/**
 * @author Thulio, thayse, Thales, Caio, Priscila, Veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBDisciplinas")
@SessionScoped
public class DisciplinaController {

	private DisciplinaBean disciplina;
	private List<DisciplinaBean> listaDisciplina;
	private String tipo;
	private Integer tipoBuscaDisciplina;
	private String campoBuscaDisciplina;
	private String statusDisciplina;

	
	public DisciplinaController() {
		
		disciplina = new DisciplinaBean();

		listaDisciplina = new ArrayList<>();
		listaDisciplina = null;
		
		tipo = "";
		tipoBuscaDisciplina = 1;
		campoBuscaDisciplina = "";
		statusDisciplina = "P";
	}

	public void cadastrarDisciplina() throws ProjetoException {

		DisciplinaNegocio Ddao = new DisciplinaNegocio();


		if (Ddao.cadastrarDisciplina(disciplina)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadDisciplina.hide();");
			listaDisciplina = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro da disciplina!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgCadDisciplina.hide();");
		}
	}

	public void alterarDisciplina() throws ProjetoException {

		DisciplinaNegocio Ddao = new DisciplinaNegocio();
		
		if (Ddao.alterarDisciplina(disciplina)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina alterada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgAltDisciplina.hide();");
			listaDisciplina = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgAltDisciplina.hide();");
		}
	}

		public void excluirDisciplina() throws ProjetoException {
		
		DisciplinaNegocio Ddao = new DisciplinaNegocio();

		if (Ddao.excluirDisciplina(disciplina)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina excluída com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
			listaDisciplina = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}

	public void LimparObjeto() {
		disciplina = null;
	}

	public DisciplinaNegocio getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaNegocio disciplina) {
		this.disciplina = disciplina;
	}

	public List<DisciplinaBean> getListaDisciplina() {
		
		if (listaDisciplina == null) {
			DisciplinaNegocio Ddao = new DisciplinaNegocio();
			listaDisciplina = Ddao.listaDisciplina();
		}
		return listaDisciplina;
	}

	public void setListaDisciplina(List<DisciplinaBean> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

}
