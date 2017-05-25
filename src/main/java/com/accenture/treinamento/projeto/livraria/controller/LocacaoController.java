package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;
import com.accenture.treinamento.projeto.livraria.negocio.LocacaoNegocio;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/
@ManagedBean(name = "MBLocacao")
@SessionScoped
public class LocacaoController {
	private LocacaoBean locacao;
	private ArrayList<LocacaoBean> listaLocacoes;
	private ArrayList<LocacaoBean> listaLivros;

	public LocacaoController() {
		locacao = new LocacaoBean();

		listaLocacoes = new ArrayList<>();
		listaLocacoes = null;
	}

	// SALVA NO BANDO DE DADOS A LOCACAO
	public void salvarLocacao() throws ProjetoException {
		LocacaoNegocio ldao = new LocacaoNegocio();

		if (ldao.salvarLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao adicionada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaLocacoes = null;
			listaLivros = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// EDITAR NO BANCO DE DADOS A LOCACAO EXISTENTE
	public void editarLocacao() throws ProjetoException {
		LocacaoNegocio ldao = new LocacaoNegocio();

		if (ldao.editarLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao editada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaLocacoes = null;
			listaLivros = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a edicao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// REMOVE A LOCACAO DO BANCO DE DADOS
	public void deletarLocacao() throws ProjetoException {
		LocacaoNegocio ldao = new LocacaoNegocio();

		if (ldao.deletarLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao deletada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaLocacoes = null;
			listaLivros = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o procedimento!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public LocacaoBean getLocacao() {
		return locacao;
	}

	public void setLocacao(LocacaoBean locacao) {
		this.locacao = locacao;
	}

	public ArrayList<LocacaoBean> getListaLocacoes() throws ProjetoException {
			LocacaoNegocio ldao = new LocacaoNegocio();
			return listaLocacoes = ldao.getListaLocacoes(listaLocacoes);
	}

	public void setListaLocacoes(ArrayList<LocacaoBean> listaLocacoes) {
		this.listaLocacoes = listaLocacoes;
	}
	
	public void addLivros(Integer id_livro){
		
	}

}
