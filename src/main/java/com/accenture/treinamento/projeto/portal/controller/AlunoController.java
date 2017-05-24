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

	// LISTAS
	private List<AlunoBean> listaAluno;
	
	// BUSCAS
	private String tipo;
	private Integer tipoBuscaAluno;
	private String campoBuscaAluno;
	private String statusAluno;

	public AlunoController() {
		// INSTANCIAS
		aluno = new AlunoBean();

		// LISTAS
		listaAluno = new ArrayList<>();
		listaAluno = null;
		
		// BUSCA
		tipo = "";
		tipoBuscaAluno = 1;
		campoBuscaAluno = "";
		statusAluno = "P";

	}

	// METODO DE AUTENTICAR ALUNO
	public String loginTeste() throws ProjetoException {

    return "/pages/comum/principal.faces?faces-redirect=true";
	
	}

	// METODO DE ADCIONAR ALUNO
	public void cadastrarAlunoMysql() throws ProjetoException {

		AlunoDAO adao = new AlunoDAO();
		boolean cadastrou = adao.cadastrarAlunoMysql(aluno);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaAluno = null;
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

		AlunoDAO adao = new AlunoDAO();
		boolean alterou = adao.alterarAluno(aluno);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaAluno = null;
			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltAluno.hide();");
		}
	}

	// METODO DE EXCLUIR ALUNO
	public void excluirAluno() throws ProjetoException {
		AlunoDAO adao = new AlunoDAO();
		boolean excluio = adao.excluirAluno(aluno);

		if (excluio == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaAluno = null;
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}
	
	public void buscarAlunos() throws ProjetoException {

		List<AlunoBean> listaAux = null;
		listaAluno = new ArrayList<>();

		AlunoDAO adao = new AlunoDAO();

		listaAux = adao.buscarTipoAluno(campoBuscaAluno, tipoBuscaAluno);

		if (listaAux != null && listaAux.size() > 0) {
			// listaAss = null;
			listaAluno = listaAux;
		} else {
			// listaAss = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nenhum Aluno encontrada.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

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
	
	public void limparBuscaDados() {
		tipoBuscaAluno = 1;
		campoBuscaAluno = "";
		statusAluno = "P";
		listaAluno = null;
	}

	public void limparDados() {
		aluno = new AlunoBean();
		PessoaBean pessoa = new PessoaBean();

	}

	public AlunoBean getAluno() {
		return aluno;
	}

	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}

	public List<AlunoBean> getListaAluno() {
		if (listaAluno == null) {
			AlunoDAO adao = new AlunoDAO();
			listaAluno = adao.listaAluno();
		}
		return listaAluno;
	}

	public void setListaAluno(List<AlunoBean> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTipoBuscaAluno() {
		return tipoBuscaAluno;
	}

	public void setTipoBuscaAluno(Integer tipoBuscaAluno) {
		this.tipoBuscaAluno = tipoBuscaAluno;
	}

	public String getCampoBuscaAluno() {
		return campoBuscaAluno;
	}

	public void setCampoBuscaAluno(String campoBuscaAluno) {
		this.campoBuscaAluno = campoBuscaAluno;
	}

	public String getStatusAluno() {
		return statusAluno;
	}

	public void setStatusAluno(String statusAluno) {
		this.statusAluno = statusAluno;
	}
	
	

}