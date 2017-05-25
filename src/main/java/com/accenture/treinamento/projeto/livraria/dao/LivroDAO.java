package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;

public class LivroDAO implements ILivroDAO {

	private Connection conexao = null;
	
	public boolean cadastrarObra(LivroBean obra) throws ProjetoException {
		
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
			throw new ProjetoException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception ex) {
				throw new ProjetoException(ex);
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
			throw new ProjetoException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				throw new ProjetoException(e2);
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
			throw new ProjetoException(ex);
		} finally {
			try {
				conexao.close();
			} catch (Exception e2) {
				throw new ProjetoException(e2);
			}
		}
	}
	
	public ArrayList<LivroBean> listaObra() throws ProjetoException {

		String sql = "select id , titulo, ano_publicacao, editora, classificacao, quantidade from acl.obra";

		ArrayList<LivroBean> lista = new ArrayList<>();
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
			
			throw new ProjetoException(ex);
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
	
	@Override
	public List<LivroBean> searchLivro(String value, Integer type) throws ProjetoException {
		String sql = "select * from acl.livro ";

		if (type == 1) {
			sql += "join acl.autor on livro.id_autor = autor.id_autor where autor.nome like ? order by livro.titulo ";
		} else if (type == 2) {
			sql += "where livro.ano_publicacao = ? order by livro.titulo ";
		}
		List<LivroBean> list = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			if (type == 1) {
				stmt.setString(1, "%" + value.toUpperCase().trim() + "%");
			}
			if (type == 2) {
				stmt.setInt(1, Integer.parseInt(value));
			}
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LivroBean lb = new LivroBean();
				lb.setId(rs.getInt("id_livro"));
				lb.setNome(rs.getString("titulo"));
				lb.setAnoPublicacao(rs.getDate("ano_publicacao"));
				lb.setEditora(rs.getString("editora"));
				lb.setResumo(rs.getString("resumo"));
				lb.setClassificacao(rs.getString("classificacao"));
				lb.setQuantidade(rs.getInt("quantidade"));
				
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
}
