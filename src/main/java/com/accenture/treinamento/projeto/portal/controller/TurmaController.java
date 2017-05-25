package com.accenture.treinamento.projeto.portal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.negocio.AutorNegocio;
import com.accenture.treinamento.projeto.portal.controller.TurmaController;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;
import com.accenture.treinamento.projeto.portal.negocio.TurmaNegocio;
import com.accenture.treinamento.projeto.portal.dao.TurmaDAO;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBTurma")
@SessionScoped
public class TurmaController {

	private TurmaBean turma;

	private List<TurmaBean> listaTurma;
	
	private String campoBuscaTurma;

	public TurmaController() {

		turma = new TurmaBean();


		listaTurma = new ArrayList<>();
		listaTurma = null;

	}

	public void cadastrarTurma() throws ProjetoException {

		TurmaNegocio Tdao = new TurmaNegocio();
		
		if (Tdao.cadastrarTurma(turma)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadTurma.hide();");
			listaTurma = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadTurma.hide();");
		}
	}

	public void alterarTurma() throws ProjetoException {

		TurmaNegocio Tdao = new TurmaNegocio();
		
		if (Tdao.alterarTurma(turma)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma alterada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltTurma.hide();");
			listaTurma = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltTurma.hide();");
		}
	}

	public void excluirTurma() throws ProjetoException {
		TurmaNegocio Tdao = new TurmaNegocio();
		
		if (Tdao.excluirTurma(turma)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma exclu�da com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// listaLaudo = null;
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
			listaTurma = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}
	
	public void buscarTurma() throws ProjetoException {

		TurmaNegocio Tdao = new TurmaNegocio();

		listaTurma = Tdao.buscarTurma(campoBuscaTurma);

		if (listaTurma == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhuma turma encontrada.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void LimparObjeto() {
		turma = null;
	}

	public TurmaBean getTurma() {
		return turma;
	}

	public void setTurma(TurmaBean turma) {
		this.turma = turma;
	}

	public List<TurmaBean> getListaTurma() {
		if (listaTurma == null) {
			TurmaNegocio tdao = new TurmaNegocio();
			listaTurma = tdao.listaTurma();
		}
		return listaTurma;
	}

	public void setListaTurma(List<TurmaBean> listaTurma) {
		this.listaTurma = listaTurma;
	}

}
