package br.com.droid.persistencia;

import java.util.List;

import org.hibernate.Criteria;

public interface GenericDAO<T, ID> {

	/**
	 * M�todo para inserir um objeto no banco
	 * */
	public Integer inserir(T object);
	
	/**
	 * M�todo para editar um objeto no banco
	 * */
	public void editar(T object);
	
	/**
	 * M�todo para merge um objeto no banco
	 * */
	public T merge(T object);
	
	public T saveOrUpdate(T object);
	 
	/**
	 * M�todo para deletar um objeto no banco
	 * */
	public void deletar(T object);
	
	/**
	 * M�todo que virifica se determinado objeto existe no banco
	 * */
	public boolean existe(T object);
	
	/**
	 * M�todo que retorna um objeto por meio do seu id
	 * */
	public T obterId(ID id);
	
	/**
	 * M�todo que retorna um ou mais objetos por meio dos crit�rios
	 * */
	public List<T> pesquisar(Criteria creterio);
	
	/**
	 * M�todo que retorna a lista de todos os objetos no banco
	 * */
	public List<T> listarTodos();
	
	public List<T> listarTodos(Integer quantidade);
	
	public T load(ID id);
}

