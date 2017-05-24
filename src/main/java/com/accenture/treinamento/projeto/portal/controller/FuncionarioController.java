package com.accenture.treinamento.projeto.portal.controller;

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
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioController {

	// OBJETOS E CLASSES
	private FuncionarioBean funcionario;

	// LISTAS
	private List<FuncionarioBean> listaFuncionario;
	
	// BUSCAS
	private String tipo;
	private Integer tipoBuscaFuncionario;
	private String campoBuscaFuncionario;
	private String statusFuncionario;

	public FuncionarioController() {
		// INSTANCIAS
		funcionario = new FuncionarioBean();

		// LISTAS
		listaFuncionario = new ArrayList<>();
		listaFuncionario = null;
		
		// BUSCA
		tipo = "";
		tipoBuscaFuncionario = 1;
		campoBuscaFuncionario = "";
		statusFuncionario = "P";

	}

	// METODO DE ADCIONAR FUNCIONARIO
	public void cadastrarAluno() throws ProjetoException {

		FuncionarioDAO adao = new FuncionarioDAO();
		boolean cadastrou = adao.cadastrarFuncionario(funcionario);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaFuncionario = null;
			RequestContext.getCurrentInstance().execute("dlgCadFuncionario.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadFuncionario.hide();");
		}
	}

	// METODO DE ALTERAR Funcionario
	public void alterarFuncionario() throws ProjetoException {

		FuncionarioDAO adao = new FuncionarioDAO();
		boolean alterou = adao.alterarFuncionario(funcionario);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaFuncionario = null;
			RequestContext.getCurrentInstance().execute("dlgAltFuncionario.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltFuncionario.hide();");
		}
	}

	// METODO DE EXCLUIR Funcionario
	public void excluirFuncionario() throws ProjetoException {
		FuncionarioDAO adao = new FuncionarioDAO();
		boolean excluio = adao.excluirFuncionario(funcionario);

		if (excluio == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaFuncionario = null;
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
	
	public void buscarFuncionarios() throws ProjetoException {

		List<FuncionarioBean> listaAux = null;
		listaFuncionario = new ArrayList<>();

		FuncionarioDAO adao = new FuncionarioDAO();

		listaAux = adao.buscarTipoFuncionario(campoBuscaFuncionario, tipoBuscaFuncionario);

		if (listaAux != null && listaAux.size() > 0) {
			// listaAss = null;
			listaFuncionario = listaAux;
		} else {
			// listaAss = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nenhum Aluno encontrada.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}
	
	 public void recoverDataFromSessionAluno() {
		 funcionario = (FuncionarioBean) FacesContext
	            .getCurrentInstance().getExternalContext().getSessionMap()
	            .get("obj_funcionario");
	        
	    }
	
	public void limparBuscaDados() {
		tipoBuscaFuncionario = 1;
		campoBuscaFuncionario = "";
		statusFuncionario = "P";
		listaFuncionario = null;
	}

	public void limparDados() {
		funcionario = new FuncionarioBean();

	}



	public FuncionarioBean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioBean funcionario) {
		this.funcionario = funcionario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTipoBuscaFuncionario() {
		return tipoBuscaFuncionario;
	}

	public void setTipoBuscaFuncionario(Integer tipoBuscaFuncionario) {
		this.tipoBuscaFuncionario = tipoBuscaFuncionario;
	}

	public String getCampoBuscaFuncionario() {
		return campoBuscaFuncionario;
	}

	public void setCampoBuscaFuncionario(String campoBuscaFuncionario) {
		this.campoBuscaFuncionario = campoBuscaFuncionario;
	}

	public String getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(String statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public List<FuncionarioBean> getListaFuncionario() {
		if (listaFuncionario == null) {
			FuncionarioDAO adao = new FuncionarioDAO();
			listaFuncionario = adao.listaFuncionario();
		}
		return listaFuncionario;
	}

	public void setListaFuncionario(List<FuncionarioBean> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	
	

}