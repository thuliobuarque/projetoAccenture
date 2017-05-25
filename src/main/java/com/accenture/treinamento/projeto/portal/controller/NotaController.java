package com.accenture.treinamento.projeto.portal.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.accenture.treinamento.projeto.exception.ProjetoException;
import com.accenture.treinamento.projeto.portal.model.NotaBean;
import com.accenture.treinamento.projeto.portal.negocio.NotaNegocio;

/**
*
* @author Thulio, thayse, thales, caio, priscila, veridiana
* @since 17/05/2017
*/

@ManagedBean(name = "MBNotas")
@ViewScoped
public class NotaController {
	
	private NotaNegocio notaNegocio;
	private NotaBean nota;
	
	public NotaController(){
		
		notaNegocio = new NotaNegocio();
		nota = new NotaBean();
		
	}
	public void cadastrarNota() throws ProjetoException {
			
		if (nota.getNota1() >= 0){
			if (nota.getNota2() >= 0) {
				nota.setMedia(((nota.getNota1()+nota.getNota2())/2));
				if (nota.getMedia() >= 7) {
					nota.setMediafinal(nota.getMedia()); 
					System.out.println("Aprovado");
				}else if ((nota.getMedia() < 7) && (nota.getMedia()>= 4)){
					nota.setMediafinal((nota.getMedia()+nota.getNota3())/2);
					System.out.println("Final");
				}else {
					nota.setMediafinal(nota.getMedia());
					System.out.println("Reprovado");
				}
			}
		}
		
		NotaNegocio ndao = new NotaNegocio();
		if (ndao.cadastrarNota(nota)) {	

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Aluno cadastrado com sucesso!", "Sucesso");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadNota.hide();");
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o cadastro!", "Erro");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			RequestContext.getCurrentInstance().execute("dlgCadNota.hide();");
		}
	
	}

	public void alterarNota() throws ProjetoException {

		NotaNegocio ndao = new NotaNegocio();
		ndao.alterarNota(nota);

	}

	public void excluirNota() throws ProjetoException {
		
		NotaNegocio ndao = new NotaNegocio();
		ndao.excluirNota(nota);	
	}
	   
	public void ListarNota() throws ProjetoException {
		
		NotaNegocio ndao = new NotaNegocio();
		ndao.getListaNota();
	}
	public NotaNegocio getNotaNegocio() {
		return notaNegocio;
	}
	public void setNotaNegocio(NotaNegocio notaNegocio) {
		this.notaNegocio = notaNegocio;
	}
	public NotaBean getNota() {
		return nota;
	}
	public void setNota(NotaBean nota) {
		this.nota = nota;
	}
	
}
