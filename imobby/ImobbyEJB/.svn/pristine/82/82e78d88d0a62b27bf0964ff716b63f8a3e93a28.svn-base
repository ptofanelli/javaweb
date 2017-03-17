package br.com.i9virtual.imobby.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementa metodos genericos de manutencao de entidades.
 * 
 * @author Pio
 *
 * @param <T> Classe da entidade a ser gerenciada.
 * @param <ID> ID utilizado pela entidade.
 */
public abstract class AbstractGenericRepository<T, ID extends Serializable>
		implements GenericRepository<T, ID> {

	@PersistenceContext
	protected EntityManager em;

	public T create(T entity) {
		em.joinTransaction();
		em.persist(entity);
		em.flush();
		em.refresh(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		Class<T> entity = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		return (T) em.find(entity, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Class<T> entity = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = em.createQuery("SELECT obj FROM " + entity.getCanonicalName()
				+ " obj");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(int resultLimit){
		Class<T> entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = em.createQuery("SELECT obj FROM " + entity.getCanonicalName() + " obj");
		q.setMaxResults(resultLimit);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String orderedBy, boolean ascendant){
		Class<T> entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = em.createQuery("SELECT obj FROM " + entity.getCanonicalName() + " obj ORDER BY obj." + orderedBy + " " + (ascendant ? "ASC" : "DESC"));
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String orderedBy, boolean ascendant, int resultLimit){
		Class<T> entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = em.createQuery("SELECT obj FROM " + entity.getCanonicalName() + " obj ORDER BY obj." + orderedBy + " " + (ascendant ? "ASC" : "DESC"));
		q.setMaxResults(resultLimit);
		return q.getResultList();
	}

	public void delete(T entity) {
		em.joinTransaction();
		T e = em.merge(entity);
        if (e != null) {
            em.remove(e);
        }
	}

	public T update(T entity) {
		em.joinTransaction();
		return (T) em.merge(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String namedQueryName) {
		return em.createNamedQuery(namedQueryName).getResultList();
	}

	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		return findByNamedQuery(namedQueryName, parameters, 0);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);

		if (resultLimit > 0) {
			query.setMaxResults(resultLimit);
		}

		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return query.getResultList();
	}

}
