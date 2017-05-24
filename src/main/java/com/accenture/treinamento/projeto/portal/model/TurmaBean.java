package com.accenture.treinamento.projeto.portal.model;

public class TurmaBean {
	
	private int id;
	private String codigoTurma;
	private AlunoBean alunos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}
	public AlunoBean getAlunos() {
		return alunos;
	}
	public void setAlunos(AlunoBean alunos) {
		this.alunos = alunos;
	}
	
	

}
