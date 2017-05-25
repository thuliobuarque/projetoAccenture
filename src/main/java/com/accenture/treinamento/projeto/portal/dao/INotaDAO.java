package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.NotaBean;

public interface INotaDAO {
	public abstract boolean cadastrarNota (NotaBean notas) throws ProjetoException;
	public abstract boolean alterarNota(NotaBean notas) throws ProjetoException;
	public abstract boolean excluirNota(NotaBean notas) throws ProjetoException;
	public abstract List<NotaBean> listaNota() throws ProjetoException;
	public abstract List<NotaBean> buscarNota(String nome) throws ProjetoException;

}
