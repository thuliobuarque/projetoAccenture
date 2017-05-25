package com.accenture.treinamento.projeto.portal.negocio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.util.ClientRest;
import com.accenture.treinamento.projeto.util.SessionUtil;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

public class AlunoNegocio {

	// LISTAS
	private List<AlunoBean> listaAluno;

	// BUSCAS
	private String tipo;
	private Integer tipoBuscaAluno;
	private String campoBuscaAluno;
	private String statusAluno;

	public AlunoNegocio() {

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
	public boolean cadastrarAluno(AlunoBean aluno) throws ProjetoException,
			MalformedURLException {
		String numero = gerarNumero();
		aluno.setMatricula(Integer.parseInt(numero));

		AlunoDAO adao = new AlunoDAO();
		adao.cadastrarAluno(aluno);
		listaAluno = null;
		return true;

	}

	// METODO DE ALTERAR ALUNO
	public void alterarAluno(AlunoBean aluno) throws ProjetoException {

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
	public void excluirAluno(AlunoBean aluno) throws ProjetoException {
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

	public String gerarNumero() throws MalformedURLException {
		HttpURLConnection connection = null;
		String resp = "";
		try {
			URL url = new URL(ClientRest.URL_WS + "/gerenciarAluno");
			connection = (HttpURLConnection) url.openConnection();
			InputStream content = connection.getInputStream();
			resp = toString(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}
		return resp;
	}

	private String toString(InputStream is) throws IOException {
		byte[] bytes = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int lidos;
		while ((lidos = is.read(bytes)) > 0) {
			baos.write(bytes, 0, lidos);
		}
		return new String(baos.toByteArray());
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