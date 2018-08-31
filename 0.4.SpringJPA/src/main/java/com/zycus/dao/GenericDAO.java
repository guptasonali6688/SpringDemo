package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GenericDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public void add(Object object) {
		entityManager.persist(object);	
	}
	
	@Transactional
	public void update(Object object) {
		entityManager.merge(object);
	}

	@Transactional
	public void delete(Class clazz, Object id) {
		Object object = entityManager.find(clazz, id);
		entityManager.remove(object);
	}

	public <E>E fetchById(Class<E> clazz, Object id) {
		
		E e = entityManager.find(clazz, id);
		return e;
	}

	public <E> List<E> fetchAll(Class<E> clazz) {
		String jpql = "select o from "+clazz.getName()+" as o";
		return entityManager.createQuery(jpql).getResultList();
	}
}
