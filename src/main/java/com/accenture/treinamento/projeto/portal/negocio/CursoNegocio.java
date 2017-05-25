
package com.accenture.treinamento.projeto.portal.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.dao.CursoDAO;
import com.accenture.treinamento.projeto.portal.model.CursoBean;

/**
 * @author Thulio, Thayse, Thales, Caio, Priscila, Veridiana
 * @since 17/05/2017
 */

public class CursoNegocio {

	public boolean cadastrarCurso(CursoBean curso) throws ProjetoException {

		CursoDAO Cdao = new CursoDAO();
		boolean cadastrou = Cdao.cadastrarCurso(curso);
		return cadastrou;
	}
	
	public boolean alterarCurso(CursoBean curso) throws ProjetoException {

		CursoDAO Cdao = new CursoDAO();
		boolean alterou = Cdao.alterarCurso(curso);
		return alterou;
	}
	
	public boolean excluirCurso(CursoBean curso) throws ProjetoException {
		
		CursoDAO Cdao = new CursoDAO();
		boolean excluir = Cdao.excluirCurso(curso);
		return excluir;
	}
	
	public List<CursoBean> getListaCurso() throws ProjetoException {
		CursoDAO Cdao = new CursoDAO();
		return Cdao.listaCurso();
	}
	
	
	/*public List<CursoBean> buscarCurso(String campo, Integer tipo) throws ProjetoException {
		CursoDAO Cdao = new CursoDAO();
		return Cdao.(campo, tipo);
	}*/
	
}