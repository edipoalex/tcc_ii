package br.com.droid.resources;



import java.util.Date;

import br.com.droid.model.usuario.Usuario;

public class Session {
	private Usuario usuario;
	private Date date;
	
	public Session(Usuario usuario, Date date) {
		super();
		this.usuario = usuario;
		this.date = date;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
