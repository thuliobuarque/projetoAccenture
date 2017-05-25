package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;


/**
 *
 * @author Thulio, thayse, thales, caio, priscila, veridiana
 * @since 21/05/2017
 */

public class TurmaDAO implements ITurmaDAO {

	private Connection conexao = null;

	public boolean cadastrarTurma(TurmaBean turma) throws ProjetoException {

		String sql = "insert into turma (codigo_turma, id_aluno) values (?,?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, turma.getCodigo_turma());
			stmt.setInt(2, turma.getAlunos().getId_aluno());
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

	public boolean alterarTurma(TurmaBean turma) throws ProjetoException {
		boolean alterou = false;
		String sql = "update turma set codigo_turma = ? where id_turma = ?";
	
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, turma.getCodigo_turma());
			stmt.setInt(2, turma.getAlunos().getId_aluno());
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

	public boolean excluirTurma(TurmaBean turma) throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from turma where id_turma = ?";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, turma.getId_turma());
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

	public ArrayList<TurmaBean> listaTurma() {

		String sql = "select id_turma, codigo_turma, id_aluno from turma order by codigo_turma";

		ArrayList<TurmaBean> lista = new ArrayList<>();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				TurmaBean t = new TurmaBean();

				t.setId_turma(rs.getInt("id_turma"));
				t.setCodigo_turma(rs.getString("codigo_turma"));
			    t.getAlunos().setId_aluno(rs.getInt("id_aluno"));
			    
			  
				lista.add(t);
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

	public List<TurmaBean> buscarTurma(String valor, Integer tipo)
			throws ProjetoException {
		
		String sql = "select id_turma, codigo_turma, id_aluno from turma order by codigo_turma";

		if (tipo == 1) {
			sql += " turma.codigo_turma like ? order by turma.codigo_turma ";
		}

		List<TurmaBean> lista = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			if (tipo == 1) {
				stmt.setString(1, "%" + valor.toUpperCase() + "%");
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				TurmaBean c = new TurmaBean();

				c.setId_turma(rs.getInt("id_turma"));
				c.setCodigo_turma(rs.getString("codigo_turma"));
				c.getAlunos().setId_aluno(rs.getInt("id_aluno"));
				
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
