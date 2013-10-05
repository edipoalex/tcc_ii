package br.com.droid.persistencia.entidadeDAO.boletim;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.droid.model.boletim.Boletim;
import br.com.droid.model.usuario.Usuario;
import br.com.droid.persistencia.hibernate.GenericHibernateDAO;

public class BoletimDAO extends GenericHibernateDAO<Boletim, Integer> {
	public BoletimDAO() {
		super(Boletim.class);
	}
	
	public List<Boletim> getBoletim(Usuario usuario) {
		Criteria criteria = getSession().createCriteria(Boletim.class);
		criteria.add(Restrictions.eq("login", usuario.getLogin()));
		return (List<Boletim>) criteria.list();
	}
}


