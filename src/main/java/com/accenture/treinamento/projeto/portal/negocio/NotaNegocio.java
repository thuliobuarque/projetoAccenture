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
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class NotaNegocio {
		
	public boolean cadastrarNota(NotaBean nota) throws ProjetoException {
		
		NotaDAO ndao = new NotaDAO();
		ndao.cadastrarNota(nota);
		return true;
	}
	
	public boolean alterarNota (NotaBean nota) throws ProjetoException{
		
		NotaDAO ndao = new NotaDAO();
		boolean alterou = ndao.alterarNota(nota);
		return alterou;
	}
	
	public boolean excluirNota(NotaBean nota) throws ProjetoException {
		
		NotaDAO ndao = new NotaDAO();
		boolean excluir = ndao.excluirNota(nota);
		return excluir;
	}
	
	public List<NotaBean> getListaNota() throws ProjetoException {
		NotaDAO ndao = new NotaDAO();
		return ndao.listaNota();
	}
	public List<NotaBean> buscarNota(String campo, Integer tipo) throws ProjetoException {
		NotaDAO ndao = new NotaDAO();
		return ndao.buscarNota(campo, tipo)
	}
	
	
}


