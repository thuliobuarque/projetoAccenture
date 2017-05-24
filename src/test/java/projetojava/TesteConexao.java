package projetojava;

import com.accenture.treinamento.projeto.livraria.dao.AutorDAO;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;

public class TesteConexao {

	public static void main(String[] args) {
	
		AutorBean autor = new AutorBean();
		autor.setNome("teste");
		AutorDAO autorDAO = new AutorDAO();
		autorDAO.cadastrarAutor(autor);

	}
	
	public void testCadastrarAutor() {

	}
}
