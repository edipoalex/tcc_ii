package br.com.droid.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.droid.controle.fachada.Fachada;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.historico.Historico;
import br.com.droid.model.usuario.Usuario;


@Path("/historico")
public class HistoricoResource {
	
	static List<Historico> historicoList;
	
	@GET
	@Path("/{key}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Historico> getHistorico(@PathParam("key") String key) {

		// List<Boletim> boletim = null;
		Usuario usuario = SessionControl.getInstance().get(key);

		if (usuario != null) {
			// boletim = Fachada.getInstance().getBoletim(usuario);
			historicoList = Fachada.getInstance().getHistorico(usuario);

			// if (boletim == null)
			if (historicoList == null)
				throw new NoContentException("Histórico não encontrado!");
		} else {
			throw new NoContentException("Usuario não encontrado!");
		}

		// return boletim;
		return historicoList;
	}

}
