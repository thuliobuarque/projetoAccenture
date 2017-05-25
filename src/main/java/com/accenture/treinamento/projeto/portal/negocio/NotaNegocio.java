package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.NotaDAO;
import com.accenture.treinamento.projeto.portal.model.NotaBean;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class NotaNegocio {

	private List<NotaBean> listaNota;
	private String campoBuscaNotaAluno;
	
	
	public NotaNegocio() {

		listaNota = new ArrayList<>();
		listaNota = null;
		campoBuscaNotaAluno = "";
	}
		
	public boolean cadastrarNota(NotaBean notas) throws ProjetoException {
		
		NotaDAO ndao = new NotaDAO();
		boolean cadastrou = ndao.cadastrarNota(notas);
		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Disciplina cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgCadNota.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro da disciplina!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute(
					"dlgCadNota.hide();");
		}
		return true;
	}
	
	
	public void alterarNota (NotaBean nota) throws ProjetoException{
		
		NotaDAO ndao = new NotaDAO();
		boolean alterou = ndao.alterarNota(nota);
	
		if (alterou == true) {
	
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno alterado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaNota = null;
			RequestContext.getCurrentInstance().execute("dlgAltNota.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
	
			RequestContext.getCurrentInstance().execute("dlgAltNota.hide();");
		}
	}
	
	
	public void excluirNota(NotaBean nota) throws ProjetoException {
		NotaDAO adao = new NotaDAO();
		boolean excluio = adao.excluirNota(nota);

		if (excluio == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno excluido com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			listaNota = null;
			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a exclusao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("PF('dialogAtencao').hide();");
		}
	}
	
	public void buscarNota() throws ProjetoException{
			
			List<NotaBean> listaAux = null;
			listaNota = new ArrayList<>();
			
			NotaDAO ndao = new NotaDAO();
			
			listaAux = ndao.buscarNota(campoBuscaNotaAluno);
			if (listaAux != null && listaAux.size() > 0) {
				listaNota = listaAux;
			} else {
				// listaAss = null;
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Nenhuma Turma encontrada.", "Aviso");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
	
	}
	public void listarNota() throws ProjetoException{
		
		List<NotaBean> listaAux = null;
		listaNota = new ArrayList<>();
		
		NotaDAO ndao = new NotaDAO();
		
		listaAux = ndao.listaNota();
		if (listaAux != null && listaAux.size() > 0) {
			listaNota = listaAux;
		} else {
			// listaAss = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nenhuma Turma encontrada.", "Aviso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
	}

	public List<NotaBean> getListaNota() {
		return listaNota;
	}

	public void setListaNota(List<NotaBean> listaNota) {
		this.listaNota = listaNota;
	}

	public String getCampoBuscaNotaAluno() {
		return campoBuscaNotaAluno;
	}

	public void setCampoBuscaNotaAluno(String campoBuscaNotaAluno) {
		this.campoBuscaNotaAluno = campoBuscaNotaAluno;
	}
	
}


