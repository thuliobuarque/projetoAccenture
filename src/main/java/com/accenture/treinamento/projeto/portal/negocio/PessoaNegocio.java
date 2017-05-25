package com.accenture.treinamento.projeto.portal.negocio;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.PessoaDAO;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */


public class PessoaNegocio {

	private PessoaBean pessoa;
	public PessoaNegocio() {
		pessoa = new PessoaBean();
	}

	// METODO DE AUTENTICAR ALUNO
	public String login() throws ProjetoException {

		PessoaDAO ud = new PessoaDAO();
		pessoa = ud.autenticarPessoa(pessoa);
		if (pessoa == null) {
			FacesContext fct = FacesContext.getCurrentInstance();
			fct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login ou senha inv�lidos!", "Erro"));

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