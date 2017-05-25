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
	
	public boolean cadastrarObra(LivroBean livro) throws ProjetoException {
		
		String sql = "insert into livro (titulo,ano_publicacao,editora,resumo,classificacao,quantidade) values (?,?,?,?,?,?)";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAno_publicacao());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getResumo());		
			stmt.setString(5, livro.getClassificacao());
			stmt.setInt(6, livro.getQuantidade());
			stmt.setInt(7, livro.getAutor().getId_autor());
			
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
	
	public boolean alterarObra(LivroBean livro)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update livro set titulo = ?, ano_publicacao = ?, editora = ?,resumo = ?,classificacao = ?, quantidade = ? where id_livro = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAno_publicacao());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getResumo());		
			stmt.setString(5, livro.getClassificacao());
			stmt.setInt(6, livro.getQuantidade());
			stmt.setInt(7, livro.getAutor().getId_autor());
			
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
	
	public boolean excluirObra(LivroBean livro)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from livro where id_livro = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, livro.getId_livro());
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

		String sql = "select livro.id_livro, livro.titulo, livro.ano_publicacao, livro.editora, livro.resumo, livro.classificacao, livro.quantidade, autor.id_autor from livro";
			   sql += "INNER JOIN autor ON livro.id_autor = autor.id_autor";


		ArrayList<LivroBean> lista = new ArrayList<>();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				LivroBean a = new LivroBean();

				a.setId_livro(rs.getInt("id_livro"));
				a.setTitulo(rs.getString("titulo"));
				a.setAno_publicacao(rs.getString("ano_publicacao"));
				a.setEditora(rs.getString("editora"));
				a.setResumo(rs.getString("resumo"));
				a.setClassificacao(rs.getString("classificacao"));
				a.setQuantidade(rs.getInt("quantidade"));	
				a.getAutor().setId_autor(rs.getInt("id_autor"));
							
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
			
		String sql = "select livro.id_livro, livro.titulo, livro.ano_publicacao, livro.editora, livro.resumo, livro.classificacao, livro.quantidade, autor.id_autor from livro";
		  

		if (type == 1) {
			sql += " inner join autor on livro.id_autor = autor.id_autor where autor.nome like ? order by livro.titulo ";
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
				

				lb.setId_livro(rs.getInt("id_livro"));
				lb.setTitulo(rs.getString("titulo"));
				lb.setAno_publicacao(rs.getString("ano_publicacao"));
				lb.setEditora(rs.getString("editora"));
				lb.setResumo(rs.getString("resumo"));
				lb.setClassificacao(rs.getString("classificacao"));
				lb.setQuantidade(rs.getInt("quantidade"));	
				lb.getAutor().setId_autor(rs.getInt("id_autor"));
							
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
