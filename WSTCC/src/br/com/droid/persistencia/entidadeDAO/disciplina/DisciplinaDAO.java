package br.com.droid.persistencia.entidadeDAO.disciplina;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


import br.com.droid.model.disciplina.Disciplina;
import br.com.droid.persistencia.hibernate.GenericHibernateDAO;

public class DisciplinaDAO extends GenericHibernateDAO<Disciplina, Integer> {
	public DisciplinaDAO() {
		super(Disciplina.class);
	}
	
	public Disciplina getDisciplina(Integer id) {
		Criteria criteria = getSession().createCriteria(Disciplina.class);
		criteria.add(Restrictions.eq("codigo", id));
		return (Disciplina) criteria.uniqueResult();
	}
}
