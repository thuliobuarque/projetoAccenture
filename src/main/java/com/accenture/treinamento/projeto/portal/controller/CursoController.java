
package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.CursoDAO;
import com.accenture.treinamento.projeto.portal.model.CursoBean;

/**
 *
 * @author Thulio, Thayse, Thales, Caio, Priscila, Veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBCurso")
@SessionScoped
public class CursoController {

	// OBJETOS E CLASSES
	private CursoBean curso;

	// LISTAS
	private List<CursoBean> listaCurso;

	public CursoController() {
		// INSTANCIAS
		curso = new CursoBean();

		// LISTAS
		listaCurso = new ArrayList<>();
		listaCurso = null;

	}

	
	// METODO DE ADCIONAR CURSO
	public void cadastrarCurso() throws ProjetoException {

		CursoDAO Cdao = new CursoDAO();
		boolean cadastrou = Cdao.cadastrarCurso(curso);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		}
	}

	// METODO DE ALTERAR CURSO
	public void alterarCurso() throws ProjetoException {

		CursoDAO Cdao = new CursoDAO();
		boolean alterou = Cdao.alterarCurso(curso);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Curso alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
		}
	}

	// METODO DE EXCLUIR Curso
	public void excluirCurso() throws ProjetoException {
		CursoDAO Cdao = new CursoDAO();
		boolean excluir = Cdao.excluirCurso(curso);

		if (excluir == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Curso excluido com sucesso!", "Sucesso");
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

	public void LimparObjeto() {
		curso = null;
	}

	public CursoBean getAluno() {
		return curso;
	}

	public void setCurso(CursoBean curso) {
		this.curso = curso;
	}

	public List<CursoBean> getListaCurso() {
		if (listaCurso == null) {
			CursoDAO adao = new CursoDAO();
			listaCurso = adao.listaCurso();
		}
		return listaCurso;
	}

	public void setListaAluno(List<CursoBean> listaCurso) {
		this.listaCurso = listaCurso;
	}

}