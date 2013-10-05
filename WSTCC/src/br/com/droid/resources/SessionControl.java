package br.com.droid.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import br.com.droid.model.usuario.Usuario;
import br.com.droid.util.CryptographyMD5;

public class SessionControl {
	//private Map<String, Usuario> usuarioMap;
	private List<Session> usuarioSession;
	private static SessionControl sessionControl;
	
	private SessionControl(){
		usuarioSession = new ArrayList<Session>();
	}
	
	public static SessionControl getInstance(){
		if (sessionControl == null){
			sessionControl = new SessionControl();
 
		}
		return sessionControl;
	}

	public void create(Usuario usuario){
		String key = CryptographyMD5.encrypt(usuario.getLogin().toString() + usuario.getSenha().toString());
		//usuarioMap.put(key, usuario);
		usuario.setKey(key);
		usuarioSession.add(new Session(usuario, new Date()));
	}
	public Usuario get(String id){
		Usuario u = null;
		for (Session s : usuarioSession) {
			if(s.getUsuario().getKey().equals(id)){
				u = s.getUsuario();
			}
		}
		return u;
	}
	
}
