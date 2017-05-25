package com.accenture.treinamento.projeto.livraria.negocio;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.LivroDAO;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;
import com.accenture.treinamento.projeto.portal.dao.AlunoDAO;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/


public class LivroNegocio {

	public boolean cadastrarObra(LivroBean obra) throws ProjetoException {

		LivroDAO adao = new LivroDAO();
		boolean cadastrou = adao.cadastrarObra(obra);
		return cadastrou;
	}

	public boolean alterarObra(LivroBean obra) throws ProjetoException {

		LivroDAO adao = new LivroDAO();
		boolean alterou = adao.alterarObra(obra);
		return alterou;

	}

	public boolean excluirObra(LivroBean obra) throws ProjetoException {
		LivroDAO adao = new LivroDAO();
		boolean excluiu = adao.excluirObra(obra);
		return excluiu;
	}
	
	public void buscarAlunos() throws ProjetoException {

		List<LivroBean> listaAux = null;
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

	public List<LivroBean> getListaObra(List<LivroBean> listaObra) throws ProjetoException {
		if (listaObra == null) {
			LivroDAO adao = new LivroDAO();
			listaObra = adao.listaObra();

		}
		return listaObra;
	}


}
