package com.accenture.treinamento.projeto.portal.dao;

import java.util.List;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.PessoaBean;

public interface IPessoaDAO {

	public abstract PessoaBean autenticarPessoa(PessoaBean pessoa) throws ProjetoException;



}
