package com.accenture.treinamento.projeto.portal.model;

public class DisciplinaBean {
	
	private int id_disciplina;
	private String nome;
	private int carga_horaria;
	private ProfessorBean professor;
	private TurmaBean turma;
	
	public int getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(int id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public ProfessorBean getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorBean professor) {
		this.professor = professor;
	}
	public TurmaBean getTurma() {
		return turma;
	}
	public void setTurma(TurmaBean turma) {
		this.turma = turma;
	}
	
	
	
	
	
	
	
	

}
