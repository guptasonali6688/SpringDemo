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
import org.springframework.stereotype.Component;

import com.zycus.dao.CarPartsDAO;
import com.zycus.entity.CarPart;

@Component
public class CarPartsDAOImpl implements CarPartsDAO {

	//dependency
	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tblcarparts values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, carPart.getPartNo());
			ps.setString(2, carPart.getName());
			ps.setString(3, carPart.getCarModel());
			ps.setDouble(4, carPart.getPrice());
			ps.setInt(5, carPart.getQuantity());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace(); //show stack Trace
		}finally {
			try { ps.close();}catch(Exception e) {}
			try {conn.close();}catch(Exception e) {}		
		}
	}

	public List<CarPart> getAvailable() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			conn = dataSource.getConnection();
			String sql = "select * from tblcarparts";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<CarPart> carPartslist = new ArrayList<CarPart>();
			while(rs.next()) {
				CarPart carPart = new CarPart();
				carPart.setPartNo(rs.getInt(1));
				carPart.setName(rs.getString(2));
				carPart.setCarModel(rs.getString(3));
				carPart.setPrice(rs.getDouble(4));
				carPart.setQuantity(rs.getInt(5));
				carPartslist.add(carPart);
			}
			return carPartslist;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			try { ps.close();}catch(Exception e) {}
			try {conn.close();}catch(Exception e) {}	
			try {rs.close();} catch(Exception e) {}
		}
		
	}

}
