package com.accenture.treinamento.projeto.portal.model;

public class CursoBean {
	
	private int id_curso;
	private String codigo_curso;
	private String nome_curso;
	private DisciplinaBean disciplina;
	
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public String getcodigo_curso() {
		return codigo_curso;
	}
	public void setCodigo_curso(String codigo_curso) {
		this.codigo_curso= codigo_curso;
	}
	public String getNome_curso() {
		return nome_curso;
	}
	public void setNomeCurso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
	public DisciplinaBean getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}

}
