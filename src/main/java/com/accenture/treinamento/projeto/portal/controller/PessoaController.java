package com.accenture.treinamento.projeto.portal.controller;

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

@ManagedBean(name = "MBPessoa")
@ViewScoped
public class PessoaController {

	private PessoaBean pessoa;
	public PessoaController() {
		pessoa = new PessoaBean();
	}

	// METODO DE AUTENTICAR ALUNO
	public String login() throws ProjetoException {

		PessoaDAO ud = new PessoaDAO();
		pessoa = ud.autenticarPessoa(pessoa);
		if (pessoa == null) {
			FacesContext fct = FacesContext.getCurrentInstance();
			fct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login ou senha inválidos!", "Erro"));

			return "";
		} else {			
			return "/pages/comum/principal.faces?faces-redirect=true";
		}
	}

	public PessoaBean getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}

	
	
	

}