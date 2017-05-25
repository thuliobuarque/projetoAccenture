package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;
import com.accenture.treinamento.projeto.portal.dao.TurmaDAO;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */


public class TurmaNegocio {

	private TurmaBean turma;

	// LISTAS
	private List<TurmaBean> listaTurma;

	public TurmaNegocio() {
		// INSTANCIAS
		turma = new TurmaBean();

		// LISTAS
		listaTurma = new ArrayList<>();
		listaTurma = null;

	}

	public void cadastrarTurma() throws ProjetoException {

		TurmaDAO Tdao = new TurmaDAO();
		boolean cadastrou = Tdao.cadastrarTurma(turma);

		if (cadastrou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma cadastrada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadTurma.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadTurma.hide();");
		}
	}

	// METODO DE ALTERAR TURMA
	public void alterarTurma() throws ProjetoException {

		TurmaDAO Tdao = new TurmaDAO();
		boolean alterou = Tdao.alterarTurma(turma);

		if (alterou == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma alterada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltTurma.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgAltTurma.hide();");
		}
	}

	// METODO DE EXCLUIR ALUNO
	public void excluirTurma() throws ProjetoException {
		TurmaDAO Tdao = new TurmaDAO();
		boolean excluir = Tdao.excluirTurma(turma);

		if (excluir == true) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Turma exclu�da com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			// listaLaudo = null;
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

	public void LimparObjeto() {
		turma = null;
	}

	public TurmaBean getTurma() {
		return turma;
	}

	public void setTurma(TurmaBean turma) {
		this.turma = turma;
	}

	public List<TurmaBean> getListaTurma() {
		if (listaTurma == null) {
			TurmaDAO tdao = new TurmaDAO();
			listaTurma = tdao.listaTurma();
		}
		return listaTurma;
	}

	public void setListaTurma(List<TurmaBean> listaTurma) {
		this.listaTurma = listaTurma;
	}

}
