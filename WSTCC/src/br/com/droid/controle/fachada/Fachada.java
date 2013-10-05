package br.com.droid.controle.fachada;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.droid.controle.controlador.Controlador;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.boletim.Boletim;
import br.com.droid.model.usuario.Usuario;

public class Fachada {

	private static Fachada fachada;
	
	private Controlador controlador;
	
	public Fachada() {
		this.controlador = Controlador.getInstance();	
		String arqLog = null;//PropertiesUtil.obterValorProperty("config/config_sistema.properties", "CONFIG_LOG_GERAL");
	/*	if (arqLog != null) {
			try {
				FileOutputStream arq = new FileOutputStream(arqLog, true);
				PrintStream printStreamSaida = new PrintStream(arq);
				System.setOut(printStreamSaida);
				System.setErr(printStreamSaida);
				System.out.println("***************INICIO FACHADA***************");
				System.out.println();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}*/
	}
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}	
	
	
	
	public Usuario getVerifiaLogin(Integer login,Long senha) {
		return this.controlador.getVerifiaLogin(login,senha);
	}
	
	public List<Usuario> getListaUsuarios() {
		return this.controlador.getListaUsuarios();
	}
	
//	public void cadastrarUsuario(Usuario usuario) {
//		this.controlador.cadastrarUsuario(usuario);
//	}

	public List<Boletim> getBoletim(Usuario usuario) {
		return this.controlador.getBoletim(usuario);
	}
	
	
	
	
}

