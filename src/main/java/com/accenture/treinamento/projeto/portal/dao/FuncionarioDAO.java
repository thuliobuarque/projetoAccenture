package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.FuncionarioBean;

public class FuncionarioDAO implements IFuncionarioDAO {

	private Connection conexao = null;

	public boolean cadastrarFuncionario(FuncionarioBean funcionario) throws ProjetoException {

		String sql = "insert into acl.alunos (nome, cpf) values (?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome().toUpperCase().trim());
			stmt.setString(2, funcionario.getCpf().replaceAll("[^0-9]", ""));
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

	public boolean alterarFuncionario(FuncionarioBean funcionario)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update acl.funcionarios set nome = ?, cpf = ? where id_funcionario = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setInt(3, funcionario.getId_funcionario());
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
	
	public boolean excluirFuncionario(FuncionarioBean funcionario)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from acl.funcionarios where id_funcionario = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId_funcionario());
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

	
	public ArrayList<FuncionarioBean> listaFuncionario() {

		String sql = "select id_funcionario, login, senha, nome, cpf from acl.funcionario order by nome";

		ArrayList<FuncionarioBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				FuncionarioBean a = new FuncionarioBean();

				a.setId_funcionario(rs.getInt("id_funcionario"));
				a.setLogin(rs.getString("login"));
				a.setSenha(rs.getString("senha"));
				a.setNome(rs.getString("nome"));
				a.setCpf(rs.getString("cpf"));


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
	
	 public List<FuncionarioBean> buscarTipoFuncionario(String valor, Integer tipo) throws ProjetoException {
	  		
	      	
   		 String sql = "select id_funcionario, nome, cpf from acl.funcionarios where";
   		
   		if (tipo == 1) {
   			sql += " funcionarios.nome like ? order by funcionarios.nome ";
   		}
   		if (tipo == 2) {
   			sql += " funcionarios.cpf like ? order by funcionarios.nome ";
   		}
   		List<FuncionarioBean> lista = new ArrayList<>();
   	
   		try {
   			conexao = ConnectionFactory.getConnection();
   			PreparedStatement stmt = conexao.prepareStatement(sql);
   			if (tipo == 1) {
   				stmt.setString(1, "%" + valor.toUpperCase() + "%");
   			}
   			if (tipo == 2) {
   				stmt.setString(1, "%" + valor.toUpperCase() + "%");
   			}

   			ResultSet rs = stmt.executeQuery();

   			while (rs.next()) {
   				FuncionarioBean c = new FuncionarioBean();

   				c.setId_funcionario(rs.getInt("id_funcionario"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));


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
