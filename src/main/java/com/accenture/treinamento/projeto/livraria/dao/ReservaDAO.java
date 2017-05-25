package com.accenture.treinamento.projeto.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.factory.ConnectionFactory;
import com.accenture.treinamento.projeto.livraria.model.ReservaBean;

public class ReservaDAO implements IReservaDAO {

	private Connection conexao = null;

	@Override
	public boolean saveReserva(ReservaBean reserva) throws ProjetoException {
		String query = "INSERT INTO acl.reserva (data_retirada) values (?)";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1,new java.sql.Date(reserva.getDataRetirada().getTime()));
			ps.execute();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateReserva(ReservaBean reserva) throws ProjetoException {
		String query = "UPDATE acl.reserva set data_retirada = ? where id_reserva = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setDate(1,
					new java.sql.Date(reserva.getDataRetirada().getTime()));
			ps.setInt(2, reserva.getId());
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean removeReserva(ReservaBean reserva) throws ProjetoException {
		String query = "DELETE acl.reserva WHERE  id_reserva = ?";

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ps.setInt(1, reserva.getId());
			ps.executeUpdate();

			conexao.commit();
			return true;

		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<ReservaBean> listReservas() throws ProjetoException {

		String query = "SELECT * FROM acl.reserva";

		ArrayList<ReservaBean> lista = new ArrayList<>();

		try {
			conexao = ConnectionFactory.getConnection();
			PreparedStatement ps = conexao.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReservaBean reserva = new ReservaBean();

				reserva.setId(rs.getInt("id_reserva"));
				reserva.setDataRetirada(rs.getDate("data_retirada"));

				lista.add(reserva);
			}
		} catch (SQLException e) {
			throw new ProjetoException(e);
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<ReservaBean> searchReserva(String value, Integer type) throws ProjetoException {
		String sql = "select * from acl.reserva ";

		if (type == 1) {
			sql += "join acl.livro on reserva.id_livro = livro.id_livro where livro.nome like ? order by reserva.data_reserva ";
		} else if (type == 2) {
			sql += "where livro.ano_publicacao = ? order by livro.titulo ";
		}
		List<ReservaBean> list = new ArrayList<>();

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
				ReservaBean lb = new ReservaBean();
				lb.setId(rs.getInt("id_livro"));
				
				
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