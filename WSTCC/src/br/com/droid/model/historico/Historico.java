package br.com.droid.model.historico;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.droid.model.disciplina.Disciplina;

@XmlRootElement
public class Historico {
	private Integer login; 
	private Integer ano;
	private Integer semestre;
	private Double media;
	private Double faltas;
	private String situacao; 
	private Disciplina disciplina;
	
	
	public Historico() {
		super();
	}
	public Integer getLogin() {
		return login;
	}
	public void setLogin(Integer login) {
		this.login = login;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	public Double getFaltas() {
		return faltas;
	}
	public void setFaltas(Double faltas) {
		this.faltas = faltas;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
