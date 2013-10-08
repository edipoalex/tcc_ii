package br.com.droid.controle.controlador;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.droid.exception.NoContentException;
import br.com.droid.model.boletim.Boletim;
import br.com.droid.model.historico.Historico;
//import br.com.droid.model.historico.Historico;
import br.com.droid.model.usuario.Usuario;
import br.com.droid.persistencia.entidadeDAO.boletim.BoletimDAO;
import br.com.droid.persistencia.entidadeDAO.disciplina.DisciplinaDAO;
import br.com.droid.persistencia.entidadeDAO.historico.HistoricoDAO;
//import br.com.droid.persistencia.entidadeDAO.historico.HistoricoDAO;
import br.com.droid.persistencia.entidadeDAO.usuario.UsuarioDAO;
import br.com.droid.persistencia.hibernate.GenericHibernateDAO;
import br.com.droid.persistencia.hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Controlador {

	private static Controlador controlador = null;

	protected Session criarSessao() {
		return HibernateUtil.getInstance().obterSession();
	}

	protected Transaction iniciarTransacao(Session session) {
		Transaction transacao = session.beginTransaction();
		return transacao;
	}

	protected void fecharSessao(Session session) {
		if (session != null) {
			session.flush();
			session.close();
		}
	}

	private UsuarioDAO usuarioDAO;
	private BoletimDAO boletimDAO;
	private DisciplinaDAO disciplinaDAO;
	private HistoricoDAO historicoDAO;

	public static Controlador getInstance() {
		if (controlador == null) {
			controlador = new Controlador();
		}
		return controlador;
	}

	private Controlador() {
		usuarioDAO = new UsuarioDAO();
		boletimDAO = new BoletimDAO();
		disciplinaDAO = new DisciplinaDAO();
		historicoDAO = new HistoricoDAO();
	}

	public Usuario getVerifiaLogin(Integer login, Long senha) {
		Session session = null;
		Usuario u = null;
		try {
			session = criarSessao();
			usuarioDAO.setSession(session);
			u = usuarioDAO.getVerifiaLogin(login, senha);
		} finally {
			fecharSessao(session);
		}
		return u;
	}

	public List<Usuario> getListaUsuarios() {
		Session session = null;
		List<Usuario> usuarios = null;
		try {
			session = criarSessao();
			usuarioDAO.setSession(session);
			usuarios = usuarioDAO.listarTodos();
			//usuarios = usuarioDAO.getListaUsuarios();
		} finally {
			fecharSessao(session);
		}
		return usuarios;
	}

	public List<Boletim> getBoletim(Usuario usuario) {
		Session session = null;
		List<Boletim> b = null;
		try {
			session = criarSessao();
			boletimDAO.setSession(session);
			b = boletimDAO.getBoletim(usuario);
		} finally {
			fecharSessao(session);
		}
		return b;
	}
	
	public List<Historico> getHistorico(Usuario usuario) {
		Session session = null;
		List<Historico> b = null;
		try {
			session = criarSessao();
			historicoDAO.setSession(session);
			b = historicoDAO.getHistorico(usuario);
		} finally {
			fecharSessao(session);
		}
		return b;
	}


}
