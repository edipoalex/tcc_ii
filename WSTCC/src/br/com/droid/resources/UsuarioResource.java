package br.com.droid.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.droid.controle.fachada.Fachada;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.usuario.Usuario;

@Path("/usuario")
public class UsuarioResource {

	@GET
	@Path("/buscarTodosGSON")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Usuario> buscarTodosGSON() {
		List<Usuario> lista = Fachada.getInstance().getListaUsuarios();
		if (lista == null)
			throw new NoContentException("Lista de usuários não encontrada!");

		return lista;

	}

	@GET
	@Path("/{login}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("login") Integer login,
			@PathParam("senha") Long senha) {
		Usuario usuario = Fachada.getInstance().getVerifiaLogin(login, senha);

		if (usuario == null)
			throw new NoContentException("Usuario não encontrado!");

		SessionControl.getInstance().create(usuario);

		return usuario;
	}
}
