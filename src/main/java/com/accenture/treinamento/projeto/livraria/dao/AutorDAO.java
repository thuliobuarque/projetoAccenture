package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.AutorBean;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;



public class AutorDAO implements IAutorDAO {

	private Connection conexao = null;
	
	public boolean cadastrarAutor(AutorBean autor) {
		
		String sql = "insert into mydb.autor (nome) values (?)";
		
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
		String sql = "update mydb.autor set nome ?, where codigo = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, autor.getNome());
			stmt.setInt(2, autor.getCodigo());
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
		String sql = "delete from acl.autor where codigo = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, autor.getCodigo());
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
	
	public ArrayList<AutorBean> listaAutor() {

		String sql = "select codigo, nome from acl.autor order by nome";

		ArrayList<AutorBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				AutorBean a = new AutorBean();

				a.setCodigo(rs.getInt("codigo"));
				a.setNome(rs.getString("nome"));

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
