package br.com.droid.persistencia;

import java.util.List;

import org.hibernate.Criteria;

public interface GenericDAO<T, ID> {

	/**
	 * Método para inserir um objeto no banco
	 * */
	public Integer inserir(T object);
	
	/**
	 * Método para editar um objeto no banco
	 * */
	public void editar(T object);
	
	/**
	 * Método para merge um objeto no banco
	 * */
	public T merge(T object);
	
	public T saveOrUpdate(T object);
	 
	/**
	 * Método para deletar um objeto no banco
	 * */
	public void deletar(T object);
	
	/**
	 * Método que virifica se determinado objeto existe no banco
	 * */
	public boolean existe(T object);
	
	/**
	 * Método que retorna um objeto por meio do seu id
	 * */
	public T obterId(ID id);
	
	/**
	 * Método que retorna um ou mais objetos por meio dos critérios
	 * */
	public List<T> pesquisar(Criteria creterio);
	
	/**
	 * Método que retorna a lista de todos os objetos no banco
	 * */
	public List<T> listarTodos();
	
	public List<T> listarTodos(Integer quantidade);
	
	public T load(ID id);
}

