package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.AutorDAO;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/
@ManagedBean
@SessionScoped
public class AutorController {

	private AutorBean autor;

	private List<AutorBean> listaAutor;

	public AutorController() {
		autor = new AutorBean();

		listaAutor = new ArrayList<>();
		listaAutor = null;
	}

	public void cadastrarAutor() {

		AutorDAO adao = new AutorDAO();
		boolean cadastrou = adao.cadastrarAutor(autor);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Autor cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAutor.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAutor.hide();");
		}

	}

	public void alterarAutor() throws ProjetoException {

		AutorDAO adao = new AutorDAO();
		boolean alterou = adao.alterarAutor(autor);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Autor alterado com sucesso!", "Sucesso");
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
		AutorDAO adao = new AutorDAO();
		boolean excluiu = adao.excluirAutor(autor);

		if (excluiu == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Autor excluido com sucesso!", "Sucesso");
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

	public void limparObjeto() {
		autor = null;
	}

	public AutorBean getAutor() {
		return autor;
	}

	public void setAutor(AutorBean autor) {
		this.autor = autor;
	}

	public List<AutorBean> getListaAutor() {
		if (listaAutor == null) {
			AutorDAO adao = new AutorDAO();
			listaAutor = adao.listaAutor();

		}
		return listaAutor;
	}

	public void setListaAutor(List<AutorBean> listaAutor) {
		this.listaAutor = listaAutor;
	}

}
