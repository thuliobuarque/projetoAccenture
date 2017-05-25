package com.accenture.treinamento.projeto.livraria.negocio;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.LivroDAO;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;

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
	

	public List<LivroBean> getListaObra() throws ProjetoException {
			LivroDAO adao = new LivroDAO();
			return adao.listaObra();
	}
	
	public List<LivroBean> buscarLivro(String campo, Integer tipo) throws ProjetoException{
		LivroDAO ldao = new LivroDAO();
		return ldao.searchLivro(campo, tipo);
	}
}
