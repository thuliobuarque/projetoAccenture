package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;
import com.accenture.treinamento.projeto.livraria.negocio.AutorNegocio;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */
@ManagedBean(name = "MBAutor")
@SessionScoped
public class AutorController {

	private AutorBean autor;

	private List<AutorBean> listaAutor;

	private String campoBuscaAutor;
	private Integer tipoBuscaAutor;

	public AutorController() {
		autor = new AutorBean();

		listaAutor = new ArrayList<>();
		listaAutor = null;
	}

	public void cadastrarAutor() {
		listaAutor = null;
		AutorNegocio an = new AutorNegocio();

		if (an.cadastrarAutor(autor)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			RequestContext.getCurrentInstance().execute("dlgCadAutor.hide();");
			listaAutor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAutor.hide();");
		}

	}

	public void alterarAutor() throws ProjetoException {
		listaAutor = null;
		AutorNegocio an = new AutorNegocio();

		if (an.alterarAutor(autor)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
			listaAutor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAutor.hide();");
		}
	}

	public void excluirAutor() throws ProjetoException {
		listaAutor = null;
		AutorNegocio an = new AutorNegocio();

		if (an.excluirAutor(autor)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// listaLaudo = null;
			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
			listaAutor = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante a exclusao!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
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

	public List<AutorBean> ListaAutor() throws ProjetoException {
		if(listaAutor == null){
			AutorNegocio an = new AutorNegocio();
			listaAutor = an.getListaAutor();			
		}
		return listaAutor;
	}
	
	public List<AutorBean> ListaAutores() throws ProjetoException {
	System.out.println("entrou aqui");
			AutorNegocio an = new AutorNegocio();
			return listaAutor = an.getListaAutor();			

	}
	
	public void limparBuscaDados() {
		tipoBuscaAutor = 1;
		campoBuscaAutor = "";
	}
	
	public void limparDados() {
		autor = new AutorBean();
		}

	public void setListaAutor(List<AutorBean> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public void buscarAutor() throws ProjetoException {

		AutorNegocio adao = new AutorNegocio();

		listaAutor = adao.buscarAutor(campoBuscaAutor, tipoBuscaAutor);

		if (listaAutor == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhum autor encontrado.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

}
