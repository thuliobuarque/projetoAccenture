package com.accenture.treinamento.projeto.portal.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
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
	private AlunoNegocio alunoNegocio;

	private AlunoBean aluno;


	public AlunoController() {
		// INSTANCIAS
		alunoNegocio = new AlunoNegocio();
		aluno = new AlunoBean();

	}

	// METODO DE AUTENTICAR ALUNO
	public String loginTeste() throws ProjetoException {

    return "/pages/comum/principal.faces?faces-redirect=true";
	
	}
	


	// METODO DE ADCIONAR ALUNO
	public void cadastrarAluno() throws ProjetoException {

		AlunoNegocio adao = new AlunoNegocio();
		adao.cadastrarAluno(aluno);
	
	}

	// METODO DE ALTERAR ALUNO
	public void alterarAluno() throws ProjetoException {

		AlunoNegocio adao = new AlunoNegocio();
		adao.alterarAluno(aluno);

	}

	// METODO DE EXCLUIR ALUNO
	public void excluirAluno() throws ProjetoException {
		
		AlunoNegocio adao = new AlunoNegocio();
		adao.excluirAluno(aluno);	
	}
	
	public void buscarAlunos() throws ProjetoException {
		
		AlunoNegocio adao = new AlunoNegocio();
        adao.buscarAlunos();
        
	}
	
	public void limparDados() {
	aluno = new AlunoBean();
	}
	
	
    public String logout() {
        SessionUtil.getSession().invalidate();
        return "/pages/comum/login.faces?faces-redirect=true";
    }

	public AlunoNegocio getAlunoNegocio() {
		return alunoNegocio;
	}

	public void setAlunoNegocio(AlunoNegocio alunoNegocio) {
		this.alunoNegocio = alunoNegocio;
	}

	public AlunoBean getAluno() {
		return aluno;
	}

	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}
    

}