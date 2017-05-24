package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;

public class ObraDAO implements IObraDAO {

	private Connection conexao = null;
	
	public boolean cadastrarObra(LivroBean obra) {
		
		String sql = "insert into acl.obra (titulo,nome,anoPublicacao,editora,resumo,classificacao,quantidade) values (?,?,?,?,?,?,?)";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, obra.getTitulo());
			stmt.setString(2, obra.getNome());
			stmt.setDate(3, new java.sql.Date(obra.getAnoPublicacao().getTime()));
			stmt.setString(4, obra.getEditora());
			stmt.setString(5, obra.getResumo());
			stmt.setString(6, obra.getClassificacao());
			stmt.setInt(7, obra.getQuantidade());
			stmt.execute();
			
			conexao.commit();
			return true;
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
		
	}
	
	public boolean alterarObra(LivroBean obra)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.obra set nome ?, where codigo = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, obra.getNome());
			stmt.setDate(2, new java.sql.Date(obra.getAnoPublicacao().getTime()));
			stmt.setString(3, obra.getEditora());
			stmt.setString(4, obra.getResumo());
			stmt.setString(5, obra.getClassificacao());
			stmt.setInt(6, obra.getQuantidade());
			stmt.setInt(7, obra.getId());
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
	
	public boolean excluirObra(LivroBean obra)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.obra where codigo = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, obra.getId());
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
	
	public ArrayList<LivroBean> listaObra() {

		String sql = "select id , titulo, ano_publicacao, editora, classificacao, quantidade from acl.obra";

		ArrayList<LivroBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				LivroBean a = new LivroBean();

				a.setId(rs.getInt("id"));
				a.setTitulo(rs.getString("titulo"));
				a.setAnoPublicacao(rs.getDate("anoPublicacao"));
				a.setEditora(rs.getString("editora"));
				a.setClassificacao(rs.getString("classidicacao"));
				a.setQuantidade(rs.getInt("quantidade"));	

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
