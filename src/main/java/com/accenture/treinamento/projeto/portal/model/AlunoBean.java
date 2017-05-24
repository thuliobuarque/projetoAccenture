package com.accenture.treinamento.projeto.portal.model;


public class AlunoBean extends PessoaBean {

    private Integer id_aluno;
    private Integer periodo;  

    public AlunoBean() {
    	
    }

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
 
	public Integer getPeriodo() {
		return periodo;
	}
 
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	} 
	
}