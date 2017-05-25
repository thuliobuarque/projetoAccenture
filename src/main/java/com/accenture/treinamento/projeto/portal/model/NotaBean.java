package com.accenture.treinamento.projeto.portal.model;

public class NotaBean {
	private Integer id_nota;
	private double nota1;
    private double nota2;
    private double media;
    private double mediafinal;
    private DisciplinaBean disciplica;
    
    public NotaBean(){
    	
    }
    
	public Integer getId_nota() {
		return id_nota;
	}
	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public double getMediafinal() {
		return mediafinal;
	}
	public void setMediafinal(double mediafinal) {
		this.mediafinal = mediafinal;
	}
	public DisciplinaBean getDisciplica() {
		return disciplica;
	}
	public void setDisciplica(DisciplinaBean disciplica) {
		this.disciplica = disciplica;
	}        
}
