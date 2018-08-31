package com.zycus.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.zycus.dao.CarPartsDAO;
import com.zycus.entity.CarPart;

@Component
public class CarPartsDAOImpl3 implements CarPartsDAO {

	//dependency
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addNewPart(CarPart carPart) {
		
		String sql = "insert into tblcarparts values(?,?,?,?,?)";
		jdbcTemplate.update(sql, carPart.getPartNo(),
								 carPart.getName(),
								 carPart.getCarModel(),
								 carPart.getPrice(),
								 carPart.getQuantity()
				
							);
		
	}

	public List<CarPart> getAvailable() {
		
		String sql = "select * from tblcarparts";
		return jdbcTemplate.query(sql, new CarPartRowMapper());
					
	}
	
	private class CarPartRowMapper implements RowMapper<CarPart>{

		public CarPart mapRow(ResultSet rs, int index) throws SQLException {
			
			CarPart carPart = new CarPart();
			carPart.setPartNo(rs.getInt(1));
			carPart.setName(rs.getString(2));
			carPart.setCarModel(rs.getString(3));
			carPart.setPrice(rs.getDouble(4));
			carPart.setQuantity(rs.getInt(5));
			return carPart;
		}
		
	}

}
