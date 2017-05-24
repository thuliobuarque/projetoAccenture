package com.accenture.treinamento.projeto.livraria.negocio;

import java.util.ArrayList;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.livraria.dao.ReservaDAO;
import com.accenture.treinamento.projeto.livraria.model.ReservaBean;
/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class ReservaNegocio {
	
	private ReservaBean Reserva;
	private ArrayList<ReservaBean> listaReservas;

	public ReservaNegocio() {
		
		Reserva = new ReservaBean();
		
		listaReservas = new ArrayList<>();
		listaReservas = null;
	}

	public void salvarReserva() throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();

		if (retiradadao.saveReserva(Reserva)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reserva adicionada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void editarReserva() throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();

		if (retiradadao.updateReserva(Reserva)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reserva editada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante a edicao!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void deletarReserva() throws ProjetoException {
		ReservaDAO retiradadao = new ReservaDAO();

		if (retiradadao.removeReserva(Reserva)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Reserva deletada com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o procedimento!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public ReservaBean getReserva() {
		return Reserva;
	}

	public void setReserva(ReservaBean reserva) {
		this.Reserva = reserva;
	}

	public ArrayList<ReservaBean> getListaReservas() throws ProjetoException {
		if (listaReservas == null) {
			ReservaDAO rdao = new ReservaDAO();
			listaReservas = rdao.listReservas();
		}
		return listaReservas;
	}

	public void setListaReservas(ArrayList<ReservaBean> listaReservas) {
		this.listaReservas = listaReservas;
	}

}
