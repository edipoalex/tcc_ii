package br.com.droid.model.disciplina;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Disciplina {
	private int codigo;
	private String nome;
	
	
	public Disciplina() {
		super();
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
