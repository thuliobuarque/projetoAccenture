package com.accenture.treinamento.projeto.portal.model;
/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

public class NotaBean {
	private Integer id_nota;
	private float nota1;
    private float nota2;
    private float media;
    private float nota3;
    private float mediafinal;
    private DisciplinaBean disciplica;
    
    public NotaBean(){
    	
    }
    
	public Integer getId_nota() {
		return id_nota;
	}
	public void setId_nota(Integer id_nota) {
		this.id_nota = id_nota;
	}
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	
	public float getNota3() {
		return nota3;
	}

	public void setNota3(float nota3) {
		this.nota3 = nota3;
	}

	public float getMedia() {
		return media;
	}
	public void setMedia(float media) {
		this.media = media;
	}
	public float getMediafinal() {
		return mediafinal;
	}
	public void setMediafinal(float mediafinal) {
		this.mediafinal = mediafinal;
	}
	public DisciplinaBean getDisciplica() {
		return disciplica;
	}
	public void setDisciplica(DisciplinaBean disciplica) {
		this.disciplica = disciplica;
	}        
}
