package com.accenture.treinamento.projeto.livraria.negocio;

import java.util.ArrayList;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.LocacaoDAO;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class LocacaoNegocio {
	// OBJETOS E CLASSES
	private LocacaoBean locacao;
	// LISTA
	private ArrayList<LocacaoBean> listaLocacoes;

	public LocacaoNegocio() {

		// INSTANCIAS
		locacao = new LocacaoBean();

		// LISTA
		listaLocacoes = new ArrayList<>();
		listaLocacoes = null;
	}

	// SALVA NO BANDO DE DADOS A LOCACAO
	public void salvarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.saveLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao adicionada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// EDITAR NO BANCO DE DADOS A LOCACAO EXISTENTE
	public void editarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.updateLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao editada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a edicao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	// REMOVE A LOCACAO DO BANCO DE DADOS
	public void deletarLocacao() throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();

		if (ldao.removeLocacao(locacao)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Locacao deletada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
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
		if (listaLocacoes == null) {
			LocacaoDAO ldao = new LocacaoDAO();
			listaLocacoes = ldao.listLocacoes();
		}
		return listaLocacoes;
	}

	public void setListaLocacoes(ArrayList<LocacaoBean> listaLocacoes) {
		this.listaLocacoes = listaLocacoes;
	}

}
