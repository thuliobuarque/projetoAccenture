package com.accenture.treinamento.projeto.portal.model;

public class CursoBean {
	
	private int id;
	private String codigoCurso;
	private String nomeCurso;
	private DisciplinaBean disciplina;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public DisciplinaBean getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}

}
