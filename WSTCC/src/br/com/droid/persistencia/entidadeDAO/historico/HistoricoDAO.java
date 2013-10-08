package br.com.droid.persistencia.entidadeDAO.historico;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import br.com.droid.model.historico.Historico;
import br.com.droid.model.usuario.Usuario;
import br.com.droid.persistencia.hibernate.GenericHibernateDAO;

public class HistoricoDAO extends GenericHibernateDAO<Historico, Integer> {
	public HistoricoDAO() {
		super(Historico.class);
	}
	
	public List<Historico> getHistorico(Usuario usuario) {
		Criteria criteria = getSession().createCriteria(Historico.class);
		criteria.add(Restrictions.eq("login", usuario.getLogin()));
		return (List<Historico>) criteria.list();
	}
	
	

}
