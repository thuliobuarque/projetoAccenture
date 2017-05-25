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
import com.accenture.treinamento.projeto.portal.model.DisciplinaBean;
import com.accenture.treinamento.projeto.portal.model.ProfessorBean;
import com.accenture.treinamento.projeto.portal.model.TurmaBean;


public class DisciplinaDAO implements IDisciplinaDAO {

	private Connection conexao = null;

	public boolean cadastrarDisciplina(DisciplinaBean disciplina)
			throws ProjetoException {

		String sql = "insert into disciplina (nome, carga_horaria, id_professor, id_turma ) values (?, ?, ?, ?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setInt(2, disciplina.getCarga_horaria());
			stmt.setInt(3, disciplina.getProfessor().getId_professor());
			stmt.setInt(4, disciplina.getTurma().getId_turma());

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

	public boolean alterarDisciplina(DisciplinaBean disciplina)
			throws ProjetoException {
		boolean alterou = false;
		String sql = "update disciplina set nome = ?, carga_horaria = ?, id_professor = ?, id_turma = ? where id_disciplina = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setInt(2, disciplina.getCarga_horaria());
			stmt.setInt(3, disciplina.getProfessor().getId_professor());
			stmt.setInt(4, disciplina.getTurma().getId_turma());
            stmt.setInt(5, disciplina.getId_disciplina());
			
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

	public boolean excluirDisciplina(DisciplinaBean disciplina)
			throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from disciplina where id_disciplina = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, disciplina.getId_disciplina());
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
	
	

	public ArrayList<DisciplinaBean> listaDisciplina() {

		String sql = "select disciplina.id_disciplina, disciplina.nome, disciplina.carga_horaria, professor.nome, turma.codigo_turma from disciplina "
				+ "join professor on (id_professor.professor = id_professor.disciplina) "
				+ "join turma on (id_turma.turma = id_turma.disciplina) order by disciplina.nome";

		ArrayList<DisciplinaBean> lista = new ArrayList();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				DisciplinaBean d = new DisciplinaBean();
				
				d.setId_disciplina(rs.getInt("id_disciplina"));
				d.setNome(rs.getString("nome"));
				d.setCarga_horaria(rs.getInt("carga_horaria"));
				d.getProfessor().setNome(rs.getString("nome"));
				d.getTurma().setCodigoTurma(rs.getString("codigo_turma"));
                
				lista.add(d);
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
	
	public List<DisciplinaBean> buscarTurma(String codigo) throws ProjetoException {
  		
      	
  		 String sql = "select disciplina.id_disciplina, disciplina.nome, disciplina.carga_horaria, professor.nome, turma.codigo_turma from disciplina "
				+ "join professor on (id_professor.professor = id_professor.disciplina) "
				+ "join turma on (id_turma.turma = id_turma.disciplina) where";
  		
  		List<DisciplinaBean> lista = new ArrayList<>();
  	
  		try {
  			conexao = ConnectionFactory.getConnection();
  			PreparedStatement stmt = conexao.prepareStatement(sql);
  			
  			ResultSet rs = stmt.executeQuery();

  			while (rs.next()) {
  				
  				DisciplinaBean d = new DisciplinaBean();

  				d.setId_disciplina(rs.getInt("id_disciplina"));
				d.setNome(rs.getString("nome"));
				d.setCargaHoraria(rs.getInt("carga_horaria"));
				d.setProfessor((ProfessorBean) rs.getClob("id_professor"));
				d.setId_turma((TurmaBean) rs.getClob("id_turma"));
						


  				lista.add(d);

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


