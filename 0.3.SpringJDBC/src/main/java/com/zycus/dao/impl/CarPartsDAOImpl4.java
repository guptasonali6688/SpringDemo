package com.zycus.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.dao.CarPartsDAO;
import com.zycus.entity.CarPart;

@Component
public class CarPartsDAOImpl4 implements CarPartsDAO {

	//dependency
	//@Autowired
	@PersistenceContext //for injecting the EntityManager, @Autowired doesn't work
	private EntityManager entityManager;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}

	public List<CarPart> getAvailable() {
		return entityManager.createQuery("select obj from CarPart as obj").getResultList();
					
	}

}
