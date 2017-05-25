package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;
import com.accenture.treinamento.projeto.livraria.model.LivroBean;




public class AutorDAO implements IAutorDAO {

	private Connection conexao = null;
	
	public boolean cadastrarAutor(AutorBean autor) {
		
		String sql = "insert into autor (nome) values (?)";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, autor.getNome());
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
	
	public boolean alterarAutor(AutorBean autor)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update autor set nome = ? where id_autor = ?";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, autor.getId_autor());
			stmt.setString(2, autor.getNome());
			
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
	
	public boolean excluirAutor(AutorBean autor)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from autor where id_autor = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, autor.getId_autor());
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
	
	public ArrayList<AutorBean> listaAutor() throws ProjetoException {
		System.out.println("entrou aqui 3");
		String sql = "select id_autor, nome from autor order by nome";

		ArrayList<AutorBean> lista = new ArrayList<>();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				AutorBean a = new AutorBean();

				a.setId_autor(rs.getInt("id_autor"));
				a.setNome(rs.getString("nome"));

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
	public List<AutorBean> searchAutor(String value, int tipo) throws ProjetoException {
		String sql = "select * from acl.autor join acl.livro on autor.id_autor = livro.id_autor where autor.nome like ? order by livro.titulo";

		List<AutorBean> list = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, "%" + value.toUpperCase().trim() + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AutorBean ab = new AutorBean();
				
				
				list.add(ab);					
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
