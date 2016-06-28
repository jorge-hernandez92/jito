package com.jorge.springmvc.service;

import java.util.List;

import com.jorge.springmvc.dto.ProductionDTO;
import com.jorge.springmvc.model.Produccion;



public interface RegisterTService {

	List<ProductionDTO> findAllProduction();
	
	void saveProduction(Produccion produccion, Integer idUser);
	
}
