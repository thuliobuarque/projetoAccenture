package com.accenture.treinamento.projeto.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.LivroDAO;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;
import com.accenture.treinamento.projeto.livraria.negocio.LivroNegocio;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

@ManagedBean(name = "MBLivro")
@SessionScoped
public class LivroController {

	private LivroBean obra;

	private List<LivroBean> listaObra;

	private Integer tipoBuscaLivro;
	private String campoBuscaLivro;
	
	 private Integer abaAtiva = 0;

	public LivroController() {
		obra = new LivroBean();

		listaObra = new ArrayList<>();
		listaObra = null;
		
		tipoBuscaLivro = 1;
		campoBuscaLivro = "";
	}

	public void cadastrarObra() throws ProjetoException {
		listaObra = null;
		LivroDAO adao = new LivroDAO();
		boolean cadastrou = adao.cadastrarObra(obra);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Obra cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadObra.hide();");
		}

	}

	public void alterarObra() throws ProjetoException {
		listaObra = null;
		LivroDAO adao = new LivroDAO();
		boolean alterou = adao.alterarObra(obra);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Obra alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante o cadastro!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltObra.hide();");
		}
	}

	public void excluirObra() throws ProjetoException {
		listaObra = null;
		LivroDAO adao = new LivroDAO();
		boolean excluiu = adao.excluirObra(obra);

		if (excluiu == true) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Obra excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro durante a exclusao!",
					"Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
		}
	}

	public void buscarLivros() throws ProjetoException {

		LivroNegocio adao = new LivroNegocio();

		listaObra = adao.buscarLivro(campoBuscaLivro, tipoBuscaLivro);

		if (listaObra == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Nenhum livro encontrada.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public void limparObjeto() {
		obra = null;
	}
	
	public void limparBuscaDados() {
		tipoBuscaLivro = 1;
		campoBuscaLivro = "";
	}

	public LivroBean getObra() {
		return obra;
	}

	public void setObra(LivroBean obra) {
		this.obra = obra;
	}

	public List<LivroBean> ListaObra() throws ProjetoException {
		if (listaObra == null) {
			LivroNegocio ln = new LivroNegocio();
			listaObra = ln.getListaObra();

		}
		return listaObra;
	}

	public void setListaObra(List<LivroBean> listaObra) {
		this.listaObra = listaObra;
	}

	public Integer getTipoBuscaLivro() {
		return tipoBuscaLivro;
	}

	public void setTipoBuscaLivro(Integer tipoBuscaLivro) {
		this.tipoBuscaLivro = tipoBuscaLivro;
	}

	public String getCampoBuscaLivro() {
		return campoBuscaLivro;
	}

	public void setCampoBuscaLivro(String campoBuscaLivro) {
		this.campoBuscaLivro = campoBuscaLivro;
	}

	public Integer getAbaAtiva() {
		return abaAtiva;
	}

	public void setAbaAtiva(Integer abaAtiva) {
		this.abaAtiva = abaAtiva;
	}

	public List<LivroBean> getListaObra() {
		return listaObra;
	}

	
	
	

}
