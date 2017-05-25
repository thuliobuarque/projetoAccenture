package com.accenture.treinamento.projeto.livraria.dao;

import java.util.ArrayList;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.model.ReservaBean;

public interface IReservaDAO {
	
	public boolean saveReserva(ReservaBean reserva) throws ProjetoException;
	public boolean updateReserva(ReservaBean reserva) throws ProjetoException;
	public boolean removeReserva(ReservaBean reserva) throws ProjetoException;
	public ArrayList<ReservaBean> listReservas() throws ProjetoException;

}
