package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.ProfessorBean;

public class ProfessorDAO implements IProfessorDAO{

	private Connection conexao = null;
	
	@Override
	public boolean cadastrarProfessor(ProfessorBean professor) throws ProjetoException {
		String sql = "insert into acl.professores (titulacao) values (?)";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, professor.getTitulacao());
			stmt.execute();

			conexao.commit();

			return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				ex.printStackTrace(); //printa o erro
				System.exit(1);
			}
		}
	}

	@Override
	public boolean alterarProfessor(ProfessorBean professor) throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.professores set titulacao (?) where id_professor = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, professor.getTitulacao());
			stmt.setInt(2, professor.getId_professor());
			stmt.executeUpdate();
			conexao.commit();
			
			alterou = true;
			return alterou;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

	@Override
	public boolean excluirProfessor(ProfessorBean professor) throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.professores where id_professor = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, professor.getId_professor());
			stmt.executeUpdate();

			conexao.commit();

			excluir = true;

			return excluir;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<ProfessorBean> listaProfessor() throws ProjetoException { 
		String sql = "select id_professor, titulacao from acl.professores order by titulacao";

		ArrayList<ProfessorBean> lista = new ArrayList<>();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				ProfessorBean a = new ProfessorBean();

				a.setId_professor(rs.getInt("id_professor"));
				a.setTitulacao(rs.getString("titulacao"));

				lista.add(a);
			}
			
		} catch (SQLException ex) {
			
			throw new RuntimeException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		return lista;		
	}
	
}
