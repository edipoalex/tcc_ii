package br.com.droid.model.boletim;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.droid.model.disciplina.Disciplina;

//import br.com.droid.model.disciplina.Disciplina;

@XmlRootElement
public class Boletim {
	private Integer login; 
	private Integer ano;
	private Integer semestre;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Double nota4;
	private Integer faltas1;
	private Disciplina disciplina;
	
	
	public Boletim(){
		
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


	public Double getNota1() {
		return nota1;
	}


	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}


	public Double getNota2() {
		return nota2;
	}


	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}


	public Double getNota3() {
		return nota3;
	}


	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}


	public Double getNota4() {
		return nota4;
	}


	public void setNota4(Double nota4) {
		this.nota4 = nota4;
	}


	public Integer getFaltas1() {
		return faltas1;
	}


	public void setFaltas1(Integer faltas1) {
		this.faltas1 = faltas1;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	

}
