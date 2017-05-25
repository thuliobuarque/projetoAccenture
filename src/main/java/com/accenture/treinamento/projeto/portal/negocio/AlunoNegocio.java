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
import com.accenture.treinamento.projeto.portal.dao.CursoDAO;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.CursoBean;
import com.accenture.treinamento.projeto.util.ClientRest;
import com.accenture.treinamento.projeto.util.SessionUtil;

/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 17/05/2017
 */

public class AlunoNegocio {

	public AlunoNegocio() {


	}

	public String loginTeste() throws ProjetoException {

		return "/pages/comum/principal.faces?faces-redirect=true";

	}

	public boolean cadastrarAluno(AlunoBean aluno) throws ProjetoException,
			MalformedURLException {
		String numero = gerarNumero();
		aluno.setMatricula(Integer.parseInt(numero));

		AlunoDAO adao = new AlunoDAO();
		adao.cadastrarAluno(aluno);
		listaAluno = null;
		return true;

	}

	public boolean alterarAluno(AlunoBean aluno) throws ProjetoException {

		AlunoDAO adao = new AlunoDAO();
		boolean alterou = adao.alterarAluno(aluno);
		return alterou;
	}

	public boolean excluirAluno(AlunoBean aluno) throws ProjetoException {
		AlunoDAO adao = new AlunoDAO();
		boolean excluir = adao.excluirAluno(aluno);
		return excluir;
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
	
	public List<AlunoBean> getListaAluno() throws ProjetoException {
		AlunoDAO Cdao = new AlunoDAO();
		return Cdao.listaAluno();
	}
	
	public List<AlunoBean> buscarAluno(String campo, Integer tipo) throws ProjetoException {
		AlunoDAO Cdao = new AlunoDAO();
		return Cdao.buscarTipoAluno(campo, tipo);
	}



}