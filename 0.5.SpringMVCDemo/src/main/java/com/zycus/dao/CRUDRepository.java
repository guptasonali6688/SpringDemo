package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Repository //alernate for component
@Transactional
public class CRUDRepository { //create,read,update,delete
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void add(Object object) {
		entityManager.persist(object);	
	}
	
	public void update(Object object) {
		entityManager.merge(object);
	}

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
