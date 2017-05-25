package com.accenture.treinamento.projeto.livraria.model;

import java.sql.Date;
import java.util.ArrayList;

import com.accenture.treinamento.projeto.portal.model.AlunoBean;
import com.accenture.treinamento.projeto.portal.model.ProfessorBean;

public class LocacaoBean {
	
	private Integer id_locacao;
	private Date data_locacao;
	private Date data_devolucao;
	private AlunoBean aluno;
	private ProfessorBean professor;
	private LivroBean livro;
	private String status;
	
	public Integer getId_locacao() {
		return id_locacao;
	}
	public void setId_locacao(Integer id_locacao) {
		this.id_locacao = id_locacao;
	}
	public Date getData_locacao() {
		return data_locacao;
	}
	public void setData_locacao(Date data_locacao) {
		this.data_locacao = data_locacao;
	}
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public AlunoBean getAluno() {
		return aluno;
	}
	public void setAluno(AlunoBean aluno) {
		this.aluno = aluno;
	}
	public ProfessorBean getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}
	public LivroBean getLivro() {
		return livro;
	}
	public void setLivro(LivroBean livro) {
		this.livro = livro;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
	
	/*private Integer pessoa;
	private ArrayList<Integer> livros;
	
	public LocacaoBean(){
		livros = new ArrayList<>();
	}
	
	public ArrayList<Integer> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Integer> livros) {
		this.livros = livros;
	}*/

	