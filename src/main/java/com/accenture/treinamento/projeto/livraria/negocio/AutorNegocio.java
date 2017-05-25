package com.accenture.treinamento.projeto.livraria.negocio;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.AutorDAO;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;


/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class AutorNegocio {

	public boolean cadastrarAutor(AutorBean autor) {

		AutorDAO adao = new AutorDAO();
		boolean cadastrou = adao.cadastrarAutor(autor);
		return cadastrou;
	
	}

	public boolean alterarAutor(AutorBean autor) throws ProjetoException {

		AutorDAO adao = new AutorDAO();
		boolean alterou = adao.alterarAutor(autor);
		return alterou;
		
	}

	public boolean excluirAutor(AutorBean autor) throws ProjetoException {
		
		AutorDAO adao = new AutorDAO();
		boolean excluiu = adao.excluirAutor(autor);
		return excluiu;
		
	}

	public List<AutorBean> getListaAutor() throws ProjetoException {
		System.out.println("entrou aqui 2");
			AutorDAO adao = new AutorDAO();
			return adao.listaAutor();
		
	}
	
	public List<AutorBean> buscarAutor(String campo, int tipo) throws ProjetoException{
		AutorDAO adao = new AutorDAO();
		return adao.searchAutor(campo, tipo);
	}

}
