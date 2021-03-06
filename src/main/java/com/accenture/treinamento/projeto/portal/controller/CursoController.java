
package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;
import com.accenture.treinamento.projeto.portal.dao.CursoDAO;
import com.accenture.treinamento.projeto.portal.model.CursoBean;
import com.accenture.treinamento.projeto.portal.negocio.AlunoNegocio;
import com.accenture.treinamento.projeto.portal.negocio.CursoNegocio;

/**
 * @author Thulio, Thayse, Thales, Caio, Priscila, Veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBCurso")
@SessionScoped
public class CursoController {

	private CursoBean curso;

	
	private List<CursoBean> listaCurso;
	
	private String campoBuscaCurso;
	private Integer tipoBuscaCurso;
	private Integer abaAtiva = 0;

	public CursoController() {

		curso = new CursoBean();

		listaCurso = new ArrayList<>();
		listaCurso = null;
		
		tipoBuscaCurso = 1;
		campoBuscaCurso = "";
	}

	public void cadastrarCurso() throws ProjetoException {

		CursoNegocio Cdao = new CursoNegocio();

		if (Cdao.cadastrarCurso(curso)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
			listaCurso = null;

		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		}
	}

	public void alterarCurso() throws ProjetoException {

		CursoNegocio Cdao = new CursoNegocio();

		if (Cdao.alterarCurso(curso)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
			listaCurso = null;
			
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
		}
	}

	public void excluirCurso() throws ProjetoException {

		CursoNegocio Cdao = new CursoNegocio();

		if (Cdao.excluirCurso(curso)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
			listaCurso = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante a exclusao!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
		}
	}
	
    /*public void buscarCurso() throws ProjetoException {

		CursoNegocio Cdao = new CursoNegocio();

		listaCurso = Cdao.buscarCurso(campoBuscaCurso, tipoBuscaCurso);

		if (listaCurso == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhum curso encontrado.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
    }*/

	public void LimparObjeto() {
		curso = null;
	}

	public CursoBean getAluno() {
		return curso;
	}
	
	public void limparBuscaDados() {
		tipoBuscaCurso = 1;
		campoBuscaCurso = "";
	}
	
	public void limparDados() {
		curso = new CursoBean();
		}

	public void setCurso(CursoBean curso) {
		this.curso = curso;
	}

	public List<CursoBean> getListaCurso() throws ProjetoException {
		if (listaCurso == null) {
			CursoNegocio adao = new CursoNegocio();
			listaCurso = adao.getListaCurso();
		}
		return listaCurso;
	}

	public void setListaAluno(List<CursoBean> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public String getCampoBuscaCurso() {
		return campoBuscaCurso;
	}

	public void setCampoBuscaCurso(String campoBuscaCurso) {
		this.campoBuscaCurso = campoBuscaCurso;
	}

	public Integer getTipoBuscaCurso() {
		return tipoBuscaCurso;
	}

	public void setTipoBuscaCurso(Integer tipoBuscaCurso) {
		this.tipoBuscaCurso = tipoBuscaCurso;
	}

	public Integer getAbaAtiva() {
		return abaAtiva;
	}

	public void setAbaAtiva(Integer abaAtiva) {
		this.abaAtiva = abaAtiva;
	}

	public CursoBean getCurso() {
		return curso;
	}

	public void setListaCurso(List<CursoBean> listaCurso) {
		this.listaCurso = listaCurso;
	}
	
	

}