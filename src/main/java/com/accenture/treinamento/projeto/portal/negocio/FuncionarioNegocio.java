package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.FuncionarioDAO;
import com.accenture.treinamento.projeto.portal.model.FuncionarioBean;

/**
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */


public class FuncionarioNegocio {

	public boolean cadastrarFuncionario(FuncionarioBean funcionario) throws ProjetoException {

		FuncionarioDAO adao = new FuncionarioDAO();
		boolean cadastrou = adao.cadastrarFuncionario(funcionario);
		return cadastrou;
	}

	public boolean alterarFuncionario(FuncionarioBean funcionario) throws ProjetoException {

		FuncionarioDAO adao = new FuncionarioDAO();
		boolean alterou = adao.alterarFuncionario(funcionario);
		return alterou;
	}

	public boolean excluirFuncionario(FuncionarioBean funcionario) throws ProjetoException {
		
		FuncionarioDAO adao = new FuncionarioDAO();
		boolean excluir = adao.excluirFuncionario(funcionario);
		return excluir;
	}
	
	public List<FuncionarioBean> getListaFuncionario() throws ProjetoException {
		FuncionarioDAO adao = new FuncionarioDAO();
		return adao.listaFuncionario();
	}
	public List<FuncionarioBean> buscarFuncionario(String campo, Integer tipo) throws ProjetoException {
		FuncionarioDAO adao = new FuncionarioDAO();
		return adao.buscarTipoFuncionario(campo, tipo);
	}
		

}