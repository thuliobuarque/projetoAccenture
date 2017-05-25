package com.accenture.treinamento.projeto.portal.dao;
/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.portal.model.NotaBean;

import java.sql.PreparedStatement;

public class NotaDAO implements INotaDAO{
	
	private Connection conexao = null;

	@Override
	public boolean cadastrarNota(NotaBean notas) throws ProjetoException {
		String sql = "insert into nota (nota1, nota2, media, nota3, mediafinal) values (?, ?, ?, ?, ?)";
		try{
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setFloat(1, notas.getNota1());
			stmt.setFloat(2, notas.getNota2());
			stmt.setFloat(3, notas.getMedia());
			stmt.setFloat(4, notas.getNota3());
			stmt.setFloat(5, notas.getMediafinal());
			stmt.execute();
			conexao.commit();
			return true;
		}catch (SQLException ex){
			throw new RuntimeException();
		}finally {
				try {
					conexao.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					System.exit(1);
				}
		}
	}

	@Override
	public boolean alterarNota(NotaBean notas) throws ProjetoException {
		boolean alterou = false;
		String sql = "update nota set nota1 = ?, nota2 = ?, media = ?, mediafinal = ? where id_nota = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setFloat(1, notas.getNota1());
			stmt.setFloat(2, notas.getNota2());
			stmt.setFloat(3, notas.getMedia());
			stmt.setFloat(4, notas.getMediafinal());
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

	@Override
	public boolean excluirNota(NotaBean notas) throws ProjetoException {
		boolean excluir = false;
		String sql = "delete from nota where id_nota = ?";
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, notas.getId_nota());
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

	@Override
	public List<NotaBean> listaNota() throws ProjetoException {
		String sql = "select nota.nota1, nota.nota2, nota.media, nota.mediafinal from nota" 
				+ "inner join professor on (professor.id_professor = nota.id_professor) "
				+ "inner join aluno on (professor.id_aluno = nota.id_aluno) ";

		ArrayList<NotaBean> lista = new ArrayList<NotaBean>();
		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			NotaBean n = new NotaBean();

			n.setNota1(rs.getFloat("nota1"));
			n.setNota2(rs.getFloat("nota2"));
			n.setMedia(rs.getFloat("media"));
			n.setMediafinal(rs.getFloat("mediafinal"));
			
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

	@Override
	public List<NotaBean> buscarNota(String nome) throws ProjetoException {
		String sql = "select nota.id_nota, nota.nota1, nota.nota2, nota.media, nota.mediafinal from nota"
				+ "inner join professor on (professor.id_professor = nota.id_professor) "
				+ "inner join aluno on (aluno.id_aluno = nota.id_aluno)";

		List<NotaBean> lista = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);	
			ResultSet rs = stmt.executeQuery();
			NotaBean n = new NotaBean();

			n.setNota1(rs.getFloat("nota1"));
			n.setNota2(rs.getFloat("nota2"));
			n.setMedia(rs.getFloat("media"));
			n.setMediafinal(rs.getFloat("mediafinal"));
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
