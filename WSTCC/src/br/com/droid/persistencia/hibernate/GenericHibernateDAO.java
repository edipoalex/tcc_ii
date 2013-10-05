package br.com.droid.persistencia.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.droid.persistencia.GenericDAO;

public class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	private Session session;
	private Class<T> classe;

	public GenericHibernateDAO(Class<T> classe){
		this.classe = classe;
	}
	/**
	 * Deletar o objeto
	 * */
	public void deletar(T object) {
		session.delete(object);
	}
	/**
	 * Update no objeto
	 * */
	public void editar(T object) {
		session.update(object);
	}
	/**
	 * Merge no objeto
	 * */
	@SuppressWarnings("unchecked")
	public T merge(T object) {
		return (T) session.merge(object);
	}
	
	public T saveOrUpdate(T object) {
		session.saveOrUpdate(object);
		return object; 
	}
	
	/**
	 * Verifica se existe
	 * */
	public boolean existe(T object) {
		return session.equals(object);
	}
	/**
	 * Insere um objeto
	 * */
	public Integer inserir(T object) {
		return (Integer) session.save(object);
	}
	/**
	 * Lista todos os objetos
	 * */
	@SuppressWarnings("unchecked")
	public List<T> listarTodos() {
		return session.createCriteria(this.classe).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(Integer quantidade) {
		return session.createCriteria(this.classe).setMaxResults(quantidade).list();
	}
	/**
	 * Obtem objeto pelo id
	 * */
	 @SuppressWarnings("unchecked")
	public T obterId(ID id) {
		return (T) session.get(this.classe, id);
	}
	 
	/**
	 * Pesquisa objetos por meio de um criterio
	 * */
	@SuppressWarnings("unchecked")
	public List<T> pesquisar(Criteria criterio) {
		 return criterio.list();
	}
	/**
	 * Pesquisa um objeto por meio de um criterio
	 * */
	@SuppressWarnings("unchecked")
	public T pesquisarUnicoResultado(Criteria criterio) {
		 return (T) criterio.uniqueResult();
	}
	/**
	 * Retorna a sessao
	 * */
	public Session getSession() {
		return session;
	}
	/**
	 * Seta a sessao
	 * */
	public void setSession(Session session) {
		this.session = session;
	}
	/**
	 * Retorna um objeto pelo id
	 * */
	@SuppressWarnings("unchecked")
	public T load(ID id) {
		return (T) session.load(this.classe,id);
	}

}
