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
import com.accenture.treinamento.projeto.portal.negocio.AlunoNegocio;
import com.accenture.treinamento.projeto.portal.negocio.FuncionarioNegocio;

/**
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioController {

	private FuncionarioBean funcionario;
	private List<FuncionarioBean> listaFuncionario;
	private String tipo;
	
	private Integer tipoBuscaFuncionario;
	private String campoBuscaFuncionario;
	private String statusFuncionario;
	
	private Integer abaAtiva = 0;

	public FuncionarioController() {

		funcionario = new FuncionarioBean();

		listaFuncionario = new ArrayList<>();
		listaFuncionario = null;
		
		tipo = "";
		tipoBuscaFuncionario = 1;
		campoBuscaFuncionario = "";
		statusFuncionario = "P";
	}

	public void cadastrarFuncionario() throws ProjetoException {

		FuncionarioNegocio adao = new FuncionarioNegocio();
		
		if (adao.cadastrarFuncionario(funcionario)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
	
			RequestContext.getCurrentInstance().execute("dlgCadFuncionario.hide();");
			listaFuncionario = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadFuncionario.hide();");
		}
	}

	public void alterarFuncionario() throws ProjetoException {

		FuncionarioNegocio adao = new FuncionarioNegocio();

		if (adao.alterarFuncionario(funcionario)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltFuncionario.hide();");
			listaFuncionario = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltFuncionario.hide();");
		}
	}

	public void excluirFuncionario() throws ProjetoException {
		
		FuncionarioNegocio adao = new FuncionarioNegocio();

		if (adao.excluirFuncionario(funcionario)) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Funcionario excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
	
			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
			listaFuncionario = null;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"PF('dialogAtencao').hide();");
		}
	}
		
    public void buscarFuncionario() throws ProjetoException {

		FuncionarioNegocio adao = new FuncionarioNegocio();

		listaFuncionario = adao.buscarFuncionario(campoBuscaFuncionario, tipoBuscaFuncionario);

		if (listaFuncionario == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhum funcionário encontrado.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
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
			FuncionarioNegocio adao = new FuncionarioNegocio();
			listaFuncionario = adao.listaFuncionario();
		}
		return listaFuncionario;
	}

	public void setListaFuncionario(List<FuncionarioBean> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public Integer getAbaAtiva() {
		return abaAtiva;
	}

	public void setAbaAtiva(Integer abaAtiva) {
		this.abaAtiva = abaAtiva;
	}

	
	

}