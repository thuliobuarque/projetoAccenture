package com.accenture.treinamento.projeto.portal.controller;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.negocio.AlunoNegocio;
import com.accenture.treinamento.projeto.util.CepWebService;
import com.accenture.treinamento.projeto.util.ClientRest;
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

	 private Integer abaAtiva = 0;
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
	public void cadastrarAluno() throws ProjetoException, MalformedURLException {

		AlunoNegocio adao = new AlunoNegocio();

		
		if (adao.cadastrarAluno(aluno)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadAluno.hide();");
		}
	
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
		

    public void encontraCEP() {
        CepWebService cepWebService = new CepWebService(aluno.getCep());
 
        if (cepWebService.getResultado() == 1) {
            aluno.setTipoLogradouro(cepWebService.getTipoLogradouro());
            aluno.setLogradouro(cepWebService.getLogradouro());
            aluno.setEstado(cepWebService.getEstado());
            aluno.setCidade(cepWebService.getCidade());
            aluno.setBairro(cepWebService.getBairro());
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Servidor não está respondendo",
                            "Servidor não está respondendo"));
        }
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

	public Integer getAbaAtiva() {
		return abaAtiva;
	}

	public void setAbaAtiva(Integer abaAtiva) {
		this.abaAtiva = abaAtiva;
	}
    

}