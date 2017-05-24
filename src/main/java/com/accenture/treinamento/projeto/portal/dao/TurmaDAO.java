package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

		String sql = "insert into acl.turma (codigoturma) values (?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, turma.getCodigoTurma());
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
		String sql = "update acl.turma set codigoturma = ? where idturma = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, turma.getCodigoTurma());
			stmt.setInt(2, turma.getId());
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
		String sql = "delete from acl.alunos where idalunos = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, turma.getId());
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

		String sql = "select idturma, codigoturma from acl.turma order by codigoturma";

		ArrayList<TurmaBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				TurmaBean t = new TurmaBean();

				t.setId(rs.getInt("idturma"));
				t.setCodigoTurma(rs.getString("codigoturma"));
				// t.setAlunos(rs.getString("senha"));

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

}
