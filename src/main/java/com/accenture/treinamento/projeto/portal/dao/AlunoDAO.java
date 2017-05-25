package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.mysql.jdbc.Statement;

public class AlunoDAO implements IAlunoDAO {

	private Connection conexao = null;
	
	public boolean cadastrarAluno(AlunoBean aluno) throws ProjetoException {

		String sql = "insert into aluno (nome, cpf, matricula, email, celular, logradouro, data_nascimento, genero, cep, estado, cidade, bairro) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome().toUpperCase().trim());
			stmt.setString(2, aluno.getCpf().replaceAll("[^0-9]", ""));
			stmt.setString(3, "10");
			//aluno.getMatricula()
			stmt.setString(4, aluno.getEmail().toUpperCase().trim());
			if (aluno.getCelular() == null) {
				stmt.setNull(5, Types.CHAR);
			} else {
				stmt.setString(5, aluno.getCelular().toUpperCase().trim());
			}	
			stmt.setString(6, aluno.getTipoLogradouro().toUpperCase().trim());
			stmt.setDate(7, new Date(aluno.getDatanascimento().getTime()));
			stmt.setString(8, aluno.getGenero().toUpperCase().trim());
			stmt.setString(9, aluno.getCep().replaceAll("[^0-9]", ""));
			stmt.setString(10, aluno.getEstado().toUpperCase().trim());			
			stmt.setString(11, aluno.getCidade().toUpperCase().trim());
			stmt.setString(12, aluno.getBairro().toUpperCase().trim());
			
			stmt.execute();
			
			    ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
	            if(rs.next()) { 
	            	 aluno.setId_aluno(rs.getInt("LAST_INSERT_ID()"));
	            	 String sql2="insert into pessoa (id_pessoa, login, senha, perfil) values (?, ?, ?, ?)";
                     stmt = conexao.prepareStatement(sql2);
                     stmt.setInt(1, aluno.getId_aluno());  
                     stmt.setString(2, aluno.getLogin().toUpperCase().trim());
                     stmt.setString(3, aluno.getSenha().toUpperCase().trim());
                     stmt.setInt(4, 1);
                     stmt.execute();
	            }

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

	public boolean alterarAluno(AlunoBean aluno)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update aluno set nome = ?, cpf = ? where id_aluno = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setInt(2, aluno.getId_aluno());
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
	
	public boolean excluirAluno(AlunoBean aluno)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from aluno where id_aluno = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, aluno.getId_aluno());
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

	
	public ArrayList<AlunoBean> listaAluno() {

		String sql = "select id_aluno, nome, cpf from aluno order by nome";

		ArrayList<AlunoBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				AlunoBean a = new AlunoBean();

				a.setId_aluno(rs.getInt("id_aluno"));
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
	
	 public List<AlunoBean> buscarTipoAluno(String valor, Integer tipo) throws ProjetoException {
	  		
	      	
   		 String sql = "select id_aluno, nome, cpf from aluno where";
   		
   		if (tipo == 1) {
   			sql += " aluno.nome like ? order by aluno.nome ";
   		}
   		if (tipo == 2) {
   			sql += " aluno.cpf like ? order by aluno.nome ";
   		}
   		List<AlunoBean> lista = new ArrayList<>();
   	
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
   				AlunoBean c = new AlunoBean();

   				c.setId_aluno(rs.getInt("id_aluno"));
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
