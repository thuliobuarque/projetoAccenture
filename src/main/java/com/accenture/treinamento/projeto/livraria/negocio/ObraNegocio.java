package com.accenture.treinamento.projeto.livraria.negocio;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.ObraDAO;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/


public class ObraNegocio {

	private LivroBean obra;

	private List<LivroBean> listaObra;

	public ObraNegocio() {
		obra = new LivroBean();

		listaObra = new ArrayList<>();
		listaObra = null;
	}

	public void cadastrarObra() {

		ObraDAO adao = new ObraDAO();
		boolean cadastrou = adao.cadastrarObra(obra);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		}

	}

	public void alterarObra() throws ProjetoException {

		ObraDAO adao = new ObraDAO();
		boolean alterou = adao.alterarObra(obra);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		}
	}

	public void excluirObra() throws ProjetoException {
		ObraDAO adao = new ObraDAO();
		boolean excluiu = adao.excluirObra(obra);

		if (excluiu == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Obra excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public void limparObjeto() {
		obra = null;
	}

	public LivroBean getObra() {
		return obra;
	}

	public void setObra(LivroBean obra) {
		this.obra = obra;
	}

	public List<LivroBean> getListaObra() {
		if (listaObra == null) {
			ObraDAO adao = new ObraDAO();
			listaObra = adao.listaObra();

		}
		return listaObra;
	}

	public void setListaObra(List<LivroBean> listaObra) {
		this.listaObra = listaObra;
	}

}
