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

	// SALVA NO BANDO DE DADOS A LOCACAO
	public boolean salvarLocacao(LocacaoBean locacao) throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();
		return ldao.saveLocacao(locacao);
	}

	// EDITAR NO BANCO DE DADOS A LOCACAO EXISTENTE
	public boolean editarLocacao(LocacaoBean locacao) throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();
		return ldao.updateLocacao(locacao);
	}

	// REMOVE A LOCACAO DO BANCO DE DADOS
	public boolean deletarLocacao(LocacaoBean locacao) throws ProjetoException {
		LocacaoDAO ldao = new LocacaoDAO();
		return ldao.removeLocacao(locacao);
	}

	public ArrayList<LocacaoBean> getListaLocacoes(ArrayList<LocacaoBean> listaLocacoes) throws ProjetoException {
		if (listaLocacoes == null) {
			LocacaoDAO ldao = new LocacaoDAO();
			listaLocacoes = ldao.listLocacoes();
		}
		return listaLocacoes;
	}
}
