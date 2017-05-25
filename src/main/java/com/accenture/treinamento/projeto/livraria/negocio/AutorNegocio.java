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

	public List<AutorBean> getListaAutor(List<AutorBean> list) {
		if(list == null){
			AutorDAO adao = new AutorDAO();
			list = adao.listaAutor();
		}
			return list;
	}

}
