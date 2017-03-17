package br.com.i9virtual.imobby.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Interface de metodos padrao de persistencia.
 * 
 * @author Pio
 *
 * @param <T> Entidade
 * @param <ID> Identificador da entidade.
 */
public interface GenericRepository<T, ID extends Serializable> {

	/**
	 * Persiste objeto entity.
	 * @param entity Objeto a ser persistido.
	 * @return Objeto atualizado.
	 */
	T create(T entity);
	
	/**
	 * Busca objeto pelo seu id.
	 * @param id ID do objeto a ser recuperado.
	 * @return Objeto encontrado ou null caso busca não der resultado.
	 */
	T findById(ID id);
	
	/**
	 * Lista todos os objetos persistidos da entidade T.
	 * @return Lista de objetos persistidos da entidade T.
	 */
	List<T> findAll();
	
	List<T> find(int resultLimit);
	
	List<T> find(String orderedBy, boolean ascendant);
	
	List<T> find(String orderedBy, boolean ascendant, int resultLimit);
	
	/**
	 * Atualiza objeto entity.
	 * @param entity Objeto a ser atualizado.
	 * @return Objeto atualizado.
	 */
	T update(T entity);
	
	/**
	 * Remove objeto de persistente.
	 * @param entity Objeto a ser removido.
	 */
	void delete(T entity);
	
	/**
	 * Realiza busca de objetos segundo query informada.
	 * @param namedQueryName Query a ser utilizada para a busca.
	 * @return Lista de objetos resultantes da busca.
	 */
	List<T> findByNamedQuery(String namedQueryName);
	
	/**
	 * Realiza busca de objetos segundo query informada.
	 * @param namedQueryName Query a ser utilizada para a busca.
	 * @param resultLimit Limite de objetos a serem retornados.
	 * @return Lista de objetos resultantes da busca.
	 */
	List<T> findByNamedQuery(String namedQueryName, int resultLimit);
	
	/**
	 * Realiza busca de objetos segundo query informada e parametros de busca.
	 * @param namedQueryName Query a ser utilizada para a busca.
	 * @param parameters Parametros da busca.
	 * @return Lista de objetos resultantes da busca.
	 */
	List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters);
	
	/**
	 * Realiza busca de objetos segundo query informada e parametros de busca.
	 * @param namedQueryName Query a ser utilizada para a busca.
	 * @param parameters Parametros da busca.
	 * @param resultLimit Limite de objetos a serem retornados.
	 * @return Lista de objetos resultantes da busca.
	 */
	List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters, int resultLimit);
	
}
