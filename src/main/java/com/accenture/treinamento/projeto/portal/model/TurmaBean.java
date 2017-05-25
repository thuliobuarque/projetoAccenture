package com.accenture.treinamento.projeto.portal.model;

public class TurmaBean {
	
	private int id_turma;
	private String codigo_turma;
	private AlunoBean alunos;
	
	public int getId_turma() {
		return id_turma;
	}
	public void setId_turma(int id_turma) {
		this.id_turma = id_turma;
	}
	
	public String getCodigo_turma() {
		return codigo_turma;
	}
	public void setCodigo_turma(String codigo_turma) {
		this.codigo_turma = codigo_turma;
	}
	public AlunoBean getAlunos() {
		return alunos;
	}
	public void setAlunos(AlunoBean alunos) {
		this.alunos = alunos;
	}
	
	

}
