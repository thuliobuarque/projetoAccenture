package com.accenture.treinamento.projeto.portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.CursoBean;

public class CursoDAO implements ICursoDAO {

	private Connection conexao = null;

	public boolean cadastrarCurso(CursoBean curso) throws ProjetoException {
     
		String sql = "insert into curso(codigo_curso, nome_curso) values (?, ?)";
		//curso.getDisciplina.SetId_disciplina (fk n funcionou id_disciplina apenas)
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.getcodigo_curso());
			stmt.setString(2, curso.getNome_curso());
		
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

	public boolean alterarCurso(CursoBean curso) throws ProjetoException {
		boolean alterou = false;
		String sql = "update curso set codigo_curso = '99988', nome_curso = 'historia' where id_curso = 4";
		
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.getcodigo_curso());
			stmt.setString(2, curso.getNome_curso());
		

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

	public boolean excluirCurso(CursoBean curso) throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from curso where id_curso = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, curso.getId_curso());
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

	public ArrayList<CursoBean> listaCurso() {

		String sql = "select id_curso, codigo_curso, nome_curso, id_disciplina from curso order by nome_curso";

		ArrayList<CursoBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				CursoBean c = new CursoBean();

				c.setId_curso(rs.getInt("id_curso"));
				c.setCodigo_curso(rs.getString("codigo_curso"));
				c.setNomeCurso(rs.getString("nomeCurso"));
				c.getDisciplina().setId_disciplina(rs.getInt("id_disciplina"));
				 
				lista.add(c);
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
