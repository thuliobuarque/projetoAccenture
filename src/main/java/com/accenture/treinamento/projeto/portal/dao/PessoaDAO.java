package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public class PessoaDAO implements IPessoaDAO {

	private Connection conexao = null;

	public PessoaBean autenticarPessoa(PessoaBean pessoa)
			throws ProjetoException {

		this.conexao = ConnectionFactory.getConnection();

//		String sql = "select pessoa.login, pessoa.senha, aluno.nome, funcionario.nome, pessoa.perfil "
//				+ "from pessoa join aluno on pessoa.id_pessoa = aluno.id_pessoa "
//				+ "join professor on pessoa.id_pessoa = professor.id_pessoa "
//				+ "join funcionario on pessoa.id_pessoa = funcionario.id_pessoa "
//				+ "where pessoa.login = ? and pessoa.senha = ?";
		
		String sql = "select pessoa.login, pessoa.senha from pessoa where pessoa.login = ? and pessoa.senha = ?";

		PessoaBean ub = null;

		try {

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, pessoa.getLogin().toUpperCase().trim());
			pstmt.setString(2, pessoa.getSenha().toUpperCase().trim());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ub = new PessoaBean();
				ub.setLogin(rs.getString("login"));
				ub.setSenha(rs.getString("senha"));
				//ub.setNome(rs.getString("nome"));
			}

			return ub;
		} catch (SQLException ex) {
			throw new ProjetoException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}

	
}
