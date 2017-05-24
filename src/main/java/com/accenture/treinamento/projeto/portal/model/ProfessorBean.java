package com.accenture.treinamento.projeto.portal.model;

public class ProfessorBean extends PessoaBean {
	
	private int id_professor;
	private String titulacao;
	
	public ProfessorBean(){
		
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

}
