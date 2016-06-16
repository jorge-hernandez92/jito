package com.jorge.springmvc.dao;

import java.util.List;

import com.jorge.springmvc.model.Produccion;

public interface ProduccionDAO {
	
	void save(Produccion produccion);
	
	List<Produccion> getAllProduccion();
	
}
