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
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;
import com.accenture.treinamento.projeto.portal.negocio.AlunoNegocio;
import com.accenture.treinamento.projeto.util.SessionUtil;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBAlunos")
@ViewScoped
public class AlunoController {

	// OBJETOS E CLASSES
	private AlunoBean aluno;



	public AlunoController() {
		// INSTANCIAS
		aluno = new AlunoBean();

	}

	// METODO DE AUTENTICAR ALUNO
	public String loginTeste() throws ProjetoException {

    return "/pages/comum/principal.faces?faces-redirect=true";
	
	}
	


	// METODO DE ADCIONAR ALUNO
	public void cadastrarAluno() throws ProjetoException {

		AlunoNegocio adao = new AlunoNegocio();
		adao.cadastrarAluno();
	
	}

	// METODO DE ALTERAR ALUNO
	public void alterarAluno() throws ProjetoException {

		AlunoNegocio adao = new AlunoNegocio();
		adao.alterarAluno();

	}

	// METODO DE EXCLUIR ALUNO
	public void excluirAluno() throws ProjetoException {
		
		AlunoNegocio adao = new AlunoNegocio();
		adao.excluirAluno();	
	}
	
	public void buscarAlunos() throws ProjetoException {
		
		AlunoNegocio adao = new AlunoNegocio();
        adao.buscarAlunos();
        
	}
	
	 public void recoverDataFromSessionAluno() {
	        aluno = (AlunoBean) FacesContext
	            .getCurrentInstance().getExternalContext().getSessionMap()
	            .get("obj_aluno");
	        
	    }
	
    public String logout() {
        SessionUtil.getSession().invalidate();
        return "/pages/comum/login.faces?faces-redirect=true";
    }

	public AlunoBean getAluno() {
		return aluno;
	}

	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}
	


}