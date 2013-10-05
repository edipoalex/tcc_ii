package br.com.droid.persistencia.entidadeDAO.usuario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.droid.model.boletim.Boletim;
import br.com.droid.model.usuario.Usuario;
import br.com.droid.persistencia.hibernate.GenericHibernateDAO;


public class UsuarioDAO extends GenericHibernateDAO<Usuario, Integer> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario getVerifiaLogin(Integer login, Long senha) {		
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("senha", senha));
		return (Usuario) criteria.uniqueResult();
	}
	
//	public List<Usuario> getListaUsuarios() {
//		Criteria criteria = getSession().createCriteria(Usuario.class);
////		criteria.add(Restrictions.eq("login", usuario.getLogin()));
//		return (List<Usuario>) criteria.list();
//	}
}
