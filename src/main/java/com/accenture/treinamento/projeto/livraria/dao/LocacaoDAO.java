package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.LocacaoBean;
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;

public class LocacaoDAO implements ILocacaoDAO {

	private Connection conexao = null;

	@Override
	public boolean saveLocacao(LocacaoBean locacao) throws ProjetoException {
		
		String query = "INSERT INTO locacao (data_locacao, data_devolucao, status) values (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ? )";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, new Date(locacao.getData_locacao().getTime()));
			ps.setDate(2,new Date(locacao.getData_devolucao().getTime()));
			ps.setString(3, locacao.getStatus()); //Char pegou como float
					
			ps.execute();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateLocacao(LocacaoBean locacao) throws ProjetoException {
		
		String query = "UPDATE locacao set data_locacao = current_timestamp(), data_devolucao = ?, status = ? WHERE id_locacao = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, new Date(locacao.getData_locacao().getTime()));
			ps.setDate(2, new Date(locacao.getData_devolucao().getTime()));
			ps.setString(3, locacao.getStatus()); //Char pegou como float
			
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean removeLocacao(LocacaoBean locacao) throws ProjetoException {
		// NECESS�RIO A OBRA IMPLEMENTADA
		// LOCALIZA AS OBRAS DA LOCACAO NO BANCO E ADICIONA A QUANTIDADE
		// RETIRADA PARA A LOCACAO
		// DELETA A LOCACAO DO BANCO
		String query = "DELETE FROM locacao WHERE id_locacao = ?";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1, new Date(locacao.getData_locacao().getTime()));
			ps.setDate(2, new Date(locacao.getData_devolucao().getTime()));
			ps.setString(3, locacao.getStatus());
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<LocacaoBean> listLocacoes() throws ProjetoException {
		ArrayList<LocacaoBean> locacoes = new ArrayList<>();

		String query = "SELECT * FROM locacao";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LocacaoBean locacao = new LocacaoBean();

				locacao.setId_locacao(rs.getInt("id_locacao"));
				locacao.setData_locacao(rs.getDate("data_locacao"));
				locacao.setData_devolucao(rs.getDate("data_devolucao"));
				locacao.getAluno().setId_aluno(rs.getInt("id_aluno"));
				locacao.getProfessor().setId_professor(rs.getInt("id_professor"));
				locacao.getLivro().setId(rs.getInt("id_livro"));
				locacao.setStatus(rs.getString("status"));
				
				locacoes.add(locacao);
			}
		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return locacoes;
	}

	
	/*
	@Override
	public List<LocacaoBean> searchLocacao(String value, Integer type) throws ProjetoException {
		
		String sql = "select * from acl.locacao ";

		if (type == 1) {
			sql += "join acl.pessoa on locacao.id_pessoa = pessoa.id_pessoa where aluno.nome like ? order by locacao.data_locacao ";
		} else if (type == 2) {
			sql += "join acl.livro on locacao.id_livro = livro.id_livro where livro.nome like ? order by locacao.data_locacao ";
		}
		List<LocacaoBean> list = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			if (type == 1) {
				stmt.setString(1, "%" + value.toUpperCase().trim() + "%");
			}
			if (type == 2) {
				stmt.setString(1, "%" + value.toUpperCase().trim() + "%");
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LocacaoBean lb = new LocacaoBean();
				ArrayList<Integer> auxLivros = new ArrayList<>();
				lb.setId(rs.getInt("idalunos"));
				lb.setPessoa(rs.getInt("id_pessoa"));
				lb.setDataLocacao(rs.getDate("data_locacao"));
				lb.setDataEntrega(rs.getDate("data_devolucao"));
				PreparedStatement stmt2 = conexao.prepareStatement("SELECT id_livro FROM acl.locacao WHERE id_locacao = ?");
				stmt2.setInt(1, rs.getInt("id_locacao"));
				stmt2.setDate(2, new Date(locacao.getData_locacao().getTime()));
				ResultSet rs2 = stmt2.executeQuery();
				while(rs2.next()){
					auxLivros.add(rs2.getInt("id_livro"));
				}
				lb.setLivros(auxLivros);
				list.add(lb);					
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// throw new RuntimeException(ex); //
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
		return list;
	}
}*/
	
	@Override
	public List<LocacaoBean> searchLocacao(String value, Integer type) throws ProjetoException {
		
			String sql = "select l.data_locacao, l.data_devolucao, aluno.id_aluno, professor.id_professor, livro.id_livro, status from   locacao as l"
			+ "inner join  Aluno On (l.id_aluno = aluno.id_aluno)"
			+ "inner join  Professor On( l.id_professor = professor.id_professor)"
			+ "inner join  livro On (l.id_livro = livro.id_livro)";
					
					
		if (type == 1) {
			sql += " locacao.data_locacao like ? order by locacao.data_locacao ";
		}

		List<LocacaoBean> lista = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			if (type == 1) {
				stmt.setString(1, "%" + value.toUpperCase() + "%");
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LocacaoBean c = new LocacaoBean();

				
				c.setId_locacao(rs.getInt("id_locacao"));
				c.setData_locacao(rs.getDate("data_locacao"));
				c.setData_devolucao(rs.getDate("data_devolucao"));
				c.getAluno().setId_aluno(rs.getInt("id_aluno"));
				c.getProfessor().setId_professor(rs.getInt("id_professor"));
				c.getLivro().setId(rs.getInt("id_livro"));
				c.setStatus(rs.getString("id_livro"));
				lista.add(c);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// throw new RuntimeException(ex); //
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
