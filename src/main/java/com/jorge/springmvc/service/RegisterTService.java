package com.jorge.springmvc.service;

import java.util.List;

import com.jorge.springmvc.dto.ProductionDTO;



public interface RegisterTService {

	List<ProductionDTO> findAllProduction();
	
	void saveProduction(ProductionDTO production, Integer idUser);
	
}
