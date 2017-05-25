package com.accenture.treinamento.projeto.livraria.negocio;

import java.util.List;
import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.ReservaDAO;
import com.accenture.treinamento.projeto.livraria.model.ReservaBean;
/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class ReservaNegocio {

	public void salvarReserva(ReservaBean reserva) throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();
		retiradadao.saveReserva(reserva);

	}

	public void editarReserva(ReservaBean reserva) throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();
		retiradadao.updateReserva(reserva);	
	}

	public void deletarReserva(ReservaBean reserva) throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();
		retiradadao.removeReserva(reserva);
	}

	public List<ReservaBean> getListaReservas() throws ProjetoException {
			ReservaDAO rdao = new ReservaDAO();
			return rdao.listReservas();
	}

}
