package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.dao.PessoaDAO;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;
import com.accenture.treinamento.projeto.util.SessionUtil;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */


public class PessoaNegocio {

	public PessoaBean autenticarPessoa(PessoaBean pessoa) throws ProjetoException {
		PessoaDAO ud = new PessoaDAO();
		return ud.autenticarPessoa(pessoa);

	}


}