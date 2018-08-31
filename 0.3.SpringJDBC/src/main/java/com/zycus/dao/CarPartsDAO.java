package com.zycus.dao;

import java.util.List;

import com.zycus.entity.CarPart;

public interface CarPartsDAO {
	
	public void addNewPart(CarPart carPart);
	public List<CarPart> getAvailable();
}
