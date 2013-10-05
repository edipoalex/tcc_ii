package br.com.droid.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.droid.controle.fachada.Fachada;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.boletim.Boletim;
import br.com.droid.model.usuario.Usuario;

@Path("/boletim")
public class BoletimResource {

	static List<Boletim> boletimList;

	@GET
	@Path("/{key}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boletim> getBoletim(@PathParam("key") String key) {

		// List<Boletim> boletim = null;
		Usuario usuario = SessionControl.getInstance().get(key);

		if (usuario != null) {
			// boletim = Fachada.getInstance().getBoletim(usuario);
			boletimList = Fachada.getInstance().getBoletim(usuario);

			// if (boletim == null)
			if (boletimList == null)
				throw new NoContentException("Boletim não encontrado!");
		} else {
			throw new NoContentException("Usuario não encontrado!");
		}

		// return boletim;
		return boletimList;
	}

	@GET
	@Path("/{key}/{semestre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Boletim> getBoletimBySemestre(@PathParam("key") String key,
			@PathParam("semestre") int semestre) {
		// return (List<Boletim>) getBoletim(key).get(semestre);
		// return boletimList;
		for (int i = 0; i <= boletimList.size(); i++) {
			System.out.println(boletimList.get(i) + " - " + i);
			
		}
		return boletimList;
	}
}
